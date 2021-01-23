package com.ebuy.controller;

import com.ebuy.model.web.TbItem;
import com.ebuy.pojo.Product;
import com.ebuy.pojo.User;
import com.ebuy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductService productService;

    /**
     * 加入购物车
     *
     * @param pid
     * @param session
     * @return
     */
    @RequestMapping("/addCart")
    @ResponseBody
    public Map<String, Object> addCart(Integer pid, HttpSession session) {
        //将选中的商品加入购物车中
        //标识符:判断是否存在此商品
        boolean flag = false;
        //通过id查询商品信息
        Product product = productService.queryById(pid);
        //从session中获取购物车信息
        List<TbItem> shopcart = (List<TbItem>) session.getAttribute("shopcart");
        //获取用户信息
        User user = (User) session.getAttribute("user");
        if (user == null) {
            //如果用户为空,则直接返回,让用户登录
            throw new RuntimeException("用户未登录");
        }
        //判断购物车列表是否为空
        if (shopcart == null) {
            //new 一个集合
            shopcart = new ArrayList<>();
        } else {
            for (TbItem item : shopcart) {
                //判断是否存在此商品,存在则数量+1
                //System.out.println(item.getProductId()+"-"+product.getId());
                if (item.getProductId().equals(product.getId())) {
                    flag = true;
                    item.setCount(item.getCount() + 1);
                    item.setPrice(product.getPrice() * item.getCount());
                }
            }
        }
        //如果购物车中没有当前商品的信息,则新增商品

        if (!flag) {
            TbItem item = new TbItem();
            item.setName(product.getName());
            item.setProductId(product.getId());
            item.setFileName(product.getFileName());
            item.setCount(1);
            item.setPrice(product.getPrice());
            //把商品加入集合
            shopcart.add(item);
        }
        //计算总价格
//        float total = 0f;
//        int count = 0;
//        for (TbItem item : shopcart) {
//            count += item.getCount();
//            total += item.getPrice();
//        }
//        for (TbItem order : shopcart) {
//            order.setTotal(total);
//        }
        Float total = shopcart.stream().map(TbItem::getPrice).reduce(0.00f,(s1, s2) -> s1 = s1 + s2);
        Integer count = shopcart.stream().map(TbItem::getCount).reduce(0, Integer::sum);
        //设置session
        session.setAttribute("total", total);
        session.setAttribute("shopcart", shopcart);
        session.setAttribute("cartNum", count);
        //返回list
        Map<String, Object> map=new HashMap<>();
        map.put("shopcart", shopcart);
        map.put("total", total);
        return map;
    }

    @RequestMapping("/delItem")
    public String delItem(Integer pid, HttpServletRequest request) {
        //删除商品
        List<TbItem> items = (List<TbItem>) request.getSession().getAttribute("shopcart");
        int index = 0;
        for (int i = 0; i < items.size(); i++) {
            if (pid.equals(items.get(i).getProductId())) {
                index = i;
            }
        }
        if (index!=0){
            items.remove(index);
        }
//        //计算总价格
//        float total = 0f;
//        int count = 0;
//        for (TbItem item : items) {
//            count += item.getCount();
//            total += item.getPrice();
//        }
//        for (TbItem order : items) {
//            order.setTotal(total);
//        }
        Float total = items.stream().map(TbItem::getPrice).reduce((s1, s2) -> s1 = s1 + s2).get();
        Integer count = items.stream().map(TbItem::getCount).reduce(0, Integer::sum);
        //设置session
        request.getSession().setAttribute("shopcart", items);
        request.getSession().setAttribute("cartNum", count);
        request.getSession().setAttribute("total", total);
        return "redirect:/jump/goCartList";
    }

    /**
     * 加或减 商品数量
     * @param pid
     * @param type
     * @param request
     * @return
     */
    @RequestMapping("addOrCutCart")
    public String cutCart(Integer pid,Integer type, HttpServletRequest request) {
        Product product = productService.queryById(pid);
        List<TbItem> shopcart = (List<TbItem>) request.getSession().getAttribute("shopcart");
        int index = 0;
        for (int i = 0; i < shopcart.size(); i++) {
            if (shopcart.get(i).getProductId().equals(product.getId())) {
                if (type.equals(1)){
                    if (shopcart.get(i).getCount()==1){
                        index=i;
                        continue;
                    }
                    shopcart.get(i).setCount(shopcart.get(i).getCount() - 1);
                    shopcart.get(i).setPrice(shopcart.get(i).getPrice() - product.getPrice());
                }else {
                    shopcart.get(i).setCount(shopcart.get(i).getCount() +1);
                    shopcart.get(i).setPrice(shopcart.get(i).getPrice() + product.getPrice());
                }
            }
        }
        if (index!=0){
            shopcart.remove(index);
        }
        Float total = shopcart.stream().map(TbItem::getPrice).reduce((s1, s2) -> s1 = s1 + s2).get();
        Integer count = shopcart.stream().map(TbItem::getCount).reduce(0, Integer::sum);
        request.getSession().setAttribute("total", total);
        request.getSession().setAttribute("shopcart", shopcart);
        request.getSession().setAttribute("cartNum", count);
        return "redirect:/jump/goCartList";
    }


}
