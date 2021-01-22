package com.ebuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jump")
public class JumpController {

    @RequestMapping("/goIndex")
    public String goIndex(){
        return "index";
    }

    @RequestMapping("/goCartList")
    public String goCartList(){
        return "cartList";
    }

    @RequestMapping("Member")
    public String goMember(){
        return "Member";
    }


    @RequestMapping("/goCartListTwo")
    public String goCartListTwo(){
        return "cartList_two";
    }

    @RequestMapping("/goCartListThree")
    public String goCartListThree(){
        return "cartList_three";
    }
}
