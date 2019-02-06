package zxl.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zxl.web.service.IClassesService;

@Controller
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private IClassesService classesService;

    //查询报表的方法
    @RequestMapping("/index")
    public String index(Model model){
        //查询报表
        model.addAttribute("chartList",classesService.queryClassesChart()); //名字要取页面上的名字chartList
        return "classes/chart";
    }

}
