package zxl.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import zxl.web.domain.Classes;
import zxl.web.domain.Student;
import zxl.web.domain.Students;
import zxl.web.domain.User;
import zxl.web.service.IClassesService;
import zxl.web.service.IStudentService;
import zxl.web.service.IStudentsService;
import zxl.web.service.IUserService;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/student")//路径
public class StudentController {
    //注入service层
    @Autowired
    private IStudentService studentService;

    //注入classesService层
    @Autowired
    private IClassesService classesService;

    @Autowired
    private IStudentsService studentsService;

    @Autowired
    private IUserService userService;

    @RequestMapping("/index")
    public String index(Model model)
    {
        //WEB-INF/views/student/index.jsp
        List<Students>students=studentsService.queryAll();
        model.addAttribute("students",students);//存到model里面，页面可以取出来
        return "student/student_list";
    }

    //学生注册内容
    @RequestMapping("/register")
    public String register(Students students,MultipartFile imgFile, HttpServletRequest req) throws IOException//imgFile要与Student_list上的Imgfile对上
    {
        //获取USER对象
        User user = (User)req.getSession().getAttribute("user");
        userService.register(user);
        students.setId(user.getId());
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
        studentsService.register(students,user);
        req.getSession().setAttribute("user",userService.selectuser(user.getId()));
        return "redirect:/admin/main";
    }
}
