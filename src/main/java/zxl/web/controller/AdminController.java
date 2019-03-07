package zxl.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @Autowired
    private  IUserService userService;

    @RequestMapping("/main") // 个人主页面
    public String mainInfo(Model model, HttpServletRequest request)
    {
        //List<Student> lists=studentService.queryAll();
        //model.addAttribute("student",lists);//存到model里面，页面可以取出来
        // System.out.println(request.getSession().getAttribute("user"));
        return "admin/main";
    }

    @RequestMapping("/edit")
    public String edit(HttpServletRequest req, Model model){
        //根据url参数里面的id 查询user，同时对user的类别进行判断
        //判断功能还未完成，暂时只提供跳转功能用来测试
        String id = req.getParameter("id");
        System.out.println(id);
        int idNum = Integer.parseInt(id);
        User userForEdit = userService.selectuser(idNum);
        model.addAttribute("userForEdit", userForEdit);
//        model.addAttribute("student",student1);//在script，JQuery中已经通过student取出,var selectVal = selectVal"${student.classes.id}";,所以命名为student
        return "admin/edit";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest req)
    {
        int id = Integer.parseInt(req.getParameter("id"));
        int type = userService.selectuser(id).getUsertype();
        userService.deleteUser(id);
        if(type == 0)
            return "redirect:/teacher/index";
        if(type == 1)
            return "redirect:/student/index";
        if(type == 2)
            return "redirect:/cooperator/index";
        return "redirect:/admin/edit";
    }
}
