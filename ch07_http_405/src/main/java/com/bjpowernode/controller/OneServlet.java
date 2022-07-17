package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

//只针对浏览器发送post请求方式进行处理，无法对get方式进行处理
public class OneServlet extends HttpServlet {

    //doget()方法的去掉 不然体现不出来效果

    /*
        405：通知浏览器，在服务段已经定位到被访问的资源文件（servlet）
        但是这个servlet对于浏览器采用的请求方式不能处理
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("405__dopost方法正在运行");
    }
}
