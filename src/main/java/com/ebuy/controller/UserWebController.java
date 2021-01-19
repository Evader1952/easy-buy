package com.ebuy.controller;

import com.ebuy.enums.OrderStatusEnum;
import com.ebuy.model.Response;
import com.ebuy.model.query.OrderQuery;
import com.ebuy.model.web.UserInfo;
import com.ebuy.pojo.Order;
import com.ebuy.pojo.User;
import com.ebuy.service.OrderService;
import com.ebuy.service.UserService;
import com.ebuy.utils.DataUtil;
import com.ebuy.utils.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @description: 用户API
 * @author: mapei
 * @create: 2021-01-19 09:40
 **/
@Slf4j
@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserWebController {

    final private UserService userService;
    final private OrderService orderService;

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public Response<UserInfo> getUserInfo(HttpSession session) {
        User user = (User) session.getAttribute("user");
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(user, userInfo);
        userInfo.setCreateTime(DataUtil.isEmpty(user.getCreateTime()) ? "" : DateUtil.formatDate(user.getCreateTime(), DateUtil.PATTERN_YYYY_MM_DD));
        OrderQuery query = new OrderQuery();
        query.setUserId(user.getId());
        List<Order> orders = orderService.queryAll(query);
        long count = orders.stream().filter(Order::isSuccess).count();
        userInfo.setOrderCount(Integer.valueOf(String.valueOf(count)));
        return Response.ok(userInfo);
    }
}
