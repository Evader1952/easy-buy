package com.ebuy.pojo;

import com.ebuy.enums.OrderStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2021-01-19 16:37:16
 */
@Data
public class Order   {
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
    private Date createTime;

    private Integer status;

    private Integer type;

  //  public  Boolean isSuccess(){
//        return  status.equals(OrderStatusEnum.SUCCESS.toCode());
//    }

}