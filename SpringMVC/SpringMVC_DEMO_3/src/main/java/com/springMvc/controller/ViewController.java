package com.springMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wanyu
 * @createTime 2022-03-15 14:05
 */
@Controller
public class ViewController {
    @RequestMapping("/tesThymeleafView")
    public String tesThymeleafView(){
        return "success";
    }
}
