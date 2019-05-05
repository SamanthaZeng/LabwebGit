package zxl.web.controller;

import org.apache.ibatis.annotations.Arg;
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
    private IResearchareaService researchareaService;

    @Autowired
    private IProjectService projectService;

    @Autowired
    private IProResearchService proResearchService;

    @Autowired
    private  IUserService userService;

    @Autowired
    private IUserProService userProService;

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
        for(int i=0;i<projects.size();i++)
        {
            String users = "";
            List<UserPro> userPros = userProService.selectUPs(projects.get(i).getProid());
            for(int j=0;j<userPros.size() && j<3;j++)
            {
                String associationUser = userService.selectuser(userPros.get(j).getId()).getRealname();
                if(associationUser != null)
                    users += associationUser + " ";
            }
            projects.get(i).setProabstract(users);
        }
        model.addAttribute("projects", projects);
        return "/project/project_list";
    }

    @RequestMapping("/edit")
    public String edit(HttpServletRequest req, Model model)
    {
        int proid = Integer.parseInt(req.getParameter("proid"));
        Project projectForEdit = projectService.selectProject(proid);
        List<Researcharea> researchareas = researchareaService.queryAll();
        List<Researcharea> associations = proResearchService.findByProid(proid);
        List<User> users = userService.queryAll();
        List<UserPro> userPros = userProService.selectUPs(proid);
        ArrayList proUsers = new ArrayList();
        for(int i=0;i<userPros.size();i++)
        {
            proUsers.add(userPros.get(i).getId());
        }
        model.addAttribute("researchareas", researchareas);
        model.addAttribute("proUsers", proUsers);
        model.addAttribute("associations", associations);
        model.addAttribute("users",users);
        model.addAttribute("projectForEdit", projectForEdit);
        return "project/edit";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest req, Model model)
    {
        List<User> users=userService.queryAll();
        model.addAttribute("users",users);
        return "project/edit";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest req)
    {
        int proid = Integer.parseInt(req.getParameter("proid"));
        projectService.delete(proid);
        return "redirect:/project/index";
    }

    @RequestMapping("/save")
    public String save(Project project, HttpServletRequest req) {
        String proResearcharea[] = req.getParameterValues("proResearcharea");
        String authors[] = req.getParameterValues("authors");
        /*增加/更新project表*/
        if(project!=null && project.getProid()!=null&&!"".equals(project.getProid())){
            projectService.update(project);
        }else{
            projectService.save(project);
        }

        /*增加或更新userpro表*/
        //1.获取项目Id
        int proid = project.getProid();

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
            if(authors!=null){
                for(int i=0;i<authors.length;i++){
                    author.setId(Integer.valueOf(authors[i]));
                    userProService.insert(author);
                }
            }
        }else {//添加
            UserPro author=new UserPro();
            author.setProid(proid);
            if(authors!=null){
                for(int i=0;i<authors.length;i++){
                    author.setId(Integer.valueOf(authors[i]));
                    userProService.insert(author);
                }
            }
        }

        //3.添加或更新proresearch表
        List<Researcharea> researchareas = proResearchService.findByProid(proid);
        ProResearchKey proResearchKey = new ProResearchKey();
        proResearchKey.setProid(proid);
        if (researchareas.size() != 0) {
            proResearchService.deleteByProid(proid);
        }
        if(proResearcharea != null){
            for(int i = 0; i < proResearcharea.length; i++) {
                proResearchKey.setRid(Integer.parseInt(proResearcharea[i]));
                proResearchService.insert(proResearchKey);
            }
        }
        return "redirect:/project/index";
    }

    public static boolean ifInPid(List<Researcharea> associations, int forTest)
    {
        for(int i=0; i<associations.size(); i++)
        {
            if(forTest == associations.get(i).getRid())
                return true;
        }
        return false;
    }
}
