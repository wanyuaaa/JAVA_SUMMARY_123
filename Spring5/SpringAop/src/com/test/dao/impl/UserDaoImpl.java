package com.test.dao.impl;

import com.test.dao.UserDao;
import org.springframework.stereotype.Component;

/**
 * @author wanyu
 * @createTime 2022-03-13 15:05
 */
@Component
public class UserDaoImpl implements UserDao {
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public String update(String id) {
        return id;
    }
}
