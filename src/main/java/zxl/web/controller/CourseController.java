package zxl.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zxl.web.domain.Course;
import zxl.web.domain.Teacher;
import zxl.web.domain.User;
import zxl.web.service.ICourseService;
import zxl.web.service.IStudentService;
import zxl.web.service.IUserCourseService;
import zxl.web.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private IUserService userService;

    @Autowired
    private ICourseService courseService;

    @Autowired
    private IUserCourseService userCourseService;

    @RequestMapping("/index")
    public String allClasses(Model model)
    {
        List<Course> courses = courseService.queryAll();
        model.addAttribute("courses", courses);
        for(int i=0;i<courses.size();i++)
        {
            System.out.println(courses.get(i).getAbstract());
        }
        return "course/course_list";
    }

    @RequestMapping("/edit")
    public String edit(Model model, HttpServletRequest req)
    {
        String clsid = req.getParameter("clsid");
        Course courseForEdit = courseService.selectCourse(Integer.parseInt(clsid));
        model.addAttribute("courseForEdit", courseForEdit);
        List<User> associations = userCourseService.selectAssociationTeacher(Integer.parseInt(clsid));
        model.addAttribute("associations", associations);
        List<User> teachers = userService.queryAllTeacher();
        model.addAttribute("teachers", teachers);
        for(int i=0;i<teachers.size();i++)
        {
            System.out.println(teachers.get(i).getUsername());
        }
        return "course/edit";
    }

    @RequestMapping("/add")
    public String add(Model model)
    {
        List<User> users=userService.queryAll();
        model.addAttribute("users",users);
        return "/course/edit";
    }

    @RequestMapping("/save")
    public String save(Course course, HttpServletRequest req, Model model)
    {
        String[] userId = req.getParameterValues("usercourse");

        return "redirect:/course/index";
    }

    public static boolean ifInPid(List<User> associations, int forTest)
    {
        System.out.println("In");
        for(int i=0; i<associations.size(); i++)
        {
            if(forTest == associations.get(i).getId())
                return true;
        }
        return false;
    }
}
