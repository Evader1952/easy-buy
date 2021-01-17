package com.ebuy.service;

import com.ebuy.pojo.EasybuyProduct;

import java.util.List;

public interface ProductService {

    /**
     * 根据类别编号查询商品信息
     * @param cid
     * @return
     */
    List<EasybuyProduct> getProducts(Integer cid);

    /**
     * 根据商品编号查询商品信息
     * @param pid
     * @return
     */
    EasybuyProduct getById(Integer pid);
}
