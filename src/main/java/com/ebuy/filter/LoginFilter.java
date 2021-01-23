package com.ebuy.filter;

import com.ebuy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @description: 登录过滤器
 * @author: mapei
 * @create: 2021-01-23 16:44
 **/
@Component
public class LoginFilter implements Filter {

    protected static final PathMatcher pathMatcher = new AntPathMatcher();

    protected boolean isNotProtectedUrl(HttpServletRequest request) {
        return pathMatcher.match("/login.jsp", request.getServletPath())
                ||pathMatcher.match("/reg.jsp", request.getServletPath())
                ||pathMatcher.match("/index.jsp", request.getServletPath())
                ||pathMatcher.match("/user/login", request.getServletPath())
                ||pathMatcher.match("/index/**", request.getServletPath())
                ||pathMatcher.match("/news/**", request.getServletPath())
                ;
    }
    @Autowired
    private UserService userService;

    private String dispatchUrl = "/login.jsp";


    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        //不受到保护的url
        if (isNotProtectedUrl(request)) {
            arg2.doFilter(arg0, arg1);
        } else {
            Object userObj = request.getSession().getAttribute("user");
            if (userObj != null) {
                arg2.doFilter(arg0, arg1);
            } else {
                response.sendRedirect(request.getContextPath() + dispatchUrl);
            }
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        dispatchUrl = arg0.getInitParameter("dispatchUrl");

    }

}
