package com.test.service.impl;

import com.test.Proxy.JDKProxy;
import com.test.Proxy.UserDaoProxy;
import com.test.dao.UserDao;
import com.test.dao.impl.UserDaoImpl;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Proxy;

/**
 * @author wanyu
 * @createTime 2022-03-13 15:07
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void run() {
        Class[] interfaces = {UserDao.class};
        UserDao o = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int add = o.add(1, 3);
        System.out.println(add);
    }

    @Override
    public void run2() {
        int add = userDao.add(1, 3);
        System.out.println(add);
    }
}
