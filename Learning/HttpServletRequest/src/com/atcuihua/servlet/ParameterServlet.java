package com.atcuihua.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-------------------doGet----------------------");
        //获取请求参数
        String username = req.getParameter( "username");
        String password = req.getParameter( "password" );
        String[] hobby = req.getParameterValues( "hobby"); //获取请求的参数(多个值的时候使用)

        System.out.println("用户名 : " + username);
        System.out.println("密码 : " + password);
        System.out.println("兴趣爱好 : " + Arrays.asList(hobby));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求体的字符为UTF-8,从而解决中文乱码问题，要在获取参数之前使用才有效
        req.setCharacterEncoding("UTF-8");
        System.out.println("-------------------doPost----------------------");
        //获取请求参数
        String username = req.getParameter( "username");
        String password = req.getParameter( "password" );
        String[] hobby = req.getParameterValues( "hobby"); //获取请求的参数(多个值的时候使用)

        System.out.println("用户名 : " + username);
        System.out.println("密码 : " + password);
        System.out.println("兴趣爱好 : " + Arrays.asList(hobby));
    }
}
