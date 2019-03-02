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
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        for(int i=0;i<papers.size();i++)
        {
            System.out.println(papers.get(i).getPublictime());
        }
        model.addAttribute("papers", papers);
        return "paper/paper_list";
    }
}
