package com.ebuy.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (UserAddress)实体类
 *
 * @author makejava
 * @since 2021-01-19 15:24:31
 */
@Data
public class UserAddress implements Serializable {
    private static final long serialVersionUID = 884007395468797410L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户主键
     */
    private Integer userId;
    /**
     * 地址
     */
    private String address;
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否是默认地址（1:是 0否）
     */
    private Integer isDefault;
    /**
     * 创建时间
     */
    private Date createTime;



}