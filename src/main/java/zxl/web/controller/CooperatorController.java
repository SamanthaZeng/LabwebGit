package zxl.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zxl.web.domain.Teacher;
import zxl.web.domain.User;
import zxl.web.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Controller
@RequestMapping("/cooperator")
public class CooperatorController {
    @Autowired
    IUserService userService;
    @RequestMapping("/index")
    public String index(Model model)
    {
        return "cooperator/cooperator_list";
    }
}
