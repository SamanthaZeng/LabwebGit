package zxl.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zxl.web.domain.Student;
import zxl.web.domain.User;
import zxl.web.service.IClassesService;
import zxl.web.service.IStudentService;
import zxl.web.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    //未完成后端功能，只用来对前端路由和分发进行测试
    @Autowired
    private IClassesService classesService;
    @Autowired
    private IStudentService studentService;

    @RequestMapping("/main") // 个人主页面
    public String mainInfo(Model model, HttpServletRequest request)
    {
        //List<Student> lists=studentService.queryAll();
        //model.addAttribute("student",lists);//存到model里面，页面可以取出来
       // System.out.println(request.getSession().getAttribute("user"));
        return "admin/main";
    }
}
