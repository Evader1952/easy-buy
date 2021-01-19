package com.ebuy.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * (OrderDetail)实体类
 *
 * @author makejava
 * @since 2021-01-19 14:57:27
 */
@Data
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 283745762100068587L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 订单主键
     */
    private Integer orderId;
    /**
     * 商品主键
     */
    private Integer productId;
    /**
     * 数量
     */
    private Integer quantity;
    /**
     * 消费
     */
    private Object cost;



}