package com.ebuy.controller;

import com.ebuy.model.Response;
import com.ebuy.model.web.TbItem;
import com.ebuy.pojo.Order;
import com.ebuy.pojo.User;
import com.ebuy.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (Order)表控制层
 *
 * @author makejava
 * @since 2021-01-19 14:55:37
 */
@RestController
@RequestMapping("order")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;


    @PostMapping("createOrder")
    public Response createOrder(Integer addressId,HttpSession session){
        User user = (User)session.getAttribute("user");
        List<TbItem> shopcart = (List<TbItem>) session.getAttribute("shopcart");
        Float total = (Float) session.getAttribute("total");
        orderService.createOrder(user,shopcart,total,addressId);
        return  Response.ok("订单创建成功");
    }


}