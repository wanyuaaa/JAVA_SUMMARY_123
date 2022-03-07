package com.test; /**
 * @author wanyu
 * @createTime 2022-03-06 20:22
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class HelloServlet4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // i.getRequestURI() 获取请求的资源路径
        System.out.println("URI => " + req.getRequestURI());
        // ii.getRequestURL() 获取请求的统一资源定位符（绝对路径）
        System.out.println("URL => " + req.getRequestURL());
/**
 * 在 IDEA 中，使用 localhost 访问时，得到的客户端 ip 地址是 ===>>> 127.0.0.1<br/>
 * 在 IDEA 中，使用 127.0.0.1 访问时，得到的客户端 ip 地址是 ===>>> 127.0.0.1<br/>
 * 在 IDEA 中，使用 真实 ip 访问时，得到的客户端 ip 地址是 ===>>> 真实的客户端 ip 地址<br/>
 */
        // iii.getRemoteHost() 获取客户端的 ip 地址
        System.out.println("客户端 ip 地址 => " + req.getRemoteHost());
        // iv.getHeader() 获取请求头
        System.out.println("请求头 User-Agent ==>> " + req.getHeader("User-Agent"));
        // vii.getMethod() 获取请求的方式 GET 或 POST
        System.out.println( "请求的方式 ==>> " + req.getMethod() );

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get请求的中文乱码解决：
        //获取请求参数
        //String username = req.getParameter("username");
        //1 先以 iso8859-1 进行编码
        //2 再以 utf-8 进行解码
        // username = new String(username.getBytes("iso-8859-1"), "UTF-8");

        //POST 请求的中文乱码解决
        req.setCharacterEncoding("UTF-8");
        // 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby");
        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        System.out.println("兴趣爱好：" + Arrays.asList(hobby));

        // 设置服务器字符集为 UTF-8
        //resp.setCharacterEncoding("UTF-8");
        // 通过响应头，设置浏览器也使用 UTF-8 字符集
        //resp.setHeader("Content-Type", "text/html; charset=UTF-8");

        // 它会同时设置服务器和客户端都使用 UTF-8 字符集，还设置了响应头
        // 此方法一定要在获取流对象之前调用才有效
        resp.setContentType("text/html; charset=UTF-8");

        // 要求 ： 往客户端回传 字符串 数据。
        PrintWriter writer = resp.getWriter();
        writer.write("response's content!!!");
    }
}
