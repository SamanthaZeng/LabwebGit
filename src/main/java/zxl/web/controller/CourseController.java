package zxl.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zxl.web.domain.*;
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
    public String save(Course course, HttpServletRequest req)
    {
       // String[] userId = req.getParameterValues("usercourse");

        /*new version*/
        String authors[]=req.getParameterValues("authors");
        //增加/更新course表
        if(course!=null&&course.getClsid()!=null&&!"".equals(course.getClsid()))
            courseService.update(course);
        else
            courseService.save(course);
        //增加/更新usercourse 表
        //1.获取course id
        int clsid;
        clsid=courseService.selectClsid(course);
        System.out.println("Clsid= "+clsid);
        //2.添加/更新usercourse表
        List<UserCourse> userCourses=userCourseService.selectUCls(clsid);
        UserCourseKey userCourseKey=new UserCourseKey();
        userCourseKey.setClsid(clsid);
        int id;
        if(userCourses.size()!=0)//更新
        {
            for(int i=0;i<userCourses.size();i++) {
                id = userCourses.get(i).getId();
                userCourseKey.setId(id);
                //删除掉所有bid=#{bid}的记录
                userCourseService.deleteClsid(userCourseKey);
            }
            UserCourse author=new UserCourse();
            //设置课程Id
            author.setClsid(clsid);
            if(authors.length!=0){
                for(int i=0;i<authors.length;i++){
                    //设置任课教师Id和课程号
                    author.setId(Integer.valueOf(authors[i]));
                    userCourseService.insert(author);
                }
            }
        }
        else{//添加
            System.out.println("添加新的usercourse项");
            UserCourse author=new UserCourse();
            author.setClsid(clsid);
            if(authors.length!=0){
                for(int i=0;i<authors.length;i++){
                    //设置作者id和clsid
                    author.setId(Integer.valueOf(authors[i]));
                    userCourseService.insert(author);
                }
            }
        }
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
