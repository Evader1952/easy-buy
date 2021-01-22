package com.ebuy.model.query;

import com.ebuy.pojo.Product;
import lombok.Data;

/**
 * @description:
 * @author: mapei
 * @create: 2021-01-22 10:27
 **/
@Data
public class ProductQuery extends Product {

    private  String sort;

    private  String orderBy;
}
