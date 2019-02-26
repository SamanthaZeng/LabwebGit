package zxl.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zxl.web.domain.User;
import zxl.web.service.IUserService;

import java.sql.Date;

@Controller
@RequestMapping("/user")
public class UserController {
   //注入service层
    @Autowired
    private IUserService userService;

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
       return "student/register";
    }
}
