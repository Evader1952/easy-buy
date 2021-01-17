package com.ebuy.service.impl;

import com.ebuy.mapper.EasybuyProductCategoryMapper;
import com.ebuy.pojo.EasybuyProduct;
import com.ebuy.pojo.EasybuyProductCategory;
import com.ebuy.pojo.EasybuyProductCategoryExample;
import com.ebuy.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private EasybuyProductCategoryMapper categoryMapper;

    @Override
    public List<EasybuyProductCategory> getCategories() {
        //封装三级类别菜单
        //1.先按照父分类编号升序查询所有的类别信息
        EasybuyProductCategoryExample example = new EasybuyProductCategoryExample();
        //排序
        example.setOrderByClause("parentId");
        List<EasybuyProductCategory> list = categoryMapper.selectByExample(example);

        //2.创建集合用来存放组装后的类别列表
        List<EasybuyProductCategory> categories = new ArrayList<>();

        //3.提供Map进行缓存，这样子分类可以快速找到父分类
        Map<Integer,EasybuyProductCategory> map = new HashMap<>();

        //4.组长数据
        for (EasybuyProductCategory category:
             list) {
           //先找到一级分类，存入集合
            if(category.getParentid() == 0){
                categories.add(category);  //封装好了一级分类
            }

            //将所有的分类信息，装到键值对中，这样可以方便找到
            map.put(category.getId(),category);

            //将子分类封装到对应的父分类中：
            //先通过子分类的父类编号，找到对应的父分类对象
            EasybuyProductCategory parent = map.get(category.getParentid());
            //如果parent不为空，说明此时的category是子分类，那么就填充到对应的父分类中
            if(parent!=null){
                parent.getCategories().add(category);
            }
        }
        return categories;
    }
}
