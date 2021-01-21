package com.ebuy.service.impl;

import com.ebuy.enums.OrderStatusEnum;
import com.ebuy.mapper.OrderMapper;
import com.ebuy.model.query.OrderQuery;
import com.ebuy.model.web.TbItem;
import com.ebuy.pojo.Order;
import com.ebuy.pojo.OrderDetail;
import com.ebuy.pojo.User;
import com.ebuy.service.OrderDetailService;
import com.ebuy.service.OrderService;
import com.ebuy.service.UserAddressService;
import com.ebuy.utils.DataUtil;
import com.ebuy.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Order)表服务实现类
 *
 * @author makejava
 * @since 2021-01-19 14:55:37
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private UserAddressService userAddressService;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Order queryById(Integer id) {
        return this.orderMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Order> queryAllByLimit(int offset, int limit) {
        return this.orderMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order insert(Order order) {
        this.orderMapper.insert(order);
        return order;
    }

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order update(Order order) {
        this.orderMapper.update(order);
        return this.queryById(order.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.orderMapper.deleteById(id) > 0;
    }

    @Override
    public List<Order> queryAll(OrderQuery query) {
        return orderMapper.queryAll(query);
    }

    @Override
    public String createOrder(User user, List<TbItem> shopcart, Float total) {
        if (DataUtil.isEmpty(user)||DataUtil.isEmpty(user.getLoginName())){
            return "请登录";
        }
        if (DataUtil.isEmpty(shopcart)){
            return "请选择商品";
        }
        if (DataUtil.isEmpty(shopcart)){
            return "请选择商品";
        }
        Order order = new Order();
        order.setSerialNumber(StringUtil.getTradeNo());
        order.setUserId(user.getId());
        order.setLoginName(user.getLoginName());
        //页面选择的地址
        order.setUserAddress("");
        order.setCost(total);
        order.setCreateTime(new Date());
        order.setStatus(OrderStatusEnum.WAIT.toCode());
        //订单类型？ 不确定
        order.setType(null);
        Order insert = this.insert(order);
        List<OrderDetail> detailList = shopcart.stream().map(c -> getOrderDetail(c, insert.getId())).collect(Collectors.toList());
        orderDetailService.insertBath(detailList);
        return null;
    }

    OrderDetail getOrderDetail(TbItem tbItem,Integer orderId){
        OrderDetail detail = new OrderDetail();
        detail.setOrderId(orderId);
        detail.setProductId(tbItem.getProductId());
        detail.setQuantity(tbItem.getCount());
        detail.setCost(tbItem.getPrice());
        return  detail;
    }
}