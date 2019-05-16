package zxl.web.controller;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import zxl.web.domain.Researcharea;
import zxl.web.service.IResearchareaService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/info")
public class InfoController {
    @Autowired
    private IResearchareaService researchareaService;

    @RequestMapping("/edit")
    public String edit(Model model, HttpServletRequest req) {
        Researcharea info = researchareaService.queryinfo();
        model.addAttribute("researcharea", info);
        return "researcharea/edit";
    }
}
