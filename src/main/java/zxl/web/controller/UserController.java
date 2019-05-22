package zxl.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zxl.web.domain.*;
import zxl.web.service.ICompanyService;
import zxl.web.service.IStudentsService;
import zxl.web.service.ITeacherService;
import zxl.web.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
   //注入service层
    @Autowired
    private IUserService userService;

    @Autowired
    private ITeacherService teacherService;

    @Autowired
    private IStudentsService studentsService;

    @Autowired
    private ICompanyService companyService;

    //WEB-INF/login.jsp
    @RequestMapping("/register")
    public String register(User user, Model model, HttpServletRequest req, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<String> names = userService.selectUsername();
        for(String name: names) {
            if(name.equals(user.getUsername()))
            {
                return "redirect:/login.jsp";
            }
        }
        req.getSession().setAttribute("user", user);
        System.out.println(user);
        int usertype = user.getUsertype();
        if(usertype==0)
            return "teacher/register";
        if(usertype==1)
            return "student/register";
        else
            return "redirect:/login.jsp";
    }

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request)
    {
        System.out.println("user-login success");
        User newuser=userService.login(user);
        if(newuser!=null){
            //把信息存入session里面
            System.out.println("newuser is not null");
            request.getSession().setAttribute("user",newuser);
            if(newuser.getUsertype()==0)//老师
            {
                System.out.println("user is a teacher");
                Teacher teacher=teacherService.select(newuser.getTid());
                System.out.println(teacher.toString());
                request.getSession().setAttribute("teacher",teacher);
            }else{
                if(newuser.getUsertype()==1)//学生
                {
                    System.out.println("user is a student");
                    Students students=studentsService.select(newuser.getSid());
                    System.out.println(students.toString());
                    request.getSession().setAttribute("students",students);
                }
            }
            return "redirect:/admin/main";
        }
    //返回登录页面
        return "redirect:/login.jsp";
    }

}
