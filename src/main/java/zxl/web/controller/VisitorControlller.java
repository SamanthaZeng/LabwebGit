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
   private IUserCourseService userCourseService;

   @Autowired
   private IUserBookService userBookService;

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
        if(news.size() > 3){
            /*只获取三条新闻(当新闻多于三条时)*/
            for(int i=news.size()-1;i>news.size()-4;i--){
                newsList.add(news.get(i));
            }
        }else {
            for(int i=news.size() - 1; i > -1; i--) {
                newsList.add(news.get(i));
            }
        }
        model.addAttribute("newsList",newsList);

        /*呈现有哪些研究方向*/
        List<Researcharea>researchareas=researchareaService.queryAll();
        model.addAttribute("researchareas",researchareas);
        model.addAttribute("rsize",researchareas.size());

        /*获取实验室信息*/
        Researcharea info=researchareaService.queryinfo();
        model.addAttribute("info",info);
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

      /*呈现相关教师和学生信息*/
    List<UserResearchKey>userResearchKeys=userResearchService.queryAll(rid);
    List<Teacher> teachers=new ArrayList<>();
    Teacher teacher;
    List<Students> students=new ArrayList<>();
    Students student;
    for(int i=0;i<userResearchKeys.size();i++)
    {
           teacher=teacherService.selectTeacherById(userResearchKeys.get(i).getId());
           student=studentsService.selectStudentById(userResearchKeys.get(i).getId());
           if(teacher!=null)
              teachers.add(teacher);
           if(student!=null){
               System.out.println(student.toString());
               students.add(student);
           }
    }
      model.addAttribute("teachers",teachers);//存到model里面，页面可以取出来
      model.addAttribute("students",students);

      /*呈现相关项目信息*/
      List<ProResearchKey>proResearchKeys=proResearchService.findByRid(rid);
      List<Project>projects = new ArrayList<Project>();
      List<String>authors=new ArrayList<>();
      List<UserPro>userPros=new ArrayList<>();
      User tempuser;
      for(int i=0;i<proResearchKeys.size();i++){
          Project project=projectService.selectProject(proResearchKeys.get(i).getProid());
          projects.add(project);
          String str="";
          userPros=userProService.selectUPs(project.getProid());
          for(int j=0;j<userPros.size();j++){
              tempuser=userService.selectuser(userPros.get(j).getId());
              if(j==0)
                  str=tempuser.getRealname();
              else
                  str=str+","+tempuser.getRealname();
          }
          authors.add(str);
      }
      model.addAttribute("projects",projects);
      model.addAttribute("authors",authors);

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
      int papertype=Integer.parseInt(req.getParameter("papertype"));
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
      List<String>authors1=new ArrayList<>();
      List<String>authors2=new ArrayList<>();
      List<String>authors3=new ArrayList<>();
      List<String>authors4=new ArrayList<>();
      List<String>authors5=new ArrayList<>();
      List<UserPaper>ups=new ArrayList<>();
      User tempuser;
      //按从今年开始的前五年返回所有的论文
      if(papertype==-1)//查看全部论文
      {
          List<Paper>papers1=paperService.selectPaperbyTime(time1);
          for(int i=0;i<papers1.size();i++){
              String str="";
              ups=userPaperService.selectUPps(papers1.get(i).getPid());
              for(int j=0;j<ups.size();j++){
                  tempuser=userService.selectuser(ups.get(j).getId());
                  if(ups.get(j).getAuthornumber()<0){
                      if(papers1.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname()+'*';
                      if(papers1.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname()+'*';
                  }
                  else{
                      if(papers1.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname();
                      if(papers1.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname();
                  }
              }
              authors1.add(str);
          }
          List<Paper>papers2=paperService.selectPaperbyTime(time2);
          for(int i=0;i<papers2.size();i++){
              String str="";
              ups=userPaperService.selectUPps(papers2.get(i).getPid());
              for(int j=0;j<ups.size();j++){
                  tempuser=userService.selectuser(ups.get(j).getId());
                  if(ups.get(j).getAuthornumber()<0){
                      if(papers2.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname()+'*';
                      if(papers2.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname()+'*';
                  }
                  else{
                      if(papers2.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname();
                      if(papers2.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname();
                  }
              }
              authors2.add(str);
          }
          List<Paper>papers3=paperService.selectPaperbyTime(time3);
          for(int i=0;i<papers3.size();i++){
              String str="";
              ups=userPaperService.selectUPps(papers3.get(i).getPid());
              for(int j=0;j<ups.size();j++){
                  tempuser=userService.selectuser(ups.get(j).getId());
                  if(ups.get(j).getAuthornumber()<0){
                      if(papers3.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname()+'*';
                      if(papers3.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname()+'*';
                  }
                  else{
                      if(papers3.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname();
                      if(papers3.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname();
                  }
              }
              authors3.add(str);
          }
          List<Paper>papers4=paperService.selectPaperbyTime(time4);
          for(int i=0;i<papers4.size();i++){
              String str="";
              ups=userPaperService.selectUPps(papers4.get(i).getPid());
              for(int j=0;j<ups.size();j++){
                  tempuser=userService.selectuser(ups.get(j).getId());
                  if(ups.get(j).getAuthornumber()<0){
                      if(papers4.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname()+'*';
                      if(papers4.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname()+'*';
                  }
                  else{
                      if(papers4.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname();
                      if(papers4.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname();
                  }
              }
              authors4.add(str);
          }
          List<Paper>papers5=paperService.selectPaperbyTime(time5);
          for(int i=0;i<papers5.size();i++){
              String str="";
              ups=userPaperService.selectUPps(papers5.get(i).getPid());
              for(int j=0;j<ups.size();j++){
                  tempuser=userService.selectuser(ups.get(j).getId());
                  if(ups.get(j).getAuthornumber()<0){
                      if(papers5.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname()+'*';
                      if(papers5.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname()+'*';
                  }
                  else{
                      if(papers5.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname();
                      if(papers5.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname();
                  }
              }
              authors5.add(str);
          }
          model.addAttribute("papers1",papers1);
          model.addAttribute("papers2",papers2);
          model.addAttribute("papers3",papers3);
          model.addAttribute("papers4",papers4);
          model.addAttribute("papers5",papers5);model.addAttribute("authors1",authors1);
          model.addAttribute("authors2",authors2);
          model.addAttribute("authors3",authors3);
          model.addAttribute("authors4",authors4);
          model.addAttribute("authors5",authors5);
      }
      if(papertype==1)//查看会议论文
      {
          List<Paper>papers1=paperService.selectPaperbyTimeAndType(time1,papertype);
          List<Paper>papers2=paperService.selectPaperbyTimeAndType(time2,papertype);
          List<Paper>papers3=paperService.selectPaperbyTimeAndType(time3,papertype);
          List<Paper>papers4=paperService.selectPaperbyTimeAndType(time4,papertype);
          List<Paper>papers5=paperService.selectPaperbyTimeAndType(time5,papertype);
          for(int i=0;i<papers1.size();i++){
              String str="";
              ups=userPaperService.selectUPps(papers1.get(i).getPid());
              for(int j=0;j<ups.size();j++){
                  tempuser=userService.selectuser(ups.get(j).getId());
                  if(ups.get(j).getAuthornumber()<0){
                      if(papers1.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname()+'*';
                      if(papers1.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname()+'*';
                  }
                  else{
                      if(papers1.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname();
                      if(papers1.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname();
                  }
              }
              authors1.add(str);
          }
          for(int i=0;i<papers2.size();i++){
              String str="";
              ups=userPaperService.selectUPps(papers2.get(i).getPid());
              for(int j=0;j<ups.size();j++){
                  tempuser=userService.selectuser(ups.get(j).getId());
                  if(ups.get(j).getAuthornumber()<0){
                      if(papers2.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname()+'*';
                      if(papers2.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname()+'*';
                  }
                  else{
                      if(papers2.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname();
                      if(papers2.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname();
                  }
              }
              authors2.add(str);
          }
          for(int i=0;i<papers3.size();i++){
              String str="";
              ups=userPaperService.selectUPps(papers3.get(i).getPid());
              for(int j=0;j<ups.size();j++){
                  tempuser=userService.selectuser(ups.get(j).getId());
                  if(ups.get(j).getAuthornumber()<0){
                      if(papers3.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname()+'*';
                      if(papers3.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname()+'*';
                  }
                  else{
                      if(papers3.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname();
                      if(papers3.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname();
                  }
              }
              authors3.add(str);
          }
          for(int i=0;i<papers4.size();i++){
              String str="";
              ups=userPaperService.selectUPps(papers4.get(i).getPid());
              for(int j=0;j<ups.size();j++){
                  tempuser=userService.selectuser(ups.get(j).getId());
                  if(ups.get(j).getAuthornumber()<0){
                      if(papers4.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname()+'*';
                      if(papers4.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname()+'*';
                  }
                  else{
                      if(papers4.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname();
                      if(papers4.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname();
                  }
              }
              authors4.add(str);
          }
          for(int i=0;i<papers5.size();i++){
              String str="";
              ups=userPaperService.selectUPps(papers5.get(i).getPid());
              for(int j=0;j<ups.size();j++){
                  tempuser=userService.selectuser(ups.get(j).getId());
                  if(ups.get(j).getAuthornumber()<0){
                      if(papers5.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname()+'*';
                      if(papers5.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname()+'*';
                  }
                  else{
                      if(papers5.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname();
                      if(papers5.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname();
                  }
              }
              authors5.add(str);
          }
          model.addAttribute("papers1",papers1);
          model.addAttribute("papers2",papers2);
          model.addAttribute("papers3",papers3);
          model.addAttribute("papers4",papers4);
          model.addAttribute("papers5",papers5);
          model.addAttribute("authors1",authors1);
          model.addAttribute("authors2",authors2);
          model.addAttribute("authors3",authors3);
          model.addAttribute("authors4",authors4);
          model.addAttribute("authors5",authors5);
      }
      if(papertype==2)//查看期刊论文
      {
          List<Paper>papers1=paperService.selectPaperbyTimeAndType(time1,papertype);
          List<Paper>papers2=paperService.selectPaperbyTimeAndType(time2,papertype);
          List<Paper>papers3=paperService.selectPaperbyTimeAndType(time3,papertype);
          List<Paper>papers4=paperService.selectPaperbyTimeAndType(time4,papertype);
          List<Paper>papers5=paperService.selectPaperbyTimeAndType(time5,papertype);
          for(int i=0;i<papers1.size();i++){
              String str="";
              ups=userPaperService.selectUPps(papers1.get(i).getPid());
              for(int j=0;j<ups.size();j++){
                  tempuser=userService.selectuser(ups.get(j).getId());
                  if(ups.get(j).getAuthornumber()<0){
                      if(papers1.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname()+'*';
                      if(papers1.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname()+'*';
                  }
                  else{
                      if(papers1.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname();
                      if(papers1.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname();
                  }
              }
              authors1.add(str);
          }
          for(int i=0;i<papers2.size();i++){
              String str="";
              ups=userPaperService.selectUPps(papers2.get(i).getPid());
              for(int j=0;j<ups.size();j++){
                  tempuser=userService.selectuser(ups.get(j).getId());
                  if(ups.get(j).getAuthornumber()<0){
                      if(papers2.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname()+'*';
                      if(papers2.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname()+'*';
                  }
                  else{
                      if(papers2.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname();
                      if(papers2.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname();
                  }
              }
              authors2.add(str);
          }
          for(int i=0;i<papers3.size();i++){
              String str="";
              ups=userPaperService.selectUPps(papers3.get(i).getPid());
              for(int j=0;j<ups.size();j++){
                  tempuser=userService.selectuser(ups.get(j).getId());
                  if(ups.get(j).getAuthornumber()<0){
                      if(papers3.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname()+'*';
                      if(papers3.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname()+'*';
                  }
                  else{
                      if(papers3.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname();
                      if(papers3.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname();
                  }
              }
              authors3.add(str);
          }
          for(int i=0;i<papers4.size();i++){
              String str="";
              ups=userPaperService.selectUPps(papers4.get(i).getPid());
              for(int j=0;j<ups.size();j++){
                  tempuser=userService.selectuser(ups.get(j).getId());
                  if(ups.get(j).getAuthornumber()<0){
                      if(papers4.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname()+'*';
                      if(papers4.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname()+'*';
                  }
                  else{
                      if(papers4.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname();
                      if(papers4.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname();
                  }
              }
              authors4.add(str);
          }
          for(int i=0;i<papers5.size();i++){
              String str="";
              ups=userPaperService.selectUPps(papers5.get(i).getPid());
              for(int j=0;j<ups.size();j++){
                  tempuser=userService.selectuser(ups.get(j).getId());
                  if(ups.get(j).getAuthornumber()<0){
                      if(papers5.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname()+'*';
                      if(papers5.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname()+'*';
                  }
                  else{
                      if(papers5.get(i).getLanguage()==1)
                          str=str+"."+tempuser.getRealname();
                      if(papers5.get(i).getLanguage()==2)
                          str=str+"."+tempuser.getEngname();
                  }
              }
              authors5.add(str);
          }
          model.addAttribute("papers1",papers1);
          model.addAttribute("papers2",papers2);
          model.addAttribute("papers3",papers3);
          model.addAttribute("papers4",papers4);
          model.addAttribute("papers5",papers5);
          model.addAttribute("authors1",authors1);
          model.addAttribute("authors2",authors2);
          model.addAttribute("authors3",authors3);
          model.addAttribute("authors4",authors4);
          model.addAttribute("authors5",authors5);
      }

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
        List<String>authors=new ArrayList<>();
        List<UserCourse>userCourses=new ArrayList<>();
        User tempuser;
        for(int i=0;i<courses.size();i++){
            String str="";
            userCourses=userCourseService.selectUCls(courses.get(i).getClsid());
            for(int j=0;j<userCourses.size();j++){
                tempuser=userService.selectuser(userCourses.get(j).getId());
                if(j==0)
                    str=tempuser.getRealname();
                else
                    str=str+","+tempuser.getRealname();
            }
            authors.add(str);
        }
        model.addAttribute("courses",courses);
        model.addAttribute("authors",authors);
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
      List<String>authors=new ArrayList<>();
      List<UserBook>userBooks;
      User tempuser;
      for(int i=0;i<books.size();i++)
      {
          String str=books.get(i).getBabstract();
          books.get(i).setBabstract(cutStr(str,50));
          String string="";
          userBooks=userBookService.selectUBs(books.get(i).getBid());
          for(int j=0;j<userBooks.size();j++){
              tempuser=userService.selectuser(userBooks.get(j).getId());
              if(j==0)
                  string=tempuser.getRealname();
              else
                  string=string+","+tempuser.getRealname();
          }
          authors.add(string);
      }
      model.addAttribute("books",books);
      model.addAttribute("authors",authors);

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
            int srank=Integer.valueOf(req.getParameter("srank"));
            students=studentsService.queryBySrank(srank);
           // students=studentsService.queryAll();
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
        model.addAttribute("usertype",usertype);
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
            //返回相关联用户名
            List<UserPaper>ups=new ArrayList<>();
            User tempuser;
            List<String>authors=new ArrayList<>();
            Paper paper;
            for(int i=0;i<userPapers.size();i++)
            {
                String str="";
                paper=paperService.selectPaper(userPapers.get(i).getPid());
                ups=userPaperService.selectUPps(paper.getPid());
                for(int j=0;j<ups.size();j++){
                    tempuser=userService.selectuser(ups.get(j).getId());
                    if(ups.get(j).getAuthornumber()<0)//通讯作者
                    {
                        if(paper.getLanguage()==1)//中文
                            str=str+"."+tempuser.getRealname()+'*';
                        if(paper.getLanguage()==2)//英文
                            str=str+"."+tempuser.getEngname()+'*';
                    }else{
                        if(paper.getLanguage()==1)//中文
                            str=str+"."+tempuser.getRealname();
                        if(paper.getLanguage()==2)//英文
                            str=str+"."+tempuser.getEngname();
                    }
                }
                authors.add(str);
                papers.add(paper);
            }
            model.addAttribute("papers",papers);
            model.addAttribute("pauthors",authors);

            /*获取教师所参与的项目*/
            List<UserPro>userPros=userProService.selectUPsById(teacher.getId());
            List<Project>projects=new ArrayList<>();
            //返回相关联用户名
            List<UserPro>upros=new ArrayList<>();
            List<String>proauthors=new ArrayList<>();
            Project project;
            for(int i=0;i<userPros.size();i++)
            {
                String str="";
                project=projectService.selectProject(userPros.get(i).getProid());
                upros=userProService.selectUPs(project.getProid());
                for(int j=0;j<upros.size();j++){
                    tempuser=userService.selectuser(upros.get(j).getId());
                    str=str+"."+tempuser.getRealname();
                }
                proauthors.add(str);
                projects.add(project);
            }
            model.addAttribute("projects",projects);
            model.addAttribute("proauthors",proauthors);

            /*获取教师所参与课程*/
            List<UserCourse>userCourses=userCourseService.selectCidByid(id);
            List<Course>courses=new ArrayList<>();
            //返回相关联用户名
            List<UserCourse>ucs=new ArrayList<>();
            List<String>cauthors=new ArrayList<>();
            Course course;
            for(int i=0;i<userCourses.size();i++){
                String str="";
                course=courseService.selectCourse(userCourses.get(i).getClsid());
                ucs=userCourseService.selectUCls(course.getClsid());
                for(int j=0;j<ucs.size();j++){
                    tempuser=userService.selectuser(ucs.get(j).getId());
                    str=str+"."+tempuser.getRealname();
                }
                cauthors.add(str);
                courses.add(course);

            }
            model.addAttribute("courses",courses);
            model.addAttribute("cauthors",cauthors);
            /*获取教师所写著作*/
            List<UserBook>userBooks=userBookService.selectBidByid(id);
            List<Book>books=new ArrayList<>();
            //返回相关联用户名
            List<UserBook>ubs=new ArrayList<>();
            List<String>bauthors=new ArrayList<>();
            Book book;
            for(int i=0;i<userBooks.size();i++){
                String str="";
                book=bookService.selectBook(userBooks.get(i).getBid());
                ubs=userBookService.selectUBs(book.getBid());
                for(int j=0;j<ubs.size();j++){
                    tempuser=userService.selectuser(ubs.get(j).getId());
                    str=str+"."+tempuser.getRealname();
                }
                bauthors.add(str);
                books.add(book);
            }
            model.addAttribute("books",books);
            model.addAttribute("bauthors",bauthors);
        }
        if(usertype==1){
            student=studentsService.selectStudentById(id);
            System.out.println(student.toString());
            /*获取学生所发表的论文*/
            List<UserPaper>userPapers=userPaperService.selectUPpsById(student.getId());
            List<Paper>papers=new ArrayList<>();
            //返回相关联用户名
            List<UserPaper>ups=new ArrayList<>();
            User tempuser;
            List<String>authors=new ArrayList<>();
            Paper paper;
            for(int i=0;i<userPapers.size();i++)
            {
                String str="";
                paper=paperService.selectPaper(userPapers.get(i).getPid());
                ups=userPaperService.selectUPps(paper.getPid());
                for(int j=0;j<ups.size();j++){
                    tempuser=userService.selectuser(ups.get(j).getId());
                    if(ups.get(j).getAuthornumber()<0)//通讯作者
                    {
                        if(paper.getLanguage()==1)//中文
                            str=str+"."+tempuser.getRealname()+'*';
                        if(paper.getLanguage()==2)//英文
                            str=str+"."+tempuser.getEngname()+'*';
                    }else{
                        if(paper.getLanguage()==1)//中文
                            str=str+"."+tempuser.getRealname();
                        if(paper.getLanguage()==2)//英文
                            str=str+"."+tempuser.getEngname();
                    }
                }
                authors.add(str);
                papers.add(paper);
            }
            model.addAttribute("papers",papers);
            model.addAttribute("pauthors",authors);
            /*获取学生所参与的项目*/
            List<UserPro>userPros=userProService.selectUPsById(student.getId());
            List<Project>projects=new ArrayList<>();
            //返回相关联用户名
            List<UserPro>upros=new ArrayList<>();
            List<String>proauthors=new ArrayList<>();
            Project project;
            for(int i=0;i<userPros.size();i++)
            {
                String str="";
                project=projectService.selectProject(userPros.get(i).getProid());
                upros=userProService.selectUPs(project.getProid());
                for(int j=0;j<upros.size();j++){
                    tempuser=userService.selectuser(upros.get(j).getId());
                    str=str+"."+tempuser.getRealname();
                }
                proauthors.add(str);
                projects.add(project);
            }
            model.addAttribute("projects",projects);
            model.addAttribute("proauthors",proauthors);
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
  public String project(Model model,HttpServletRequest req){
        System.out.println("Suceed in project");
        //List<Project>projects=projectService.queryAll();
       int protype=Integer.parseInt(req.getParameter("protype"));
        List<Project>projects=projectService.queryByType(protype);
        List<UserPro>userPros;
        List<String>authors=new ArrayList<>();
        User tempuser;
        for(int i=0;i<projects.size();i++){
            String str="";
            userPros=userProService.selectUPs(projects.get(i).getProid());
            for(int j=0;j<userPros.size();j++){
                tempuser=userService.selectuser(userPros.get(j).getId());
                str=str+"."+tempuser.getRealname();
            }
            authors.add(str);
        }
        model.addAttribute("projects",projects);
        model.addAttribute("authors",authors);

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
        /*呈现有哪些研究方向*/
        List<Researcharea>researchareas=researchareaService.queryAll();
        model.addAttribute("researchareas",researchareas);
        model.addAttribute("rsize",researchareas.size());
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
