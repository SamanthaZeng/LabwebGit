package zxl.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zxl.web.domain.Teacher;
import zxl.web.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @RequestMapping("/index")
    public String index(Model model)
    {
        //WEB-INF/views/student/index.jsp
//        List<Student>lists=studentService.queryAll();
//        model.addAttribute("students",lists);//存到model里面，页面可以取出来
        // System.out.println(lists);

        Teacher testTeacher = new Teacher();
        testTeacher.setId(1);
        testTeacher.setTid(5);
        testTeacher.setTmail("test@qq.com");
        List<Teacher> lists = new LinkedList<>();
        lists.add((testTeacher));
        model.addAttribute("teachers", lists);
        return "teacher/teacher_list";
    }
    @RequestMapping("/edit")
    public String edit(Teacher teacher,Model model){
        //根据stu里面的id 查询数据 放到页面进行回显操作
        Teacher testTeacher = new Teacher();
        testTeacher.setId(10086);
        testTeacher.setTid(5);
        testTeacher.setTmail("test@qq.com");
        model.addAttribute("teacher",teacher);
        User testUser = new User();
        return "teacher/teacher_input";
    }
}
class TeacherModel
    {
        Teacher teacher;
        User user;
        TeacherModel(Teacher teacher, User user){
            this.teacher = teacher;
            this.user = user;
        }
    }