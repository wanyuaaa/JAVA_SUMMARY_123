package com.test; /**
 * @author wanyu
 * @createTime 2022-03-06 21:09
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //重定向
        //请求重定向的第一种方案：
        //设置响应状态码 302 ，表示重定向，（已搬迁）
        resp.setStatus(302);
        //设置响应头，说明 新的地址在哪里
        resp.setHeader("Location", "http://localhost:8080");
        //请求重定向的第二种方案（推荐使用）：
        resp.sendRedirect("http://localhost:8080");

        System.out.println("----------------------------------------------------------");

        // 获取请求的参数（办事的材料）查看
        String username = req.getParameter("username");
        System.out.println("在 Servlet1（柜台 1）中查看参数（材料）：" + username);
        // 给材料 盖一个章，并传递到 Servlet2（柜台 2）去查看
        req.setAttribute("key1","柜台 1 的章");
/**
 * 请求转发必须要以斜杠打头，/ 斜杠表示地址为：http://ip:port/工程名/ , 映射到 IDEA 代码的 web 目录
 <br/>
 *
 */
        // 问路：Servlet2（柜台 2）怎么走
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");
        // RequestDispatcher requestDispatcher = req.getRequestDispatcher("http://www.baidu.com");
        // 走向 Sevlet2（柜台 2）
        requestDispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
