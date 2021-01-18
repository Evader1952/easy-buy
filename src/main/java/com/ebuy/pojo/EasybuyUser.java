package com.ebuy.pojo;

import com.ebuy.model.Param;
import lombok.Data;

@Data
public class EasybuyUser  extends Param {
    private Integer id;

    private String loginname;

    private String username;

    private String password;

    private Integer sex;

    private String identitycode;

    private String email;

    private String mobile;

    private Integer type;



    public   String check(){
        if(checkNull(loginname)){
            return "请填写登录用户名";
        }
        if(checkNull(password)){
            return "请填写密码  ";
        }
        if(checkNull(username)){
            return "请填写真实姓名";
        }
        if(checkNull(sex)){
            return "请填写性别";
        }
        if(checkNull(identitycode)){
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