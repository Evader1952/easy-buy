package com.ebuy.controller;

import com.ebuy.model.RequestContext;
import com.ebuy.pojo.User;
import com.ebuy.model.Response;
import com.ebuy.service.UserService;
import com.ebuy.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     *  走拦截器
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        RequestContext.RequestUser user = RequestContext.getCurrentUser();
        System.err.println(user);
       return null;
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session) {
        session.removeAttribute("user");
        return null;
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @RequestMapping("/reg")
    @ResponseBody
    public Response reg(User user,HttpSession session) {
        //前台用户：类型为0
        user.setType(0);
        String reason = userService.reg(user);
        if (reason != null) {
            return Response.fail(reason);
        }
        userService.queryByLoginName(user.getLoginName());
        session.setAttribute("user", user);
        return Response.ok("注册成功");
    }

}
