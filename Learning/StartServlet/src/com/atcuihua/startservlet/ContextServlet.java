package com.atcuihua.startservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1、获取 web.xml中配置的上下文参数context-param,但是不能得到servlet的init-param
        ServletContext context = getServletConfig().getServletContext();
        String username = context.getInitParameter("username");
        System.out.println("context-param_username:" + username);
        System.out.println("context-param_password:" + context.getInitParameter("password"));
//2、获取当前的工程路径，格式:/工程路径
        System.out.println("当前的工程路径:" + context.getContextPath());
//3、获取工程部署后在服务器硬盘上的绝对路径
        // /  斜杠在服务器解析的时候，表示地址为:http://ip:port/工程路径 映射到IDEA的代码目录
        System.out.println("部署后在服务器硬盘上的绝对路径:" + context.getRealPath("/"));
        System.out.println("部署后css的绝对路径:" + context.getRealPath("/css"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
