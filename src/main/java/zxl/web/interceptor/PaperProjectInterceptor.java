package zxl.web.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import zxl.web.domain.User;
import zxl.web.domain.UserPaper;
import zxl.web.domain.UserPro;
import zxl.web.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class PaperProjectInterceptor implements HandlerInterceptor {

    private static final String MAIN_URL = "/admin/main";

    @Autowired
    IUserService userService;

    @Autowired
    IUserPaperService userPaperService;

    @Autowired
    IUserProjectService userProjectService;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        HttpSession session = req.getSession(true);
        // 从session 里面获取用户名的信息
        User user = (User)session.getAttribute("user");
        if(user.getIsadmin()==false)
        {
            if(req.getRequestURI().equals("/paper/edit") || req.getRequestURI().equals("/paper/delete"))
            {
                try{
                    int pid = Integer.parseInt(req.getParameter("pid"));
                    List<UserPaper> userPaperList = userPaperService.selectUPs(pid);
                    for(int i=0; i<userPaperList.size();i++)
                    {
                        if(userPaperList.get(i).getId() == user.getId())
                        {
                            return true;
                        }
                    }
                }
                catch (Exception e)
                {
                    res.sendRedirect(MAIN_URL);
                    return false;
                }
                res.sendRedirect(MAIN_URL);
                return false;
            }
            if(req.getRequestURI().equals("/project/edit") || req.getRequestURI().equals("/project/delete"))
            {
                try{
                    int pid = Integer.parseInt(req.getParameter("proid"));
                    List<UserPro> userProList = userProjectService.selectUPs(pid);
                    for(int i=0; i<userProList.size();i++)
                    {
                        System.out.println(userProList.get(i).getId());
                        if(userProList.get(i).getId() == user.getId())
                        {
                            return true;
                        }
                    }
                }
                catch (Exception e)
                {
                    res.sendRedirect(MAIN_URL);
                    return false;
                }
                res.sendRedirect(MAIN_URL);
                return false;
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
