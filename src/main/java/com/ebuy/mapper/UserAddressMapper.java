package com.ebuy.mapper;

import com.ebuy.pojo.UserAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (UserAddress)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-19 15:24:32
 */
public interface UserAddressMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserAddress queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserAddress> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userAddress 实例对象
     * @return 对象列表
     */
    List<UserAddress> queryAll(UserAddress userAddress);

    /**
     * 新增数据
     *
     * @param userAddress 实例对象
     * @return 影响行数
     */
    int insert(UserAddress userAddress);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserAddress> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserAddress> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserAddress> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<UserAddress> entities);

    /**
     * 修改数据
     *
     * @param userAddress 实例对象
     * @return 影响行数
     */
    int update(UserAddress userAddress);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}