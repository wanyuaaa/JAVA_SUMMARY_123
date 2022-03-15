package com.springMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wanyu
 * @createTime 2022-03-15 10:39
 */
@Controller
public class PageController {
//    @RequestMapping(value = "index")
//    public String index(){
//        return "index";
//    }

    @RequestMapping(value = "view")
    public String view(){
        return "view";
    }

    //转发
    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/view";
    }

    //重定向
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/view";
    }


}
