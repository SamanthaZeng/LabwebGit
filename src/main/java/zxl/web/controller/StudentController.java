package zxl.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import zxl.web.domain.Classes;
import zxl.web.domain.Student;
import zxl.web.service.IClassesService;
import zxl.web.service.IStudentService;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    @RequestMapping("/index")
    public String index(Model model)
    {
        System.out.println("SpringMVC配置成功");
        //WEB-INF/views/student/index.jsp
        List<Student>lists=studentService.queryAll();
        model.addAttribute("students",lists);//存到model里面，页面可以取出来
       // System.out.println(lists);
        return "student/student_list";
    }

    @RequestMapping("/delete")
    public String delete(Student stu){

        studentService.delete(stu);
        //调用service层的删除方法把数据删除
        return "redirect:/student/index";
   }

   //新增跳转方法--保存数据
   @RequestMapping("/add")
    public String add(Model model){
        List<Classes>lists=classesService.queryAll();
        System.out.println(lists);
        model.addAttribute("classes",lists);
        System.out.println("add successful");
        return "student/student_input";
   }

   //保存数据方法
    @RequestMapping("/save")
   public String save(Student student, MultipartFile imgFile, HttpServletRequest req,Model model) throws IOException//imgFile要与Student_list上的Imgfile对上
    {
        System.out.println("成功进入save");
        //完成上传功能
        if(imgFile !=null){
            //获取文件夹路径
           //String path=req.getSession().getServletContext().getRealPath("/uploadFile");
            String path="F:/计算机/大四/毕业设计项目/代码/LabWeb_SSM/src/main/webapp/uploadFile";
            //System.out.println(path);
            //文件名称UID解决文件名称问题
            String filename=imgFile.getOriginalFilename();
            //System.out.println(filename);
            String newFileName=UUID.randomUUID().toString()+"."+ StringUtils.getFilenameExtension(filename);
            //System.out.println(newFileName);
            //先构造一个文件出来
            File file=new File(path,newFileName);
            //把imgFile写到file里
            org.apache.commons.io.IOUtils.copy(imgFile.getInputStream(),new FileOutputStream(file));
            //存放图片地址
            student.setImgUrl("/uploadFile/"+newFileName);
        }
        if(student!=null && student.getId()!=null&&!"".equals(student.getId())){
            studentService.update(student);
        }else{
            //把数据保存到数据
            studentService.save(student);
        }
        return "redirect:/student/index";
    }

    //修改数据方法---跳转方法---把修改数据显示到页面
    @RequestMapping("/edit")
    public String edit(Student student,Model model){
        //根据stu里面的id 查询数据 放到页面进行回显操作
        Student student1=studentService.queryOne(student);
        //查询班级
        model.addAttribute("classes",classesService.queryAll());
        model.addAttribute("student",student1);//在script，JQuery中已经通过student取出,var selectVal = "${student.classes.id}";,所以命名为student
        return "student/student_input";
    }

    //登陆方法
    @RequestMapping("/login")
    public String login(Student student,HttpServletRequest request){
        Student currentStu=studentService.login(student);
        if(currentStu!=null){
            //把信息存入session里面 页面
            request.getSession().setAttribute("currentStu",currentStu);
            return "redirect:/classes/index";
        }
        //返回登陆页面
        return "redirect:/login.jsp";
    }

}
