package com.atcuihua.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1、获取 web.xml中配置的上下文参数context-param
        ServletContext context = getServletConfig().getServletContext();
        String username = context.getInitParameter("userneme");
        System.out.println("context-param username: " + username);
        System.out.println("context-param password: " + context.getInitParameter("password"));
//        2、获取当前的工程路径，格式:/工程路径
        System.out.println("当前工程路径：" + context.getContextPath());
//        3、获取工程部署后在服务器硬盘上的绝对路径
//        斜杠被服务器解析地址为: http://ip : port/工程名/
        System.out.println("工程部署后在服务器硬盘上的绝对路径:" + context.getRealPath("/"));
//        4、像 Map一样存取数据

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
