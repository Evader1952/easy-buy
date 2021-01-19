package com.ebuy.pojo;

import com.ebuy.model.Param;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2021-01-19 15:22:52
 */
@Data
public class User extends Param implements Serializable {
    private static final long serialVersionUID = -94788543539136137L;
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

    private Date createTime;


    public   String check(){
        if(checkNull(loginName)){
            return "请填写登录用户名";
        }
        if(checkNull(password)){
            return "请填写密码  ";
        }
        if(checkNull(userName)){
            return "请填写真实姓名";
        }
        if(checkNull(sex)){
            return "请填写性别";
        }
        if(checkNull(identityCode)){
            return "请填写身份证号";
        }
        if(checkNull(email)){
            return "请填写邮箱";
        }
        if(checkNull(mobile)){
            return "请填写手机号";
        }
        return  null;
    }
}