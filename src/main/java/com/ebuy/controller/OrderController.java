package com.ebuy.controller;

import com.ebuy.enums.OrderStatusEnum;
import com.ebuy.model.RequestContext;
import com.ebuy.model.Response;
import com.ebuy.model.query.OrderQuery;
import com.ebuy.model.web.OrderWebInfo;
import com.ebuy.model.web.TbItem;
import com.ebuy.pojo.Order;
import com.ebuy.pojo.Product;
import com.ebuy.pojo.User;
import com.ebuy.service.OrderService;
import com.ebuy.utils.DataUtil;
import com.ebuy.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

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


    /**
     * 创建订单
     * @param addressId
     * @param session
     * @return
     */
    @PostMapping("createOrder")
    public Response createOrder(Integer addressId, HttpSession session) {
        List<TbItem> shopCart = (List<TbItem>) session.getAttribute("shopcart");
        Float total = (Float) session.getAttribute("total");
        orderService.createOrder(shopCart, total, addressId);
        return Response.ok("订单创建成功");
    }

    /**
     * 后台订单管理
     * @param query
     * @param session
     * @return
     */
    @GetMapping("list")
    public Response list(OrderQuery query,HttpSession session) {
        RequestContext.RequestUser user = RequestContext.getCurrentUser();
        if (DataUtil.isEmpty(user)){
            return Response.fail("请登录");
        }
       query.setUserId(user.getId());
       PageHelper.startPage(query.getPageNow(),10);
        List<Order> orders = orderService.queryAll(query);
        List<OrderWebInfo> webInfoList = orders.stream().map(this::getWeb).collect(Collectors.toList());
        PageInfo<OrderWebInfo> pageInfo = new PageInfo<>(webInfoList);
        return Response.ok(pageInfo);
    }

     private OrderWebInfo getWeb(Order order){
         OrderWebInfo webInfo = new OrderWebInfo();
         BeanUtils.copyProperties(order, webInfo);
         webInfo.setStatusDesc(OrderStatusEnum.getDescByCode(order.getStatus()));
         webInfo.setCreateTime(DataUtil.isEmpty(order.getCreateTime()) ? "" : DateUtil.formatDate(order.getCreateTime(), DateUtil.PATTERN_YYYY_MM_DD_HH_MM_SS));
        return webInfo;
     }
}