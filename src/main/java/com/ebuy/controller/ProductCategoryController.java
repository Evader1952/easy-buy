package com.ebuy.controller;

import com.ebuy.pojo.EasybuyProduct;
import com.ebuy.pojo.EasybuyProductCategory;
import com.ebuy.service.CategoryService;
import com.ebuy.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/index")
public class ProductCategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    /**
     * 初始化数据
     * @return
     */
    @RequestMapping("/initData")
    public String initData(Model model, HttpSession session){
        //初始化类别信息
        List<EasybuyProductCategory> categoryList = categoryService.getCategories();
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
    public String getProductById(Integer pid,
                                 @RequestParam(value = "pageNow",defaultValue = "1")Integer pageNow ,
                                 Model model){
        PageHelper.startPage(pageNow,20);
        List<EasybuyProduct> products = productService.getProducts(pid);
        PageInfo<EasybuyProduct> pageInfo = new PageInfo<>(products);
        model.addAttribute("pageInfo",pageInfo);
        return "productList";
    }

    /**
     * 根据商品编号查询
     * @return
     */
    @RequestMapping("/getByPid")
    public String getByPid(Integer pid,Model model){
        EasybuyProduct product = productService.getById(pid);
        model.addAttribute("product",product);
        return "product";
    }



}
