package com.atcuihua.startservlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//一般在交际项目开发中，都是使用继承 HttpServiet类的方式去实现serviet程序。|
//        ①编写一个类去继承HttpServlet类
//        ②根据业务需要重写doGet或doPost方法
//        ③到web.xml 中的配 servlet程序的访问地址可

public class HelloServlet2 extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        //一定要继承原来的init，父类有保存操作
        super.init(config);
        System.out.println("HelloServlet2_rewrite_init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2_doGet");
        //每个servletconfig得到的信息相互独立
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig);
        //2、获取初冶化参数init-param
        System.out.println("初始化参数username：" + servletConfig.getInitParameter("username2"));
        System.out.println("初始化参数url：" + servletConfig.getInitParameter("url2"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2_doPost");
    }
}
