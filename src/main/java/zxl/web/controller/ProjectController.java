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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/project")//路径
public class ProjectController {

    @Autowired
    private IPaperProjectService paperProjectService;

    @Autowired
    private IProjectService projectService;

    @Autowired
    private IPaperService paperService;

    @Autowired
    private  IUserService userService;

    @Autowired IUserProService userProService;

    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest req)
    {
        List<Project> projects = null;
        User user = (User) req.getSession().getAttribute("user");
        if(user.getIsadmin() == true)
        {
            projects = projectService.queryAll();
        }
        else{
            projects = new ArrayList<>();
            List<UserPro> userProList = userProService.selectUPsById(user.getId());
            for(int i=0; i<userProList.size();i++)
            {
                projects.add(projectService.selectProject(userProList.get(i).getProid()));
            }
        }
        model.addAttribute("projects", projects);
        return "/project/project_list";
    }

    @RequestMapping("/edit")
    public String edit(HttpServletRequest req, Model model)
    {
        String proid = req.getParameter("proid");
        Project projectForEdit = projectService.selectProject(Integer.parseInt(proid));
//        List<Paper> papers = paperService.queryAll();
//        List<Paper> associations = paperProjectService.selectAssociation(Integer.parseInt(proid));
//        for(int i=0;i<papers.size();i++)
//        {
//            System.out.println(papers.get(i).getPtitile());
//        }
//        model.addAttribute("associations", associations);
//        model.addAttribute("papers", papers);
        model.addAttribute("projectForEdit", projectForEdit);
        return "project/edit";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest req, Model model)
    {
//        List<Paper> papers = paperService.queryAll();
//        List<Paper> associations = null;
//        model.addAttribute("associations", associations);
//        model.addAttribute("papers", papers);
        List<User> users=userService.queryAll();
        model.addAttribute("users",users);
        return "project/edit";
    }


    @RequestMapping("/save")
    public String save(Project project, HttpServletRequest req) {
        String authors[]=req.getParameterValues("authors");
        /*增加/更新project表*/
        if(project!=null && project.getProid()!=null&&!"".equals(project.getProid())){
            projectService.update(project);
        }else{
            projectService.save(project);
        }

        /*增加或更新userpro表*/
        //1.获取项目Id
        int proid;
        proid=projectService.selectProid(project);

        //2.添加或更新Userpro表
        List<UserPro> userPros=userProService.selectUPs(proid);
        UserProKey userProKey=new UserProKey();
        userProKey.setProid(proid);
        int id;
        if(userPros.size()!=0)//更新
        {
            for(int i=0;i<userPros.size();i++){
                id=userPros.get(i).getId();
                userProKey.setId(id);
                //删除掉所有proid=#{proid}的值
                userProService.deleteproid(userProKey);
            }
            UserPro author=new UserPro();
            author.setProid(proid);
            if(authors.length!=0){
                for(int i=0;i<authors.length;i++){
                    author.setId(Integer.valueOf(authors[i]));
                    userProService.insert(author);
                }
            }
        }else {//添加
            UserPro author=new UserPro();
            author.setProid(proid);
            if(authors.length!=0){
                for(int i=0;i<authors.length;i++){
                    author.setId(Integer.valueOf(authors[i]));
                    userProService.insert(author);
                }
            }
        }
        return "redirect:/project/index";
    }


    public static boolean ifInPid(List<Paper> associations, int forTest)
    {
        for(int i=0; i<associations.size(); i++)
        {
            if(forTest == associations.get(i).getPid())
                return true;
        }
        return false;
    }

}
