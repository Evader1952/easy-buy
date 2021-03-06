package com.ebuy.service;

import com.ebuy.model.query.UserAddressQuery;
import com.ebuy.pojo.UserAddress;

import java.util.List;

/**
 * (UserAddress)表服务接口
 *
 * @author makejava
 * @since 2021-01-19 15:24:32
 */
public interface UserAddressService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserAddress queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserAddress> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userAddress 实例对象
     * @return 实例对象
     */
    UserAddress insert(UserAddress userAddress);

    /**
     * 修改数据
     *
     * @param userAddress 实例对象
     * @return 实例对象
     */
    UserAddress update(UserAddress userAddress);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<UserAddress> queryList(UserAddressQuery query);

    UserAddress queryDefaultAddress(Integer userId);

    UserAddress queryByUidAndAid(Integer userId,Integer addressId);
}