package com.ebuy.service.impl;

import com.ebuy.mapper.UserMapper;
import com.ebuy.pojo.User;
import com.ebuy.service.UserService;
import com.ebuy.utils.DataUtil;
import com.ebuy.utils.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-01-19 15:14:42
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userMapper.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userMapper.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userMapper.deleteById(id) > 0;
    }


    @Override
    public List<User> login(String name, String pwd) {
        User user = new User();
        user.setLoginName(name);
        user.setPassword(pwd);
        List<User> users = userMapper.queryAll(user);
        return users;
    }

    @Override
    public String reg(User user) {
        String reason = user.check();
        if (!DataUtil.isEmpty(reason)){
            return reason;
        }
        User easybuyUser = this.queryByLoginName(user.getLoginName());
        if (!DataUtil.isEmpty(easybuyUser)){
            return "用户名重复";
        }
        user.setPassword(MD5Util.MD5(user.getPassword()));
        userMapper.insert(user);
        return  null;
    }

    @Override
    public User queryByLoginName(String loginName) {
        User user = new User();
        user.setLoginName(loginName);
        List<User> users = userMapper.queryAll(user);
        return DataUtil.isEmpty(users)?null:users.get(0);
    }

}