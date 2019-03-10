package zxl.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zxl.web.domain.*;
import zxl.web.service.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    //未完成后端功能，只用来对前端路由和分发进行测试
    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private  IUserService userService;
    @Autowired
    private IStudentsService studentsService;
    @Autowired
    private ICooperatorService cooperatorService;
    @Autowired
    private ICompanyService companyService;

    @RequestMapping("/add")
    public String add(Model model, HttpServletRequest req)
    {
        int type = Integer.parseInt(req.getParameter("type"));
        if(type != 0 && type != 1 && type != 2)
            return "redirect:/admin/main";
        User userForEdit = new User();
        userForEdit.setUsertype(type);
        model.addAttribute("userForEdit", userForEdit);
        return "admin/edit";
    }

    @RequestMapping("/main") // 个人主页面
    public String mainInfo(Model model, HttpServletRequest request)
    {
        User user = (User)request.getSession().getAttribute("user");
        model.addAttribute("userForEdit", user);
        if(user.getUsertype()==0)
        {
            model.addAttribute("teacher", teacherService.select(user.getTid()));
        }
        if(user.getUsertype()==1)
        {
            model.addAttribute("student", studentsService.select(user.getSid()));
        }
        if(user.getUsertype()==2)
        {
            model.addAttribute("companies", companyService.queryAll());
            model.addAttribute("cooperator", cooperatorService.select(user.getCid()));
        }
        return "admin/edit";
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

    @RequestMapping("/save")
    public String save(HttpServletRequest req) throws ParseException {
        if(!req.getParameter("tid").equals(""))
        {
            System.out.println(0);
            Teacher teacher = new Teacher();
            teacher.setTid(Integer.parseInt(req.getParameter("tid")));
            teacher.setTmail(req.getParameter("tmail"));
            teacher.setTduty(req.getParameter("tduty"));
            teacher.setTeduexp(req.getParameter("teduexp"));
            teacher.setWorkexp(req.getParameter("workexp"));
            teacher.setService(req.getParameter("service"));
            teacher.setTrank(Integer.parseInt(req.getParameter("trank")));
            teacherService.update(teacher);
        }else
            if(!req.getParameter("sid").equals(""))
            {
                System.out.println(1);
                Students student = new Students();
                student.setSid(Integer.parseInt(req.getParameter("sid")));
                student.setSmail(req.getParameter("smail"));
                student.setWheretogo(req.getParameter("wheretogo"));
                student.setStueduexp(req.getParameter("stueduexp"));
                student.setSrank(Integer.parseInt(req.getParameter("srank")));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                student.setEntertime(new java.sql.Date(sdf.parse(req.getParameter("entertime")).getTime()));
                System.out.println(student);
                studentsService.update(student);
            }else
                if(!req.getParameter("cid").equals(""))
                {
                    System.out.println(2);
                    Cooperator cooperator = new Cooperator();
                    cooperator.setCid(Integer.parseInt(req.getParameter("cid")));
                    cooperator.setCoid(Integer.parseInt(req.getParameter("coid")));
                    cooperator.setTitle(req.getParameter("title"));
                    cooperator.setCduty(req.getParameter("cduty"));
                    cooperatorService.update(cooperator);
                }
        return "redirect:/admin/main";
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
