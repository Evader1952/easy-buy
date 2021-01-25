package com.ebuy.model;


import com.alibaba.fastjson.JSONObject;
import com.ebuy.utils.DataUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @description:
 * @author: mapei
 * @create: 2021-01-18 16:11
 **/
public abstract class Param implements Serializable {
    /**
     * 检查不为空
     *
     * @param param 参数
     * @return
     */
    protected boolean checkNotNull(Object param) {
        return DataUtil.isNotEmpty(param);
    }

    /**
     * 检查为空
     *
     * @param param 参数
     * @return
     */
    protected boolean checkNull(Object param) {
        return DataUtil.isEmpty(param);
    }

    /**
     * 检查长度
     *
     * @param param  参数
     * @param length 最大长度
     * @return
     */
    protected boolean checkLength(String param, Integer length) {
        if (param.length() > length) {
            return true;
        }
        return false;
    }

    /**
     * 转换成JSON字符串
     *
     * @return
     */
    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
