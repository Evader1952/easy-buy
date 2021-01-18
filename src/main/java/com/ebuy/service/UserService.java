package com.ebuy.service;

import com.ebuy.pojo.EasybuyUser;

import java.util.List;

public interface UserService {
    /**
     * 登录
     * @param name
     * @param pwd
     * @return
     */
    List<EasybuyUser> login(String name, String pwd);

    /**
     * 注册
     * @param user
     */
    String reg(EasybuyUser user);

    EasybuyUser queryByLoginName(String loginName);
}
