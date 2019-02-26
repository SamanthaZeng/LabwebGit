package zxl.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zxl.web.domain.Cooperator;
import zxl.web.domain.Students;
import zxl.web.domain.Teacher;
import zxl.web.domain.User;
import zxl.web.service.IStudentsService;
import zxl.web.service.ITeacherService;
import zxl.web.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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

    //WEB-INF/login.jsp
    @RequestMapping("/register")
    public String register(String username, String pwd, @DateTimeFormat(pattern="yyyy-MM-dd")Date birthday, int sex, int usertype, boolean isadmin, Model model)
    {
        System.out.println(username+pwd+birthday+sex+usertype+isadmin);
        User user = new User();
        user.setUsername(username);
        user.setPwd(pwd);
        user.setBirthday(birthday);
        user.setSex(sex);
        user.setUsertype(usertype);
        user.setIsadmin(isadmin);
        userService.register(user);
        model.addAttribute("user",user);
        if(usertype==0)
            return "teacher/register";
        if(usertype==1)
            return "student/register";
        if(usertype==2)
            return "cooperator/register";
        else
            return "redirect:/login.jsp";
    }

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request)
    {
        System.out.println("user-login success");
        User newuser=userService.login(user);
        System.out.println(newuser.toString());
        if(newuser!=null){
            //把信息存入session里面 页面
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

    //返回登陆页面
        return "redirect:/login.jsp";
    }

    @RequestMapping("/save")
    public String save(User user)
    {
        return null;
    }


}
