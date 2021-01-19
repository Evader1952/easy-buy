package com.ebuy.model.query;

import com.ebuy.pojo.ProductCategory;
import lombok.Data;

/**
 * @description: 查询
 * @author: mapei
 * @create: 2021-01-19 15:09
 **/
@Data
public class ProductCategoryQuery extends ProductCategory {

    private  String sort;

    private  String orderBy;

}
