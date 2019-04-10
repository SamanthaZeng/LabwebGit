package zxl.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import zxl.web.domain.User;
import zxl.web.service.IClassesService;
import zxl.web.service.IStudentService;
import zxl.web.service.IUserService;
import org.springframework.web.multipart.MultipartFile;
import zxl.web.domain.*;
import zxl.web.service.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IClassesService classesService;
    @Autowired
    private IStudentService studentService;
    @Autowired
    private  IUserService userService;
    @Autowired
    private ICooperatorService cooperatorService;
    @Autowired
    private ICompanyService companyService;
    @Autowired
    private IStudentsService studentsService;
    @Autowired
    private ITeacherService teacherService;

//    @RequestMapping("/index")
//    public String index(Model model,HttpServletRequest request)//首页
//    {
//        User user = (User)request.getSession().getAttribute("user");
//        return "admin/index";
//    }

    @RequestMapping("/add")
    public String add(Model model, HttpServletRequest req)
    {
        int type = Integer.parseInt(req.getParameter("type"));
        if(type != 0 && type != 1 && type != 2)
            return "redirect:/admin/main";
        User userForEdit = new User();
        userService.register(userForEdit);
        userForEdit.setUsertype(type);
        model.addAttribute("userForEdit", userForEdit);
        return "admin/edit";
    }

    @RequestMapping("/main") // 个人主页面
    public String mainInfo(Model model, HttpServletRequest request)
    {
        User user = (User)request.getSession().getAttribute("user");
        return "admin/index";
    }

    @RequestMapping("/edit")
    public String edit(HttpServletRequest req, Model model){
        User user = userService.selectuser(Integer.parseInt(req.getParameter("id")));
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

    @RequestMapping("/save")
    public String save(HttpServletRequest req, MultipartFile imgFile) throws ParseException, IOException {
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPwd(req.getParameter("pwd"));
        //birthday
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(new java.sql.Date(sdf.parse(req.getParameter("birthday")).getTime()));
        //sex
        user.setSex(Integer.parseInt(req.getParameter("sex")));
        user.setRealname(req.getParameter("realname"));
        //imgfile
        if(imgFile !=null && imgFile.getSize()!=0){
            //获取文件夹路径
            String path = req.getServletContext().getRealPath("/uploadFile");
            //文件名称UID解决文件名称问题
            String filename=imgFile.getOriginalFilename();
            String newFileName= UUID.randomUUID().toString()+"."+ StringUtils.getFilenameExtension(filename);
            //先构造一个文件出来
            File file=new File(path,newFileName);
            //把imgFile写到file里
            org.apache.commons.io.IOUtils.copy(imgFile.getInputStream(),new FileOutputStream(file));
            //存放图片地址
            user.setImgurl("/uploadFile/"+newFileName);
        }
        user.setId(Integer.parseInt(req.getParameter("id")));
        user.setUsertype(Integer.parseInt(req.getParameter("usertype")));
        if(Integer.parseInt(req.getParameter("usertype"))==0)
        {
            Teacher teacher = new Teacher();
            teacher.setTmail(req.getParameter("tmail"));
            teacher.setTduty(req.getParameter("tduty"));
            teacher.setTeduexp(req.getParameter("teduexp"));
            teacher.setWorkexp(req.getParameter("workexp"));
            teacher.setService(req.getParameter("service"));
            teacher.setTrank(Integer.parseInt(req.getParameter("trank")));
            if(req.getParameter("tid").equals(""))
            {
                teacher.setId(user.getId());
                teacherService.register(teacher, user);
            }
            else
            {
                userService.update(user);
                teacher.setTid(Integer.parseInt(req.getParameter("tid")));
                teacherService.update(teacher);
            }
        }else
            if(Integer.parseInt(req.getParameter("usertype"))==1)
            {
                Students student = new Students();
                student.setSmail(req.getParameter("smail"));
                student.setWheretogo(req.getParameter("wheretogo"));
                student.setStueduexp(req.getParameter("stueduexp"));
                student.setSrank(Integer.parseInt(req.getParameter("srank")));
                student.setEntertime(new java.sql.Date(sdf.parse(req.getParameter("entertime")).getTime()));
                if(req.getParameter("sid").equals(""))
                {
                    student.setId(user.getId());
                    studentsService.register(student, user);
                }
                else
                {
                    userService.update(user);
                    student.setSid(Integer.parseInt(req.getParameter("sid")));
                    studentsService.update(student);
                }
            }else
                if(Integer.parseInt(req.getParameter("usertype"))==2)
                {
                    Cooperator cooperator = new Cooperator();
                    cooperator.setCoid(Integer.parseInt(req.getParameter("coid")));
                    cooperator.setTitle(req.getParameter("title"));
                    cooperator.setCduty(req.getParameter("cduty"));
                    if(req.getParameter("cid").equals(""))
                    {
                        cooperator.setId(user.getId());
                        cooperatorService.register(cooperator, user);
                    }
                    else
                    {
                        userService.update(user);
                        cooperator.setCid(Integer.parseInt(req.getParameter("cid")));
                        cooperatorService.update(cooperator);
                    }
                }
        //判断当前保存的user是不是登录的user，如果是，则更新session中的数据
        if(user.getId() == ((User)req.getSession().getAttribute("user")).getId())
            req.getSession().setAttribute("user", userService.selectuser(user.getId()));
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
