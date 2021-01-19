package com.ebuy.enums;

import com.ebuy.utils.DataUtil;

/**
 * @description: 用户类型枚举
 * @author: mapei
 * @create: 2021-01-19 09:54
 **/
public enum OrderStatusEnum {


    WAIT("待审核", 1),
    SUCCESS("审核通过", 2),
    DEAL("配货", 3),
    SHIP("卖家已发货", 4),
    RECEIVED("已收货", 5);

    private Integer code;
    private String desc;

    public Integer toCode(){
        return this.code;
    }
    public String toDesc(){
        return this.desc;
    }

    OrderStatusEnum(String desc, Integer code) {
        this.code = code;
        this.desc = desc;
    }

    public static OrderStatusEnum getCode(String str){
        for(OrderStatusEnum e : values()){
            if(e.toDesc().equals(str)){
                return e;
            }
        }
        return null;
    }

    public static String getDescByCode(Integer code) {
        if (DataUtil.isEmpty(code)){
            return null;
        }
        for(OrderStatusEnum e : values()){
            if(e.toCode().equals(code)){
                return e.toDesc();
            }
        }
        return null;
    }


}
