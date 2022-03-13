package com.test.service;

import org.springframework.stereotype.Service;

/**
 * @author wanyu
 * @createTime 2022-03-13 14:15
 */
@Service(value = "userService")
public class UserService {

    public void say(){
        System.out.println("service");
    }

}
