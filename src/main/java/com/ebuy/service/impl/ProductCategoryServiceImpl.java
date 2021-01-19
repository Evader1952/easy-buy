package com.ebuy.service.impl;

import com.ebuy.mapper.ProductCategoryMapper;
import com.ebuy.model.query.ProductCategoryQuery;
import com.ebuy.pojo.ProductCategory;
import com.ebuy.service.ProductCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (ProductCategory)表服务实现类
 *
 * @author makejava
 * @since 2021-01-19 15:04:02
 */
@Service("productCategoryService")
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Resource
    private ProductCategoryMapper productCategoryMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProductCategory queryById(Integer id) {
        return this.productCategoryMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<ProductCategory> queryAllByLimit(int offset, int limit) {
        return this.productCategoryMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param productCategory 实例对象
     * @return 实例对象
     */
    @Override
    public ProductCategory insert(ProductCategory productCategory) {
        this.productCategoryMapper.insert(productCategory);
        return productCategory;
    }

    /**
     * 修改数据
     *
     * @param productCategory 实例对象
     * @return 实例对象
     */
    @Override
    public ProductCategory update(ProductCategory productCategory) {
        this.productCategoryMapper.update(productCategory);
        return this.queryById(productCategory.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.productCategoryMapper.deleteById(id) > 0;
    }


    @Override
    public List<ProductCategory> getCategories() {
        //封装三级类别菜单
        //1.先按照父分类编号升序查询所有的类别信息
        ProductCategoryQuery query = new ProductCategoryQuery();
        query.setOrderBy("parent_id");
        query.setSort("ASC");
        List<ProductCategory> list = productCategoryMapper.queryAll(query);

        //2.创建集合用来存放组装后的类别列表
        List<ProductCategory> categories = new ArrayList<>();

        //3.提供Map进行缓存，这样子分类可以快速找到父分类
        Map<Integer,ProductCategory> map = new HashMap<>();

        //4.组长数据
        for (ProductCategory category:
                list) {
            //先找到一级分类，存入集合
            if(category.getParentId() == 0){
                //封装好了一级分类
                categories.add(category);
            }
            //将所有的分类信息，装到键值对中，这样可以方便找到
            map.put(category.getId(),category);
            //将子分类封装到对应的父分类中：
            //先通过子分类的父类编号，找到对应的父分类对象
            ProductCategory parent = map.get(category.getParentId());
            //如果parent不为空，说明此时的category是子分类，那么就填充到对应的父分类中
            if(parent!=null){
                parent.getCategories().add(category);
            }
        }
        return categories;
    }
}