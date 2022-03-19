package com.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanyu
 * @createTime 2022-03-19 22:54
 */
@RestController
public class HelloBoot {
    @RequestMapping("/hello")
    @ResponseBody
    public String handle01(){
        return "Hello, Spring Boot 2!";
    }
}
