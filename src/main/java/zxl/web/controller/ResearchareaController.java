package zxl.web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import zxl.web.domain.Company;
import zxl.web.domain.Researcharea;
import zxl.web.service.ICompanyService;
import zxl.web.service.IResearchareaService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/researcharea")
public class ResearchareaController {

    @Autowired
    private IResearchareaService researchareaService;

    @RequestMapping("/add")
    public String add(Model model, HttpServletRequest req)
    {
        return "researcharea/edit";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest req)
    {
        int rid = Integer.parseInt(req.getParameter("rid"));
        researchareaService.delete(rid);
        return "redirect:/researcharea/index";
    }

    @RequestMapping("/edit")
    public String edit(Model model, HttpServletRequest req)
    {
        Researcharea researcharea = researchareaService.selectResearcharea(Integer.parseInt(req.getParameter("rid")));
        model.addAttribute("researcharea", researcharea);
        return "researcharea/edit";
    }

    @RequestMapping("/save")
    public String save(Model model, Researcharea researcharea, HttpServletRequest req) throws IOException {
        if(researcharea.getRid()==null) {
            researchareaService.insert(researcharea);
        }
        else {
            researchareaService.update(researcharea);
        }
        return "redirect:/researcharea/index";
    }
    @RequestMapping("/index")
    public String index(Model model)
    {
        List<Researcharea> researchareaList = researchareaService.queryAll();
        for(int i=0; i<researchareaList.size();i++)
        {
            String str = researchareaList.get(i).getIntro();
            researchareaList.get(i).setIntro(cutStr(str, 50));
        }
        model.addAttribute("researchareaList", researchareaList);
        return "researcharea/researcharea_list";
    }
    public static String cutStr(String strs, int length) {
        int sum = 0;
        String finalStr = "";
        if (null == strs || strs.getBytes().length <= length) {
            finalStr = (strs==null?"":strs);
        } else {
            for (int i = 0; i < strs.length(); i++) {
                String str = strs.substring(i, i + 1);
                // 累加单个字符字节数
                sum += str.getBytes().length;
                if (sum > length) {
                    finalStr = strs.substring(0, i) + "...";
                    break;
                }
            }
        }
        return finalStr;
    }
}
