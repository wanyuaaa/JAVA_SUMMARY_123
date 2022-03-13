package com.test.Proxy;

import com.test.config.SpringConfig;
import com.test.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wanyu
 * @createTime 2022-03-13 15:16
 */
public class JDKProxy {

    @Test
    public void test() throws InstantiationException, IllegalAccessException {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.run2();
    }
}