package com.test.spring.demo;

import com.test.spring.config.SpringConfig;
import com.test.spring.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanyu
 * @createTime 2022-03-13 17:43
 */
public class demoTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        //Book abc = new Book(13, "abc", "123", "123@163.com");
        //bookService.add(abc);
        //bookService.findBookInfo(13);
        //bookService.findAllBook();

        //批量添加测试
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {14, "3", "java", "a"};
        Object[] o2 = {15, "4", "c++", "b"};
        Object[] o3 = {16, "5", "MySQL", "c"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        //调用批量添加
        bookService.batchAdd(batchArgs);
    }

    @Test
    public void test2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.accountMoney();
    }
}
