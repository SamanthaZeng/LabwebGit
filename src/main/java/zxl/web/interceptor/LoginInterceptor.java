package zxl.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import zxl.web.domain.User;


public class LoginInterceptor implements HandlerInterceptor {

    private static final String LOGIN_URL = "/";

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        HttpSession session = req.getSession(true);
        // 从session 里面获取用户名的信息
        User user = (User)session.getAttribute("user");
        // 判断如果没有取到用户信息，就跳转到登录页面，提示用户进行登录
        if (user == null || "".equals(user.toString())) {
            res.sendRedirect(LOGIN_URL);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object arg2, ModelAndView arg3) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception arg3) throws Exception {
    }

}