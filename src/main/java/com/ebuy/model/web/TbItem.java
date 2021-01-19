package com.ebuy.model.web;

import lombok.Data;

/**
 * 购物车商品
 */
@Data
public class TbItem {
    private Integer productId;  //商品编号
    private String fileName;  //商品图片
    private String name; //商品名称
    private Integer count;  //购买数量
    private Float price; //小计
    private Float total;  //总计
}
