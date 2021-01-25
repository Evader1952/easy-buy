package com.ebuy.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: mapei
 * @create: 2021-01-18 16:11
 **/
public class StringUtil {




    /**
     * 交易单号创建
     */
    public static String getTradeNo() {
        return System.currentTimeMillis() + createRandom( 8);
    }


    /**
     * 创建指定位数的随机数
     *
     * @param length     随机字符串长度
     */
    public static String createRandom(int length){
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }

}
