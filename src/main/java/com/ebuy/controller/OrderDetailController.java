package com.ebuy.controller;

import com.ebuy.pojo.OrderDetail;
import com.ebuy.service.OrderDetailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (OrderDetail)表控制层
 *
 * @author makejava
 * @since 2021-01-19 14:57:28
 */
@RestController
@RequestMapping("orderDetail")
public class OrderDetailController {
    /**
     * 服务对象
     */
    @Resource
    private OrderDetailService orderDetailService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public OrderDetail selectOne(Integer id) {
        return this.orderDetailService.queryById(id);
    }

}