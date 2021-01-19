package com.ebuy.service.impl;

import com.ebuy.mapper.OrderDetailMapper;
import com.ebuy.pojo.OrderDetail;
import com.ebuy.service.OrderDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OrderDetail)表服务实现类
 *
 * @author makejava
 * @since 2021-01-19 14:57:28
 */
@Service("orderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService {
    @Resource
    private OrderDetailMapper orderDetailMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OrderDetail queryById(Integer id) {
        return this.orderDetailMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<OrderDetail> queryAllByLimit(int offset, int limit) {
        return this.orderDetailMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param orderDetail 实例对象
     * @return 实例对象
     */
    @Override
    public OrderDetail insert(OrderDetail orderDetail) {
        this.orderDetailMapper.insert(orderDetail);
        return orderDetail;
    }

    /**
     * 修改数据
     *
     * @param orderDetail 实例对象
     * @return 实例对象
     */
    @Override
    public OrderDetail update(OrderDetail orderDetail) {
        this.orderDetailMapper.update(orderDetail);
        return this.queryById(orderDetail.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.orderDetailMapper.deleteById(id) > 0;
    }
}