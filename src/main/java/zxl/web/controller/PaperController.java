package zxl.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import zxl.web.domain.Classes;
import zxl.web.domain.Student;
import zxl.web.domain.Students;
import zxl.web.domain.User;
import zxl.web.service.IClassesService;
import zxl.web.service.IStudentService;
import zxl.web.service.IStudentsService;
import zxl.web.service.IUserService;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/paper")//路径
public class PaperController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/index")
    public String index(Model model)
    {

        return "paper/paper_list";
    }
}
