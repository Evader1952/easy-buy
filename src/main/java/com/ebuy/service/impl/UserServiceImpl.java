package com.ebuy.service.impl;

import com.ebuy.mapper.EasybuyUserMapper;
import com.ebuy.pojo.EasybuyUser;
import com.ebuy.pojo.EasybuyUserExample;
import com.ebuy.service.UserService;
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
    public void reg(EasybuyUser user) {
        easybuyUserMapper.insert(user);
    }
}
