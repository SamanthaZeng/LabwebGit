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

    @RequestMapping("/index")
    public String index(Model model)
    {
        List<Paper> papers = paperService.queryAll();
        model.addAttribute("papers", papers);
        return "paper/paper_list";
    }

    @RequestMapping("/add")
    public String add(Model model)
    {
        List<Project> projects = projectService.queryAll();
        model.addAttribute("projects", projects);
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
    public String edit(Paper paper, HttpServletRequest req, Model model, MultipartFile pdfFile) throws IOException {
        System.out.println(paper.getPtitile());
        System.out.println(paper.getKeyword());
        System.out.println(paper.getPublictime());
        System.out.println(paper.getPid());
        System.out.println(paper.getPabstract());
        System.out.println(paper.getPapersource());

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
        String[] proid = req.getParameterValues("paperproject");
        if(proid != null)
        {
            for(int i=0;i<proid.length;i++)
                System.out.println(proid[i]);
        }
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
            List<Paper> queryForId = paperService.selectPaperId(paper);
            if(proid != null)
                for(int i=0; i<proid.length; i++)
                    paperProjectService.save(new PaperProject(Integer.parseInt(proid[i]), queryForId.get(0).getPid()));
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
