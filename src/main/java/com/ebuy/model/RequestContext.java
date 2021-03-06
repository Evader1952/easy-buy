package com.ebuy.model;

import lombok.Data;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *
 * @Author: mapei
 * @Date: 2021/1/25 10:39
 */
public class RequestContext {

    private static final String CURRENTUSER = "Current-User";

    public static void setCurrentUser(RequestUser user) {
        if (user != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            request.setAttribute(CURRENTUSER, user);
        }
    }


    public static RequestUser getCurrentUser() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return (RequestUser) request.getAttribute(CURRENTUSER);
    }

    @Data
    public static class RequestUser{

        /**
         * 主键
         */
        private Integer id;
        /**
         * 登录名
         */
        private String loginName;
        /**
         * 用户名
         */
        private String userName;
        /**
         * 密码
         */
        private String password;
        /**
         * 性别(1:男 0：女)
         */
        private Integer sex;
        /**
         * 身份证号
         */
        private String identityCode;
        /**
         * 邮箱
         */
        private String email;
        /**
         * 手机
         */
        private String mobile;
        /**
         * 类型（1：后台 0:前台）
         */
        private Integer type;
        private String createTime;



    }
}
