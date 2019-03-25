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
        model.addAttribute("papers", papers);
        return "paper/paper_list";
    }

    @RequestMapping("/add")
    public String add(Model model)
    {
        List<User> users=userService.queryAll();
        model.addAttribute("users",users);
        return "/paper/edit";
    }

    @RequestMapping("/edit")
    public String edit(HttpServletRequest req, Model model)
    {
        String pid = req.getParameter("pid");
        System.out.println(pid);
        Paper paperForEdit = paperService.selectPaper(Integer.parseInt(pid));
        List<Project> projects = projectService.queryAll();
        List<Project> associations = paperProjectService.selectAssociationProject(Integer.parseInt(pid));
        model.addAttribute("associations", associations);
        model.addAttribute("projects", projects);
        model.addAttribute("paperForEdit", paperForEdit);
        return "/paper/edit";
    }

    @RequestMapping("/save")
    public String edit(Paper paper, HttpServletRequest req, MultipartFile pdfFile) throws IOException {
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
        /*获取相关项目、作者*/
        String[] proid = req.getParameterValues("paperproject");
        if(proid != null)
        {
            for(int i=0;i<proid.length;i++)
                System.out.println(proid[i]);
        }
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
            //把数据保存到数据库
            if(proid != null)
                for(int i=0; i<proid.length; i++)
                    paperProjectService.save(new PaperProject(Integer.parseInt(proid[i]), paper.getPid()));
            paperService.save(paper);
        }

        /*增加/更新userpaper表*/
        //获取Paperid
        int pid=paperService.selectPid(paper);
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
            if(authors.length!=0){
                for(int i=0;i<authors.length;i++){
                    author.setId(Integer.valueOf(authors[i]));
                    author.setAuthornumber(i);
                    userPaperService.insert(author);
                }
            }
        }else{//添加
            UserPaper author=new UserPaper();
            author.setPid(pid);
            if(authors.length!=0){
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
