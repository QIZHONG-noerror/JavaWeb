package com.atcuihua.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Response11111111");
        req.setAttribute("key1","value1");
        //方案1
        //设置响应状态码302，表示重定向,(已搬迁)
        //resp.setStatus(302);
        //设置响应头，说明新的地址在哪里I
        //resp.setHeader("Location","http://localhost:8088/HttpServletRequest_war_exploded/response2");
        //方案2（推荐）
        resp.sendRedirect("http://localhost:8088");
    }
}
