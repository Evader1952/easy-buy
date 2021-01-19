package com.ebuy.controller;

import com.ebuy.pojo.UserAddress;
import com.ebuy.service.UserAddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (UserAddress)表控制层
 *
 * @author makejava
 * @since 2021-01-19 15:24:32
 */
@RestController
@RequestMapping("userAddress")
public class UserAddressController {
    /**
     * 服务对象
     */
    @Resource
    private UserAddressService userAddressService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserAddress selectOne(Integer id) {
        return this.userAddressService.queryById(id);
    }

}