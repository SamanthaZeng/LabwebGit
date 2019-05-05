package zxl.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zxl.web.Utils.mdToHtml;
import zxl.web.domain.*;
import zxl.web.service.*;


import javax.jws.WebParam;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/visitor")
public class VisitorControlller {
    @Autowired
    private  INewsService newsService;

   @Autowired
    private IResearchareaService researchareaService;

   @Autowired
   private IUserResearchareaService userResearchService;

   @Autowired
   private IUserService userService;

   @Autowired
   private ITeacherService teacherService;

   @Autowired
   private IStudentsService studentsService;

   @Autowired
   private ICooperatorService cooperatorService;

   @Autowired
   private IPaperService paperService;

   @Autowired
   private ICourseService courseService;

   @Autowired
   private IBookService bookService;

   @Autowired
   private IProjectService projectService;

   @Autowired
   private IProResearchService proResearchService;

   @Autowired
   private IUserPaperService userPaperService;

   @Autowired
   private IUserProService userProService;

   @Autowired
   private ICompanyService companyService;

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

    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("return to home");
        List<News>news=newsService.queryAll();
        for(int i=0;i<news.size();i++)
        {
            String str=news.get(i).getNewsdescription();
            news.get(i).setNewsdescription(cutStr(str,50));
            str=news.get(i).getNewstitle();
            news.get(i).setNewstitle(cutStr(str,30));
        }
        List<News>newsList=new ArrayList<>();
        /*只获取三条新闻*/
        for(int i=news.size()-1;i>news.size()-4;i--){
            newsList.add(news.get(i));
        }
        model.addAttribute("newsList",newsList);

        /*呈现有哪些研究方向*/
        List<Researcharea>researchareas=researchareaService.queryAll();
        model.addAttribute("researchareas",researchareas);
        model.addAttribute("rsize",researchareas.size());
        return "forward:/home.jsp";
    }

  @RequestMapping("/research")
    public String research(HttpServletRequest req, Model model){
    /*呈现研究方向信息*/
      System.out.println("Succeed in Research Index");
      int rid=Integer.parseInt(req.getParameter("rid"));
      Researcharea researcharea=researchareaService.selectResearcharea(rid);
      System.out.println(researcharea.toString());
      model.addAttribute("research",researcharea);

      /*呈现相关教师();信息*/
    List<UserResearchKey>userResearchKeys=userResearchService.queryAll(rid);
    List<Teacher> teachers=new ArrayList<>();
    Teacher teacher;
    for(int i=0;i<userResearchKeys.size();i++)
    {
           teacher=teacherService.selectTeacherById(userResearchKeys.get(i).getId());
           if(teacher!=null)
              teachers.add(teacher);
    }
    model.addAttribute("teachers",teachers);//存到model里面，页面可以取出来

      /*呈现相关项目信息*/
      List<ProResearchKey>proResearchKeys=proResearchService.findByRid(rid);
      List<Project>projects = new ArrayList<Project>();
      for(int i=0;i<proResearchKeys.size();i++){
          Project project=projectService.selectProject(proResearchKeys.get(i).getProid());
          projects.add(project);
      }
      model.addAttribute("projects",projects);

      /*呈现有哪些研究方向*/
      List<Researcharea>researchareas=researchareaService.queryAll();
      model.addAttribute("researchareas",researchareas);
      model.addAttribute("rsize",researchareas.size());
    return "visitor/researcharea";
  }

  @RequestMapping("/paper")
    public String paper(HttpServletRequest req, Model model) throws ParseException {
      System.out.println("Suceed in paper index");
      //SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy");
      //Date time= (Date) dateFormat.parse(req.getParameter("time"));
      //System.out.println(time);
      //根据获得的年份返回该年的所有论文
      //List<Paper> papers=paperService.selectPaperbyTime(time);
      /*for(int i=0;i<papers.size();i++)
          System.out.println(papers.get(i).toString());
      model.addAttribute("papers",papers);*/
      Calendar calendar=Calendar.getInstance();
      int year1=calendar.get(Calendar.YEAR);
      int year2=year1-1;
      int year3=year2-1;
      int year4=year3-1;
      int year5=year4-1;
      SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy");
      Date time1= (Date) dateFormat.parse(String.valueOf(year1));
      Date time2= (Date) dateFormat.parse(String.valueOf(year2));
      Date time3= (Date) dateFormat.parse(String.valueOf(year3));
      Date time4= (Date) dateFormat.parse(String.valueOf(year4));
      Date time5= (Date) dateFormat.parse(String.valueOf(year5));
      //System.out.println("年："+year);
      //按从今年开始的前五年返回所有的论文
      List<Paper>papers1=paperService.selectPaperbyTime(time1);
      List<Paper>papers2=paperService.selectPaperbyTime(time2);
      List<Paper>papers3=paperService.selectPaperbyTime(time3);
      List<Paper>papers4=paperService.selectPaperbyTime(time4);
      List<Paper>papers5=paperService.selectPaperbyTime(time5);
      model.addAttribute("papers1",papers1);
      model.addAttribute("papers2",papers2);
      model.addAttribute("papers3",papers3);
      model.addAttribute("papers4",papers4);
      model.addAttribute("papers5",papers5);

      /*呈现有哪些研究方向*/
      List<Researcharea>researchareas=researchareaService.queryAll();
      model.addAttribute("researchareas",researchareas);
      model.addAttribute("rsize",researchareas.size());
      return "visitor/paper";
  }

  @RequestMapping("/course")
  public String course( Model model){
      System.out.println("Suceed in course index");
        List<Course>courses=courseService.queryAll();
        model.addAttribute("courses",courses);

      /*呈现有哪些研究方向*/
      List<Researcharea>researchareas=researchareaService.queryAll();
      model.addAttribute("researchareas",researchareas);
      model.addAttribute("rsize",researchareas.size());
        return "visitor/course";
  }

  @RequestMapping("/book")
  public String book(Model model){
      System.out.println("Suceed in book index");
      List<Book>books=bookService.queryAll();
      for(int i=0;i<books.size();i++)
      {
          String str=books.get(i).getBabstract();
          books.get(i).setBabstract(cutStr(str,50));
      }
      model.addAttribute("books",books);

      /*呈现有哪些研究方向*/
      List<Researcharea>researchareas=researchareaService.queryAll();
      model.addAttribute("researchareas",researchareas);
      model.addAttribute("rsize",researchareas.size());
      return "visitor/book";
  }

    @RequestMapping("/user")
    public String user(HttpServletRequest req,Model model){
        System.out.println("Suceed in user");
        int usertype=Integer.valueOf(req.getParameter("usertype"));
        System.out.println(usertype);
        List<Teacher> teachers=null;
        List<Students>students=null;
        List<Cooperator>cooperators=null;
        if(usertype==0){
            System.out.println("usertype=0");
            teachers=teacherService.queryAll();
            String str;
            for(int i=0;i<teachers.size();i++){
                System.out.println(teachers.get(i).toString());
            }
        }
        if(usertype==1){
            students=studentsService.queryAll();
            for(int i=0;i<students.size();i++)
                System.out.println(students.get(i).toString());
        }
        if(usertype==2){
            cooperators=cooperatorService.queryAll();
            for(int i=0;i<cooperators.size();i++)
                System.out.println(cooperators.get(i).toString());
        }
         model.addAttribute("teachers",teachers);
         model.addAttribute("students",students);
         model.addAttribute("cooperators",cooperators);
        /*List<Project>projects=projectService.queryAll();
        model.addAttribute("projects",projects);*/

        /*呈现有哪些研究方向*/
        List<Researcharea>researchareas=researchareaService.queryAll();
        model.addAttribute("researchareas",researchareas);
        model.addAttribute("rsize",researchareas.size());
        return "visitor/user";
    }

    @RequestMapping("/userdetail")
    public String userdetail(HttpServletRequest req,Model model){
        int id= Integer.parseInt(req.getParameter("id"));
        int usertype;
        Teacher teacher=null;
        Students student=null;
        Cooperator cooperator=null;
        User user=userService.selectuser(id);
        usertype=user.getUsertype();
        if(usertype==0){
            teacher=teacherService.selectTeacherById(id);
            System.out.println(teacher.toString());
            /*获取教师所发表的论文*/
            List<UserPaper>userPapers=userPaperService.selectUPpsById(teacher.getId());
            List<Paper>papers=new ArrayList<>();
            Paper paper;
            for(int i=0;i<userPapers.size();i++)
            {
                paper=paperService.selectPaper(userPapers.get(i).getPid());
                papers.add(paper);
            }
            model.addAttribute("papers",papers);
            /*获取教师所参与的项目*/
            List<UserPro>userPros=userProService.selectUPsById(teacher.getId());
            List<Project>projects=new ArrayList<>();
            Project project;
            for(int i=0;i<userPros.size();i++)
            {
                project=projectService.selectProject(userPros.get(i).getProid());
                projects.add(project);
            }
            model.addAttribute("projects",projects);
        }
        if(usertype==1){
            student=studentsService.selectStudentById(id);
            System.out.println(student.toString());
            /*获取学生所发表的论文*/
            List<UserPaper>userPapers=userPaperService.selectUPpsById(student.getId());
            List<Paper>papers=new ArrayList<>();
            Paper paper;
            for(int i=0;i<userPapers.size();i++)
            {
                paper=paperService.selectPaper(userPapers.get(i).getPid());
                papers.add(paper);
            }
            model.addAttribute("papers",papers);
            /*获取学生所参与的项目*/
            List<UserPro>userPros=userProService.selectUPsById(student.getId());
            List<Project>projects=new ArrayList<>();
            Project project;
            for(int i=0;i<userPros.size();i++)
            {
                project=projectService.selectProject(userPros.get(i).getProid());
                projects.add(project);
            }
            model.addAttribute("projects",projects);
        }
        if(usertype==2){
            cooperator=cooperatorService.selectCooperatorById(id);
            System.out.println(cooperator.toString());
        }
        model.addAttribute("usertype",usertype);
        model.addAttribute("teacher",teacher);
        model.addAttribute("student",student);
        model.addAttribute("cooperator",cooperator);
        /*呈现有哪些研究方向*/
        List<Researcharea>researchareas=researchareaService.queryAll();
        model.addAttribute("researchareas",researchareas);
        model.addAttribute("rsize",researchareas.size());
        return "visitor/userdetail";
    }

  @RequestMapping("/project")
  public String project(Model model){
        System.out.println("Suceed in project");
        List<Project>projects=projectService.queryAll();
        model.addAttribute("projects",projects);

      /*呈现有哪些研究方向*/
      List<Researcharea>researchareas=researchareaService.queryAll();
      model.addAttribute("researchareas",researchareas);
      model.addAttribute("rsize",researchareas.size());
        return "visitor/project";
  }

    @RequestMapping("/login")
    public String login(){
        System.out.println("return to login");
        return "redirect:/login.jsp";
    }

    @RequestMapping("/news")
    public String news(HttpServletRequest req,Model model){
        int newsid=Integer.valueOf(req.getParameter("newsid"));
        News news=newsService.selectByNewsId(newsid);
        String md = news.getNewsdescription();
        String html = mdToHtml.parse(md);
        news.setNewsdescription(html);
        model.addAttribute("news",news);

        /*呈现有哪些研究方向*/
        List<Researcharea>researchareas=researchareaService.queryAll();
        model.addAttribute("researchareas",researchareas);
        model.addAttribute("rsize",researchareas.size());
        return "visitor/news";
    }

    @RequestMapping("/company")
    public String company(Model model){
        List<Company>companies=companyService.queryAll();
        for(int i=0;i<companies.size();i++)
            System.out.println(companies.get(i).toString());
        model.addAttribute("companies",companies);
        return "visitor/company";
    }
    /*转换换行符*/
    public String filterLineBreak(String desc){
        if(desc!=null&&desc.indexOf("\n")!=-1){
            if(desc.indexOf("\r\n")!=-1){
                desc=desc.replace("\r\n","<brbr/>");
            }else{
                desc=desc.replace("\n","<br/>");
            }
        }
        return desc;
    }

}
