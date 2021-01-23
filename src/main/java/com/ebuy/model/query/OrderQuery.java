package com.ebuy.model.query;

import com.ebuy.pojo.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: mapei
 * @create: 2021-01-19 16:20
 **/
@Data
public class OrderQuery extends Order {

    private String sort;

    private Integer pageNow;
}
