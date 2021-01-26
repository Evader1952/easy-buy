package com.ebuy.interceptor;

import com.ebuy.model.RequestContext;
import com.ebuy.pojo.User;
import com.ebuy.service.UserService;
import com.ebuy.utils.DataUtil;
import com.ebuy.utils.DateUtil;
import com.ebuy.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 *
 * @Author: mapei
 * @Date: 2021/1/25 10:39
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    private static final PathMatcher pathMatcher = new AntPathMatcher();

    /**
     * 不受到保护的url
     *
     * @param request
     * @return
     */
    private boolean isNotProtectedUrl(HttpServletRequest request) {
        return pathMatcher.match("/login.jsp", request.getServletPath())
                || pathMatcher.match("/reg.jsp", request.getServletPath())
                || pathMatcher.match("/index.jsp", request.getServletPath())
                || pathMatcher.match("/user/**", request.getServletPath())
                || pathMatcher.match("/index/**", request.getServletPath())
                || pathMatcher.match("/news/**", request.getServletPath());
    }

    /**
     * 登录url
     *
     * @param request
     * @return
     */
    private boolean isLoginUrl(HttpServletRequest request) {
        return pathMatcher.match("/user/login", request.getServletPath());
    }

    @Autowired
    private UserService userService;

    private String dispatchUrl = "/login.jsp";
    private String indexUrl = "/index/initData";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        log.error("url:{}", request.getServletPath());
        if (isLoginUrl(request)) {
            response.setContentType("text/html;charset=utf-8;");
            String password = request.getParameter("password");
            String userName = request.getParameter("userName");
            String md5Pwd = MD5Util.MD5(password);
            User user = userService.login(userName, md5Pwd);
            if (DataUtil.isEmpty(user)) {
                //登录失败
                response.getWriter().write("<script>window.location='/login.jsp';alert('登录失败')</script>");
                return false;
            } else {
                //登录成功
                //方式一:存储在session
                //方式二: 存在redis 设置时效时间   在user/login接口中 获取userInfo 返回到页面端
                //方式三: 存到请求中
                request.getSession().setAttribute("user", user);
                response.sendRedirect(indexUrl);
                return true;
            }
        }
        if (isNotProtectedUrl(request)) {
            return true;
        } else {
            User user = (User) request.getSession().getAttribute("user");
            if (!DataUtil.isEmpty(user)) {
                RequestContext.RequestUser requestUser = new RequestContext.RequestUser();
                BeanUtils.copyProperties(user, requestUser);
                requestUser.setCreateTime(DataUtil.isEmpty(user.getCreateTime()) ? "" : DateUtil.formatDate(user.getCreateTime(), DateUtil.PATTERN_YYYY_MM_DD_HH_MM_SS));
                RequestContext.setCurrentUser(requestUser);
                return true;
            } else {
                //如果是ajax
                if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
                    response.setHeader("SESSIONSTATUS", "TIMEOUT");
                    response.setHeader("path", request.getContextPath()+"/login.jsp");
                    // FORBIDDEN。也就是禁止、403
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                }else {
                    response.sendRedirect(dispatchUrl);

                }
                return false;
            }
        }
        //  return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
