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
    private IUserService userService;

    @Autowired
    private IPaperService paperService;

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
        return "/paper/edit";
    }

    @RequestMapping("/edit")
    public String edit(HttpServletRequest req, Model model)
    {
        String pid = req.getParameter("pid");
        System.out.println(pid);
        Paper paperForEdit = paperService.selectPaper(Integer.parseInt(pid));
        System.out.println(paperForEdit.getPtitile());
        model.addAttribute("paperForEdit", paperForEdit);
        return "/paper/edit";
    }

    @RequestMapping("/save")
    public String edit(Paper paper, HttpServletRequest req, Model model, MultipartFile pdfFile) throws IOException {
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
        if(paper!=null && paper.getPid()!=null&&!"".equals(paper.getPid())){
            paperService.update(paper);
        }else{
            //把数据保存到数据
            paperService.save(paper);
        }
        return "redirect:/paper/index";
    }
}
