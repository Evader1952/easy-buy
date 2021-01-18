package com.ebuy.service.impl;

import com.ebuy.mapper.EasybuyUserMapper;
import com.ebuy.pojo.EasybuyUser;
import com.ebuy.pojo.EasybuyUserExample;
import com.ebuy.service.UserService;
import com.ebuy.utils.DataUtil;
import com.ebuy.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EasybuyUserMapper easybuyUserMapper;

    @Override
    public List<EasybuyUser> login(String name, String pwd) {
        EasybuyUserExample example = new EasybuyUserExample();
        EasybuyUserExample.Criteria criteria= example.createCriteria();
        criteria.andLoginnameEqualTo(name);
        criteria.andPasswordEqualTo(pwd);
        List<EasybuyUser> users = easybuyUserMapper.selectByExample(example);
        return users;
    }

    @Override
    public String reg(EasybuyUser user) {
        String reason = user.check();
        if (!DataUtil.isEmpty(reason)){
            return reason;
        }
        EasybuyUser easybuyUser = this.queryByLoginName(user.getLoginname());
        if (!DataUtil.isEmpty(easybuyUser)){
            return "用户名重复";
        }
        user.setPassword(MD5Util.MD5(user.getPassword()));
        easybuyUserMapper.insert(user);
        return  null;
    }

    @Override
    public EasybuyUser queryByLoginName(String loginName) {
        EasybuyUserExample example = new EasybuyUserExample();
        EasybuyUserExample.Criteria criteria= example.createCriteria();
        criteria.andLoginnameEqualTo(loginName);
        List<EasybuyUser> users = easybuyUserMapper.selectByExample(example);
        return DataUtil.isEmpty(users)?null:users.get(0);
    }
}
