package com.ebuy.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (News)实体类
 *
 * @author makejava
 * @since 2021-01-19 14:47:30
 */
@Data
public class News implements Serializable {
    private static final long serialVersionUID = 403667382705193445L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;



}