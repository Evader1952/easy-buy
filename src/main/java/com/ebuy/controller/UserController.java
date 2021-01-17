package com.ebuy.controller;

import com.ebuy.pojo.EasybuyUser;
import com.ebuy.service.UserService;
import com.ebuy.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param userName
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String login(String userName, String password,
                        HttpSession session, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8;");
        String md5Pwd = MD5.MD5(password);
        List<EasybuyUser> users = userService.login(userName,md5Pwd);
        if(users.size()==0){
            //登录失败
            response.getWriter().write("<script>window.location='/login.jsp';alert('登录失败')</script>");
            return null;
        }else{
            //登录成功
            session.setAttribute("user",users.get(0));
            return "redirect:/index/initData";
        }
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping("/reg")
    public String reg(EasybuyUser user){
        //前台用户：类型为0
        user.setType(0);
        //将密码加密
        user.setPassword(MD5.MD5(user.getPassword()));
        userService.reg(user);
        return "../../login";
    }

}