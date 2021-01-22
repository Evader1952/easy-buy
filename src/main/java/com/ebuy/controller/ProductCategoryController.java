package com.ebuy.controller;

import com.ebuy.model.query.ProductQuery;
import com.ebuy.pojo.Product;
import com.ebuy.pojo.ProductCategory;
import com.ebuy.service.ProductCategoryService;
import com.ebuy.service.ProductService;
import com.ebuy.utils.DataUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.DUP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/index")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductService productService;

    /**
     * 初始化数据
     * @return
     */
    @RequestMapping("/initData")
    public String initData(Model model, HttpSession session){
        //初始化类别信息
        List<ProductCategory> categoryList = productCategoryService.getCategories();
        session.setAttribute("categoryList",categoryList);
        return "index";
    }

    /**
     * 查询分类商品列表
     * @param pid
     * @param model
     * @return
     */
    @RequestMapping("/getProductById")
    public String getProductById(Integer pid,Integer sortType,Integer orderByType,@RequestParam(value = "pageNow",defaultValue = "1")Integer pageNow ,
                                 Model model){
        PageHelper.startPage(pageNow,20);
        ProductQuery query = new ProductQuery();
        query.setCategoryLevel1Id(pid);
        String sort= DataUtil.isEmpty(sortType)?null:sortType.equals(1)?"acs":sortType.equals(2)?"desc":null;
        query.setSort(sort);
        // 默认 销量 价格 新品
        String orderBy=DataUtil.isEmpty(orderByType)?null:orderByType.equals(1)?"xl":orderByType.equals(2)?"price":orderByType.equals(3)?"createTime":null;
        query.setOrderBy(orderBy);
        List<Product> products = productService.getProducts(query);
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        model.addAttribute("pageInfo",pageInfo);
        return "productList";
    }



    /**
     * 根据商品编号查询
     * @return
     */
    @RequestMapping("/getByPid")
    public String getByPid(Integer pid,Model model){
       Product product = productService.queryById(pid);
        model.addAttribute("product",product);
        return "product";
    }



}
