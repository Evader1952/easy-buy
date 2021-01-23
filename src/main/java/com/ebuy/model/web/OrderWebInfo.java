package com.ebuy.model.web;

import lombok.Data;

/**
 * @description:
 * @author: mapei
 * @create: 2021-01-23 16:23
 **/
@Data
public class OrderWebInfo {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 订单号
     */
    private String serialNumber;
    /**
     * 用户主键
     */
    private Integer userId;

    private String loginName;
    /**
     * 用户地址
     */
    private String userAddress;
    /**
     * 总消费
     */
    private Float cost;
    /**
     * 创建时间
     */
    private String createTime;

    private Integer status;

    private  String statusDesc;

    private Integer type;
}
