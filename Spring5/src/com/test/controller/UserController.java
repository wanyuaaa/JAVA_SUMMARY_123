package com.test.controller;

import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author wanyu
 * @createTime 2022-03-13 13:58
 */
//名称可以不写，默认值是类名称，首字母小写
@Component(value = "userController")//<bean id="controller" class="..."/>
public class UserController {

    //@Autowired
    //@Qualifier：根据名称进行注入,这个@Qualifier 注解的使用，和上面@Autowired 一起使用
    //@Qualifier(value = "userService")
    //@Resource：可以根据类型注入，可以根据名称注入，不推荐javax
    @Resource(name = "userService")
    private UserService userService;

    //@Value：注入普通类型属性
    @Value(value = "abc")
    private String name;

    public void user(){
        System.out.println("controller");
        System.out.println(name);
        userService.say();
    }
}
