package com.ebuy.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * (ProductCategory)实体类
 *
 * @author makejava
 * @since 2021-01-19 15:04:01
 */
@Data
public class ProductCategory implements Serializable {
    private static final long serialVersionUID = 194833181077094101L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 父级目录id
     */
    private Integer parentId;
    /**
     * 级别(1:一级 2：二级 3：三级)
     */
    private Integer type;
    /**
     * 图标
     */
    private String iconClass;

    /**
     * 用于封装子分类
     */
    private List<ProductCategory> categories=new ArrayList<>();


}