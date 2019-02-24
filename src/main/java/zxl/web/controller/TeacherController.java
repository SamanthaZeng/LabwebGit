package zxl.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zxl.web.domain.Student;
import zxl.web.service.IClassesService;
import zxl.web.service.IStudentService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @RequestMapping("/index")
    public String index(Model model)
    {
        System.out.println("SpringMVC配置成功");
        //WEB-INF/views/student/index.jsp
////        List<Student>lists=studentService.queryAll();
//        model.addAttribute("students",lists);//存到model里面，页面可以取出来
        // System.out.println(lists);
        return "student/student_list";
    }
}
