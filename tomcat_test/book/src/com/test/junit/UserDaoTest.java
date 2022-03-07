package com.test.junit;

import com.test.dao.UserDao;
import com.test.dao.impl.UserDaoImpl;
import com.test.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wanyu
 * @createTime 2022-03-07 2:35
 */
public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("admin1234") == null ){
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }
    @Test
    public void queryUserByUsernameAndPassword() {
        if ( userDao.queryUserByUsernameAndPassword("admin","admin123") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("查询成功");
        }
    }
    @Test
    public void saveUser() {
        System.out.println( userDao.saveUser(new User(null,"admin", "admin123", "admin123@163.com")) );
    }
}