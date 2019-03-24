package zxl.web.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import zxl.web.domain.*;
import zxl.web.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CourseBookInterceptor implements HandlerInterceptor {

    private static final String MAIN_URL = "/admin/main";

    @Autowired
    IUserService userService;

    @Autowired
    IUserCourseService userCourseService;

    @Autowired
    IUserBookService userBookService;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        HttpSession session = req.getSession(true);
        // 从session 里面获取用户名的信息
        User user = (User)session.getAttribute("user");
        if(user.getIsadmin() == false)
        {
            if(user.getUsertype() != 0)
            {
                res.sendRedirect(MAIN_URL);
                return false;
            }
            else{
                if(req.getRequestURI().equals("/course/add"))
                {
                    return true;
                }
                else
                if(req.getRequestURI().equals("/course/edit") || req.getRequestURI().equals("/course/delete"))
                {
                    try{
                        int clsid = Integer.parseInt(req.getParameter("clsid"));
                        List<UserCourse> userCourseList = userCourseService.selectUCls(clsid);
                        for(int i=0; i<userCourseList.size(); i++)
                        {
                            if(userCourseList.get(i).getId() == user.getId())
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
                if(req.getRequestURI().equals("/book/add"))
                {
                    return true;
                }
                else
                if(req.getRequestURI().equals("/book/edit") || req.getRequestURI().equals("/book/delete"))
                {
                    try{
                        int bid = Integer.parseInt(req.getParameter("bid"));
                        List<UserBook> userBookList = userBookService.selectUBs(bid);
                        for(int i=0; i<userBookList.size(); i++)
                        {
                            if(userBookList.get(i).getId() == user.getId())
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
                return true;
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