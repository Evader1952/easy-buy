package com.ebuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jump")
public class Jump {

    @RequestMapping("/goIndex")
    public String goIndex(){
        return "index";
    }

    @RequestMapping("/goCartList")
    public String goCartList(){
        return "cartList";
    }
}
