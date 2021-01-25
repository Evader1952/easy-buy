package com.ebuy.controller;

import com.ebuy.model.RequestContext;
import com.ebuy.model.Response;
import com.ebuy.pojo.User;
import com.ebuy.pojo.UserAddress;
import com.ebuy.service.UserAddressService;
import com.ebuy.utils.DataUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

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
     * 查默认收货地址
     * @param
     * @return
     */
    @GetMapping("getDefault")
    public Response<UserAddress> getDefault() {
        RequestContext.RequestUser user = RequestContext.getCurrentUser();
        if (DataUtil.isEmpty(user)){
            return Response.fail("请登录");
        }
        return Response.ok( userAddressService.queryDefaultAddress(user.getId()));
    }

    /**
     * 所有收货地址
     * @return
     */
    @GetMapping("getAll")
    public Response<List<UserAddress>> getAll() {
        List<UserAddress> userAddresses = userAddressService.queryList(null);
        return Response.ok(userAddresses);
    }
}