package com.ebuy.model.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.Order;

/**
 * @description:  用户信息
 * @author: mapei
 * @create: 2021-01-19 09:44
 **/
@Data
@Builder(toBuilder=true)
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private String loginName;

    private String username;

    private String password;

    private Integer sex;

    private String identityCode;

    private String email;

    private String mobile;

    private Integer type;

    private String createTime;

    private Integer orderCount;
}
