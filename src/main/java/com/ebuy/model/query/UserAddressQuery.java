package com.ebuy.model.query;

import com.ebuy.pojo.Product;
import com.ebuy.pojo.UserAddress;
import lombok.Data;

/**
 * @description:
 * @author: mapei
 * @create: 2021-01-22 10:27
 **/
@Data
public class UserAddressQuery extends UserAddress {

    private  String sort;

    private  String orderBy;
}
