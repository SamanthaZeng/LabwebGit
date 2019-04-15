package zxl.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import zxl.web.domain.Teacher;
import zxl.web.domain.User;
import zxl.web.service.ITeacherService;
import zxl.web.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    ITeacherService teacherService;

    @Autowired
    IUserService userService;

    @RequestMapping("/index")
    public String index(Model model)
    {
       List<Teacher>teachers=teacherService.queryAll();
       model.addAttribute("teachers",teachers);//存到model里面，页面可以取出来
        return "teacher/teacher_list";
    }
    /*教师注册*/
    @RequestMapping("/register")
    public String register(Teacher teacher, MultipartFile imgFile, HttpServletRequest req) throws IOException{
        //获取USER对象
        User user = (User)req.getSession().getAttribute("user");
        userService.register(user);
        teacher.setId(user.getId());
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
            user.setImgurl("/uploadFile/"+newFileName);
            //存放图片地址
        }
        teacherService.register(teacher,user);
        req.getSession().setAttribute("user",userService.selectuser(user.getId()));  //注册完成后会有tid的更新，在之后要用到，所以需要重新载入这个user
        return "redirect:/admin/main";
    }
}
