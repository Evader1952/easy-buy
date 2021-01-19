package com.ebuy.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * (Product)实体类
 *
 * @author makejava
 * @since 2021-01-19 14:58:05
 */
@Data
public class Product implements Serializable {
    private static final long serialVersionUID = -65150559347726876L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 价格
     */
    private Float price;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 分类1
     */
    private Integer categoryLevel1Id;
    /**
     * 分类2
     */
    private Integer categoryLevel2Id;
    /**
     * 分类3
     */
    private Integer categoryLevel3Id;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 是否删除(1：删除 0：未删除)
     */
    private Integer isDelete;



}