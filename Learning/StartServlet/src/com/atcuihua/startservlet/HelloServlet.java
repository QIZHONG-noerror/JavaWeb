package com.atcuihua.startservlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet{
    public HelloServlet() {
        System.out.println("执行Servlet构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
//        1、可以获取Servlet程序的别名servlet-name的值
        System.out.println("HelloServlet程序的别名：" + servletConfig.getServletName());
//        2、获取初冶化参数init-param
        System.out.println("初始化参数username：" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url：" + servletConfig.getInitParameter("url"));
//        3、获取servletContext对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    /*
        service方法，处理请求，并响应数据
        */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //类型转换 HttpServletRequest下有getMethod
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //获取请求的方式
        String method = httpServletRequest.getMethod();
        System.out.println(method);
        if("GET".equals(method)){
            doGet();
        }else if("POST".equals(method)){
            doPost();
        }
    }
    /*
    做get request的操作
    */
    public void doGet(){
        System.out.println("get request");
    }
    /*
    做post request的操作
    */
    public void doPost(){
        System.out.println("post request");
    }

    @Override
    public String getServletInfo() {
        return null;
    }
    @Override
    public void destroy() {

    }
}
