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
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/project")//路径
public class ProjectController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IProjectService projectService;

    @RequestMapping("/index")
    public String index(Model model)
    {
        List<Project> projects = projectService.queryAll();
        for(int i=0;i<projects.size();i++)
        {
            System.out.println(projects.get(i).getProname());
        }
        model.addAttribute("projects", projects);
        return "project/project_list";
    }
}
