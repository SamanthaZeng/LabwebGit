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
        //WEB-INF/views/student/index.jsp
        System.out.println("获取教师数据");
       List<Teacher>teachers=teacherService.queryAll();
       for(int i=0;i<teachers.size();i++)
       {
           System.out.println(teachers.get(i).toString());
           System.out.println(teachers.get(i).getUser().getUsername());
       }
       model.addAttribute("teachers",teachers);//存到model里面，页面可以取出来
//        model.addAttribute("students",lists);//存到model里面，页面可以取出来
        // System.out.println(lists)
        return "teacher/teacher_list";
    }
    @RequestMapping("/edit")
    public String edit(Teacher teacher,Model model){
        //根据stu里面的id 查询数据 放到页面进行回显操作
        Teacher testTeacher = new Teacher();
        testTeacher.setId(10086);
        testTeacher.setTid(5);
        testTeacher.setTmail("test@qq.com");
        model.addAttribute("teacher",teacher);
        User testUser = new User();
        return "teacher/teacher_input";
    }
    /*教师注册*/
    @RequestMapping("/register")
    public String register(Teacher teacher, MultipartFile imgFile, HttpServletRequest req) throws IOException{
      //  System.out.println("teacher-registration succeed!");
        //获取USER对象
        User user=userService.selectuser(teacher.getId());
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
        teacherService.register(teacher,user);
        req.getSession().setAttribute("user",user);
        return "redirect:/admin/main";
    }
}
