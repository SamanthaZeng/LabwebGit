package zxl.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
    private IResearchService researchService;

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
        List<News>newsList=newsService.queryAll();
        for(int i=0;i<newsList.size();i++)
        {
            String str=newsList.get(i).getNewsdescription();
            newsList.get(i).setNewsdescription(cutStr(str,50));
            str=newsList.get(i).getNewstitle();
            newsList.get(i).setNewstitle(cutStr(str,30));
        }
        model.addAttribute("newsList",newsList);
        return "forward:/home.jsp";
    }

  @RequestMapping("/research")
    public String research(HttpServletRequest req, Model model){
    /*呈现研究方向信息*/
      System.out.println("Succeed in Research Index");
      int rid=Integer.parseInt(req.getParameter("rid"));
      Researcharea researcharea=researchService.selectResearch(rid);
      System.out.println(researcharea.toString());
      model.addAttribute("research",researcharea);

      /*呈现相关教师();信息*/
    List<UserResearchKey>userResearchKeys=userResearchService.queryAll(rid);
    List<Teacher> teachers=new ArrayList<>();
    Teacher teacher;
    for(int i=0;i<userResearchKeys.size();i++)
    {
           teacher=teacherService.selectTeacherById(userResearchKeys.get(i).getId());
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
      return "visitor/paper";
  }

  @RequestMapping("/course")
  public String course( Model model){
      System.out.println("Suceed in course index");
        List<Course>courses=courseService.queryAll();
        model.addAttribute("courses",courses);
        return "visitor/course";
  }

  @RequestMapping("/book")
  public String book(Model model){
      System.out.println("Suceed in book index");
      List<Book>books=bookService.queryAll();
      model.addAttribute("books",books);
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
            for(int i=0;i<teachers.size();i++)
                System.out.println(teachers.get(i).toString());
        }
        if(usertype==1)
            students=studentsService.queryAll();
        if(usertype==2)
            cooperators=cooperatorService.queryAll();
         model.addAttribute("teachers",teachers);
         model.addAttribute("students",students);
         model.addAttribute("cooperators",cooperators);
        /*List<Project>projects=projectService.queryAll();
        model.addAttribute("projects",projects);*/
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
        }
        if(usertype==1){
            student=studentsService.selectStudentById(id);
            System.out.println(student.toString());
        }
        if(usertype==2){
            cooperator=cooperatorService.selectCooperatorById(id);
            System.out.println(cooperator.toString());
        }
        model.addAttribute("usertype",usertype);
        model.addAttribute("teacher",teacher);
        model.addAttribute("student",student);
        model.addAttribute("cooperator",cooperator);
        return "visitor/userdetail";
    }

  @RequestMapping("/project")
  public String project(Model model){
        System.out.println("Suceed in project");
        List<Project>projects=projectService.queryAll();
        model.addAttribute("projects",projects);
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
        model.addAttribute("news",news);
        return "visitor/news";
    }

}
