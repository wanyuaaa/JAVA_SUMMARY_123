package com.test.demo;

import com.test.config.SpringConfig;
import com.test.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wanyu
 * @createTime 2022-03-13 1:51
 */
public class TestSpring5 {

    @Test
    public void testAdd(){
        //1 加载 spring 配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean@.xml");
        //2 获取配置创建的对象
        UserController userController = context.getBean("userController", UserController.class);
        userController.user();
    }

    @Test
    public void testAllAnno(){
        //完全注解开发
        //1 加载 spring 配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        //2 获取配置创建的对象
        UserController userController = context.getBean("userController", UserController.class);
        userController.user();
    }
}
