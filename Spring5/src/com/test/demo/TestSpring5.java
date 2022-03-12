package com.test.demo;

import com.test.spring5.Book;
import com.test.spring5.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wanyu
 * @createTime 2022-03-13 1:51
 */
public class TestSpring5 {

    @Test
    public void testAdd(){
        //1 加载 spring 配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2 获取配置创建的对象
        Book book = context.getBean("book", Book.class);

        System.out.println(book.getBookName());
    }
}
