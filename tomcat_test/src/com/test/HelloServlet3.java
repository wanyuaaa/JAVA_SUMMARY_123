package com.test; /**
 * @author wanyu
 * @createTime 2022-03-06 15:52
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class HelloServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("a","1");
        servletContext.setAttribute("b","2");
        servletContext.setAttribute("c","3");

        System.out.println(servletContext.getAttribute("a"));
        System.out.println(servletContext.getAttribute("b"));
        System.out.println(servletContext.getAttribute("c"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletConfig().getServletContext();

        String username = servletContext.getInitParameter("username");
        String password = servletContext.getInitParameter("password");
        //1.获取web.xml中的公共参数
        System.out.println("servletContext获取到的公共参数："+username+"/"+password);
        //2.获取当前工程路径
        System.out.println(servletContext.getContextPath());
        //3.获取工程服务器硬盘上的绝对路径
        System.out.println(servletContext.getRealPath("/"));
        System.out.println(servletContext.getRealPath("/css"));
    }
}
