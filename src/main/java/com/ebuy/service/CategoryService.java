package com.ebuy.service;

import com.ebuy.pojo.EasybuyProductCategory;

import java.util.List;

public interface CategoryService {

    /**
     * 查询所有类别信息
     * @return
     */
    List<EasybuyProductCategory> getCategories();
}
