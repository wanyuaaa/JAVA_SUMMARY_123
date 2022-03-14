package com.springMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wanyu
 * @createTime 2022-03-14 20:07
 */
@Controller
public class HelloController {

    @RequestMapping(value = "hello")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "target")
    public String target() {
        return "target";
    }
}
