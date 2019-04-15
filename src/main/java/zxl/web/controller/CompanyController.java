package zxl.web.controller;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.stereotype.Service;
   import org.springframework.ui.Model;
   import org.springframework.util.StringUtils;
   import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
   import org.springframework.web.multipart.MultipartFile;
   import zxl.web.domain.Company;
   import zxl.web.service.ICompanyService;

   import javax.servlet.http.HttpServletRequest;
   import java.io.File;
   import java.io.FileOutputStream;
   import java.io.IOException;
   import java.util.List;
   import java.util.UUID;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;

    @RequestMapping("/add")
    public String add(Model model, HttpServletRequest req)
    {
        return "company/edit";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest req)
    {
        int coid = Integer.parseInt(req.getParameter("coid"));
        companyService.delete(coid);
        return "redirect:/company/index";
    }

    @RequestMapping("/edit")
    public String edit(Model model, HttpServletRequest req)
    {
        Company company = companyService.selectCompany(Integer.parseInt(req.getParameter("coid")));
        model.addAttribute(company);
        return "company/edit";
    }

    @RequestMapping("/save")
    public String save(Model model, MultipartFile imgFile, Company company, HttpServletRequest req) throws IOException {

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
            company.setLogourl("/uploadFile/"+newFileName);
        }
        if(company.getCoid()==null) {
            companyService.insert(company);
        }
        else {
            companyService.update(company);
        }
        return "redirect:/admin/main";
    }
    @RequestMapping("/index")
    public String index(Model model)
    {
        List<Company> companyList = companyService.queryAll();
        model.addAttribute(companyList);
        return "company/company_list";
    }
}
