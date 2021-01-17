package com.ebuy.service.impl;

import com.ebuy.mapper.EasybuyProductMapper;
import com.ebuy.pojo.EasybuyProduct;
import com.ebuy.pojo.EasybuyProductExample;
import com.ebuy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private EasybuyProductMapper productMapper;

    @Override
    public List<EasybuyProduct> getProducts(Integer cid) {
        EasybuyProductExample example = new EasybuyProductExample();
        EasybuyProductExample.Criteria criteria = example.createCriteria();
        criteria.andCategorylevel1idEqualTo(cid);
        return productMapper.selectByExample(example);
    }

    @Override
    public EasybuyProduct getById(Integer pid) {
        return productMapper.selectByPrimaryKey(pid);
    }
}
