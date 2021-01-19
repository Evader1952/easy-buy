package com.ebuy.mapper;

import com.ebuy.pojo.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (ProductCategory)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-19 15:04:01
 */
public interface ProductCategoryMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProductCategory queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ProductCategory> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param productCategory 实例对象
     * @return 对象列表
     */
    List<ProductCategory> queryAll(ProductCategory productCategory);

    /**
     * 新增数据
     *
     * @param productCategory 实例对象
     * @return 影响行数
     */
    int insert(ProductCategory productCategory);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ProductCategory> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ProductCategory> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ProductCategory> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<ProductCategory> entities);

    /**
     * 修改数据
     *
     * @param productCategory 实例对象
     * @return 影响行数
     */
    int update(ProductCategory productCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}