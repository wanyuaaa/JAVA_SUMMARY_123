package com.springMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wanyu
 * @createTime 2022-03-16 10:39
 */
@Controller
public class pages {
    @RequestMapping(value = "/**/testInterceptor")
    public String index(){
        return "success";
    }

    @RequestMapping(value = "/testExceptionHandle")
    public String error(){
        System.out.println(10/0);
        return "success";
    }
}
