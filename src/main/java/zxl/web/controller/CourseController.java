package zxl.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zxl.web.domain.Course;
import zxl.web.domain.Teacher;
import zxl.web.domain.User;
import zxl.web.domain.UserCourse;
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
        return "course/edit";
    }

    @RequestMapping("/add")
    public String add(Model model)
    {
        List<User> teachers = userService.queryAllTeacher();
        model.addAttribute("teachers", teachers);
        return "course/edit";
    }

    @RequestMapping("/save")
    public String save(Course course, HttpServletRequest req, Model model)
    {
        String[] userId = req.getParameterValues("usercourse");
        if(course != null && course.getClsid() != null && !"".equals(course.getClsid()))
        {
            List<User> uselessRecord = userCourseService.selectAssociationTeacher(course.getClsid());
            if(uselessRecord != null)
                for(int i=0; i<uselessRecord.size(); i++)
                    userCourseService.deleteAssociation(new UserCourse(uselessRecord.get(i).getId(), course.getClsid()));
            if(userId != null)
                for(int i=0; i<userId.length; i++)
                    userCourseService.save(new UserCourse(Integer.parseInt(userId[i]), course.getClsid()));
            courseService.update(course);
        }else{
            //把数据保存到数据库
            courseService.save(course);
            List<Course> queryForId = courseService.selectCourseId(course);
            if(userId != null)
                for(int i=0; i<userId.length; i++)
                    userCourseService.save(new UserCourse(Integer.parseInt(userId[i]), queryForId.get(0).getClsid()));
        }
        return "redirect:/course/index";
    }
    @RequestMapping("/delete")
    public String delete(HttpServletRequest req)
    {
        int clsid = Integer.parseInt(req.getParameter("clsid"));
        courseService.delete(clsid);
        return "redirect:/course/index";
    }
    public static boolean ifInPid(List<User> associations, int forTest)
    {
        for(int i=0; i<associations.size(); i++)
        {
            if(forTest == associations.get(i).getId())
                return true;
        }
        return false;
    }
}
