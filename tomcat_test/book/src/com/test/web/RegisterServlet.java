package com.test.web;

import com.test.pojo.User;
import com.test.service.UserService;
import com.test.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wanyu
 * @createTime 2022-03-07 14:01
 */
public class RegisterServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2.检查 验证码是否正确==写死,要求验证码为:abc
        if ("abc".equals(code)) {
            // 3、检查 用户名是否可用
            if (userService.existsUsername(username)) {
                System.out.println("用户名[" + username + "]已存在!");
                // 跳回注册页面
                req.getRequestDispatcher("/pages/user/register.html").forward(req, resp);
            } else {
                // 可用
                // 调用 Service 保存到数据库
                userService.registerUser(new User(null, username, password, email));
                // 跳到注册成功页面 register_success.html
                req.getRequestDispatcher("/pages/user/register_success.html").forward(req, resp);
            }
        } else {
            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/register.html").forward(req, resp);
        }
    }
}
