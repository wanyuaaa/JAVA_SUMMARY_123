package com.test.junit;

import com.test.pojo.User;
import com.test.service.UserService;
import com.test.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wanyu
 * @createTime 2022-03-07 13:50
 */
public class UserServiceImplTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"admin1","123456","123@163.com"));
        userService.registerUser(new User(null,"admin2","123456","123@163.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"wanYu","root",null)));
        System.out.println(userService.login(new User(null,"wanYu","admin123",null)));
    }

    @Test
    public void existsUsername() {
        System.out.println(userService.existsUsername("wanYu"));
        System.out.println(userService.existsUsername("admin123"));
    }
}