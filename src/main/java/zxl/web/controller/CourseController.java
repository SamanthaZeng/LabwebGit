package zxl.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zxl.web.domain.Course;
import zxl.web.service.ICourseService;
import zxl.web.service.IStudentService;
import zxl.web.service.IUserService;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private IUserService userService;

    @Autowired
    private ICourseService courseService;

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
}
