package zxl.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import zxl.web.domain.*;
import zxl.web.service.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
        user.setId(Integer.parseInt(req.getParameter("id")));
        user.setUsername(req.getParameter("username"));
        user.setPwd(req.getParameter("pwd"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(new java.sql.Date(sdf.parse(req.getParameter("birthday")).getTime()));
        user.setSex(Integer.parseInt(req.getParameter("sex")));
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
        userService.update(user);
        if(user.getId() == ((User)req.getSession().getAttribute("user")).getId())
            req.getSession().setAttribute("user", userService.selectuser(user.getId()));
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
