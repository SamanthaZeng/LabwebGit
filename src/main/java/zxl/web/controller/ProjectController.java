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

    @RequestMapping("/index")
    public String index(Model model)
    {
        List<Project> projects = projectService.queryAll();
        for(int i=0;i<projects.size();i++)
        {
            System.out.println(projects.get(i).getProname());
        }
        model.addAttribute("projects", projects);
        return "/project/project_list";
    }

    @RequestMapping("/edit")
    public String edit(HttpServletRequest req, Model model)
    {
        String proid = req.getParameter("proid");
        Project projectForEdit = projectService.selectProject(Integer.parseInt(proid));
        List<Paper> papers = paperService.queryAll();
        List<Paper> associations = paperProjectService.selectAssociation(Integer.parseInt(proid));
        for(int i=0;i<papers.size();i++)
        {
            System.out.println(papers.get(i).getPtitile());
        }
        model.addAttribute("associations", associations);
        model.addAttribute("papers", papers);
        model.addAttribute("projectForEdit", projectForEdit);
        return "project/edit";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest req, Model model)
    {
        List<Paper> papers = paperService.queryAll();
        List<Paper> associations = null;
        model.addAttribute("associations", associations);
        model.addAttribute("papers", papers);
        return "project/edit";
    }


    @RequestMapping("/save")
    public String save(Project project, HttpServletRequest req, Model model) {
        String[] pid = req.getParameterValues("paperproject");
        if(pid != null)
        {
            for(int i=0;i<pid.length;i++)
                System.out.println(pid[i]);
        }
        if(project!=null && project.getProid()!=null&&!"".equals(project.getProid())){
            List<Paper> uselessRecord = paperProjectService.selectAssociation(project.getProid());
            for(int i=0; i<uselessRecord.size();i++) {
                paperProjectService.deleteAssociation(new PaperProject(uselessRecord.get(i), project));
            }
            for(int i=0; i<pid.length;i++) // 添加项目关联的论文
            {
                paperProjectService.save(new PaperProject(project, Integer.parseInt(pid[i])));
            }
            projectService.update(project);
        }else{
            //把数据保存到数据
            for(int i=0; i<pid.length;i++) // 添加项目关联的论文
            {
                paperProjectService.save(new PaperProject(project, Integer.parseInt(pid[i])));
            }
            projectService.save(project);
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
