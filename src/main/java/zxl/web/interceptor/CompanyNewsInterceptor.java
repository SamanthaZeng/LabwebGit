package zxl.web.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import zxl.web.domain.User;

public class CompanyNewsInterceptor implements HandlerInterceptor {

    private static final String MAIN_URL = "/admin/main";

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        HttpSession session = req.getSession(true);
        // 从session 里面获取用户名的信息
        User user = (User)session.getAttribute("user");
        // 判断如果没有取到用户信息，就跳转到登录页面，提示用户进行登录
        if(user.getIsadmin()==false)
        {
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
