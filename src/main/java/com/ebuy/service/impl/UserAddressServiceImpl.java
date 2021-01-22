package com.ebuy.service.impl;

import com.ebuy.mapper.UserAddressMapper;
import com.ebuy.model.query.UserAddressQuery;
import com.ebuy.pojo.UserAddress;
import com.ebuy.service.UserAddressService;
import com.ebuy.utils.DataUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserAddress)表服务实现类
 *
 * @author makejava
 * @since 2021-01-19 15:24:32
 */
@Service("userAddressService")
public class UserAddressServiceImpl implements UserAddressService {
    @Resource
    private UserAddressMapper userAddressMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserAddress queryById(Integer id) {
        return this.userAddressMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<UserAddress> queryAllByLimit(int offset, int limit) {
        return this.userAddressMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userAddress 实例对象
     * @return 实例对象
     */
    @Override
    public UserAddress insert(UserAddress userAddress) {
        this.userAddressMapper.insert(userAddress);
        return userAddress;
    }

    /**
     * 修改数据
     *
     * @param userAddress 实例对象
     * @return 实例对象
     */
    @Override
    public UserAddress update(UserAddress userAddress) {
        this.userAddressMapper.update(userAddress);
        return this.queryById(userAddress.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userAddressMapper.deleteById(id) > 0;
    }

    @Override
    public List<UserAddress> queryList(UserAddressQuery query) {
        return userAddressMapper.queryAll(query);
    }

    @Override
    public UserAddress queryDefaultAddress(Integer userId) {
        UserAddressQuery query = new UserAddressQuery();
        query.setIsDefault(1);
        query.setUserId(userId);
        List<UserAddress> userAddresses = userAddressMapper.queryAll(query);
        return DataUtil.isEmpty(userAddresses)?null:userAddresses.get(0);
    }

    @Override
    public UserAddress queryByUidAndAid(Integer userId, Integer addressId) {
        UserAddressQuery query = new UserAddressQuery();
        query.setId(addressId);
        query.setUserId(userId);
        List<UserAddress> userAddresses = userAddressMapper.queryAll(query);
        return DataUtil.isEmpty(userAddresses)?null:userAddresses.get(0);
    }
}