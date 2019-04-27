package zxl.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import zxl.web.domain.*;
import zxl.web.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ReportAsSingleViolation;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/paper")//路径
public class PaperController {

    @Autowired
    private IPaperProjectService paperProjectService;

    @Autowired
    private IPaperService paperService;

    @Autowired
    private IProjectService projectService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserPaperService userPaperService;

    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest req)
    {
        List<Paper> papers = null;
        User user = (User) req.getSession().getAttribute("user");
        if(user.getIsadmin() == true)
        {
            papers = paperService.queryAll();
        }
        else{
            papers = new ArrayList<>();
            List<UserPaper> userPaperList = userPaperService.selectUPpsById(user.getId());
            for(int i=0; i<userPaperList.size();i++)
            {
                papers.add(paperService.selectPaper(userPaperList.get(i).getPid()));
            }
        }
        for(int i=0;i<papers.size();i++)
        {
            papers.get(i).setKeyword(NewsController.cutStr(papers.get(i).getKeyword(), 50));
            String users = "";
            List<UserPaper> userPapers = userPaperService.selectUPps(papers.get(i).getPid());
            for(int j=0;j<userPapers.size() && j<3;j++)
            {
                String associationUser = userService.selectuser(userPapers.get(j).getId()).getRealname();
                if(associationUser != null)
                    users += associationUser + " ";
            }
            papers.get(i).setPabstract(users);
        }
        model.addAttribute("papers", papers);
        return "paper/paper_list";
    }

    @RequestMapping("/add")
    public String add(Model model)
    {
        List<User> users=userService.queryAll();
        model.addAttribute("users",users);
        List<Project> projects = projectService.queryAll();
        model.addAttribute("projects", projects);
        return "/paper/edit";
    }

    @RequestMapping("/edit")
    public String edit(HttpServletRequest req, Model model)
    {
        int pid = Integer.parseInt(req.getParameter("pid"));
        Paper paperForEdit = paperService.selectPaper(pid);
        List<Project> projects = projectService.queryAll();
        List<User> users = userService.queryAll();
        List<Project> associations = paperProjectService.selectAssociationProject(pid);
        List<UserPaper> userPapers = userPaperService.selectUPps(pid);
        ArrayList paperUsers = new ArrayList();
        for(int i=0;i<userPapers.size();i++)
        {
            paperUsers.add(userPapers.get(i).getId());
        }
        model.addAttribute("associations", associations);
        model.addAttribute("projects", projects);
        model.addAttribute("users", users);
        model.addAttribute("paperForEdit", paperForEdit);
        model.addAttribute("paperUsers", paperUsers);
        return "/paper/edit";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest req)
    {
        int pid = Integer.parseInt(req.getParameter("pid"));
        paperService.deleteByPid(pid);
        return "redirect:/paper/index";
    }

    @RequestMapping("/save")
    public String save(Paper paper, HttpServletRequest req, MultipartFile pdfFile) throws IOException {
       System.out.println("进入papersave, pid= "+paper.getPid());
        /*获取上传的论文文件*/
        if(pdfFile !=null){
            //获取文件夹路径
            String path = req.getServletContext().getRealPath("/uploadFile");
            //文件名称UID解决文件名称问题
            String filename=pdfFile.getOriginalFilename();
            String newFileName=UUID.randomUUID().toString()+"."+ StringUtils.getFilenameExtension(filename);
            //先构造一个文件出来
            File file=new File(path,newFileName);
            org.apache.commons.io.IOUtils.copy(pdfFile.getInputStream(),new FileOutputStream(file));
            paper.setPaperurl("/uploadFile/"+newFileName);
        }

        /*获取论文索引*/
        String [] indexs = req.getParameterValues("paperindex");
        int index = 0;
        for(int i=0;i<indexs.length;i++)
        {
            index += Math.pow(2, (double)(Integer.parseInt(indexs[i])));
        }
        paper.setPaperindex(index);
        /*获取相关项目、作者*/
        String[] proid = req.getParameterValues("paperproject");
        String authors[]=req.getParameterValues("authors");

        /*增加/更新paper表*/
        if(paper!=null && paper.getPid()!=null&&!"".equals(paper.getPid())){
            List<Project> uselessRecord = paperProjectService.selectAssociationProject(paper.getPid());
            if(uselessRecord != null)
                for(int i=0; i<uselessRecord.size(); i++)
                    paperProjectService.deleteAssociation(new PaperProject(paper, uselessRecord.get(i)));
            if(proid != null)
                for(int i=0; i<proid.length; i++)
                    paperProjectService.save(new PaperProject(Integer.parseInt(proid[i]), paper.getPid()));
            paperService.update(paper);
        }else{
            paperService.save(paper);
            //把数据保存到数据库
            if(proid != null)
                for(int i=0; i<proid.length; i++)
                    paperProjectService.save(new PaperProject(Integer.parseInt(proid[i]), paper.getPid()));
        }
        int pid = paper.getPid();
        //添加/更新userpaper表
        List<UserPaper> userPapers=userPaperService.selectUPps(pid);
        UserPaperKey userPaperKey=new UserPaperKey();
        userPaperKey.setPid(pid);
        int id;
        if(userPapers.size()!=0) {//更新
            for(int i=0;i<userPapers.size();i++){
                id=userPapers.get(i).getId();
                userPaperKey.setId(id);
                userPaperService.deletepid(userPaperKey);
            }
            UserPaper author=new UserPaper();
            author.setPid(pid);
            if(authors!=null){
                for(int i=0;i<authors.length;i++){
                    author.setId(Integer.valueOf(authors[i]));
                    author.setAuthornumber(i);
                    userPaperService.insert(author);
                }
            }
        }else{//添加
            UserPaper author=new UserPaper();
            author.setPid(pid);
            if(authors!=null){
                for(int i=0;i<authors.length;i++){
                    author.setId(Integer.valueOf(authors[i]));
                    author.setAuthornumber(i);
                    userPaperService.insert(author);
                }
            }
        }
        return "redirect:/paper/index";
    }

    public static boolean ifInPid(List<Project> associations, int forTest)
    {
        for(int i=0; i<associations.size(); i++)
        {
            if(forTest == associations.get(i).getProid())
                return true;
        }
        return false;
    }
}
