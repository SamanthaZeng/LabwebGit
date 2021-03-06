package zxl.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import zxl.web.domain.Company;
import zxl.web.domain.Cooperator;
import zxl.web.domain.Teacher;
import zxl.web.domain.User;
import zxl.web.service.ICompanyService;
import zxl.web.service.ICooperatorService;
import zxl.web.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


@Controller
@RequestMapping("/cooperator")
public class CooperatorController {
    @Autowired
    IUserService userService;

    @Autowired
    ICooperatorService cooperatorService;

    @RequestMapping("/index")
    public String index(Model model)
    {
        List<Cooperator>cooperators=cooperatorService.queryAll();
        model.addAttribute("cooperators",cooperators);
        for(int i=0; i<cooperators.size();i++)
        {
            System.out.println(cooperators.get(i));
        }
        return "cooperator/cooperator_list";
    }

    @RequestMapping("/register")
    public String register(Cooperator cooperator, MultipartFile imgFile, HttpServletRequest req) throws IOException {
        //  System.out.println("teacher-registration succeed!");
        //获取USER对象
        User user=userService.selectuser(cooperator.getId());
        //完成上传功能
        if(imgFile !=null){
            //获取文件夹路径
            String path = req.getServletContext().getRealPath("/uploadFile");
            //文件名称UID解决文件名称问题
            String filename=imgFile.getOriginalFilename();
            String newFileName=UUID.randomUUID().toString()+"."+ StringUtils.getFilenameExtension(filename);
            //先构造一个文件出来
            File file=new File(path,newFileName);
            //把imgFile写到file里
            org.apache.commons.io.IOUtils.copy(imgFile.getInputStream(),new FileOutputStream(file));
            //存放图片地址
            user.setImgurl("/uploadFile/"+newFileName);
        }
        cooperatorService.register(cooperator,user);
        req.getSession().setAttribute("user",userService.selectuser(user.getId()));
        return "redirect:/admin/main";
    }
}
