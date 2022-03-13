package com.test.Proxy;

import com.test.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class UserDaoProxy implements InvocationHandler {
    //1 把创建的是谁的代理对象，把谁传递过来
    //有参数构造传递
    private Object obj;

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    //增强逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //增强方法前
        String name = method.getName();
        String string = Arrays.toString(args);
        if ("add".equals(name)) {
            args[0] = 5;
            args[1] = 15;
        }

        //执行原有语句
        Object invoke = method.invoke(obj, args);

        //增强方法后
        System.out.println("增强完成");

        return invoke;
    }
}
