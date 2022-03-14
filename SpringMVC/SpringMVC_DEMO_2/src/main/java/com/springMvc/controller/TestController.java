package com.springMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wanyu
 * @createTime 2022-03-14 21:29
 *
 * 处理get请求的映射-->@GetMapping
 * 处理post请求的映射-->@PostMapping
 * 处理put请求的映射-->@PutMapping
 * 处理delete请求的映射-->@DeleteMapping
 *
 * 原始方式：/deleteUser?id=1
 * rest方式：/deleteUser/1
 *
 */
@Controller
@RequestMapping(value = "pages")
public class TestController {

    @RequestMapping(value = "index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "target")
    public String target(){
        return "target";
    }

    @RequestMapping("/testRest/{id}/{username}")
    public String testRest(@PathVariable("id") String id, @PathVariable("username")
            String username){
        System.out.println("id:"+id+",username:"+username);
        return "target";
    }

}
