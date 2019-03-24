package zxl.web.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import zxl.web.domain.User;
import zxl.web.service.IUserService;

public class PeopleManageInterceptor implements HandlerInterceptor {

    private static final String MAIN_URL = "/admin/main";

    @Autowired
    IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        HttpSession session = req.getSession(true);
        // 从session 里面获取用户名的信息
        User user = (User)session.getAttribute("user");
        // 判断用户是否为管理员，如不是，进行身份判断：允许放行教师修改、添加学生信息
        if (user.getIsadmin() == false) {
            if(req.getRequestURI().equals("/admin/add"))
                try
                {
                    if(user.getUsertype()==0 && req.getParameter("type").equals("1"))
                        return true;
                }
                catch (Exception e)
                {
                    res.sendRedirect(MAIN_URL);
                    return false;
                }
            if(req.getRequestURI().equals("/admin/edit"))
                try
                {
                    int userForEditId = Integer.parseInt(req.getParameter("id"));
                    if(user.getUsertype()==0 && userService.selectuser(userForEditId).getUsertype() == 1)
                    {
                        return true;
                    }
                    else
                        if(user.getId() == userForEditId)
                            return true;
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

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
