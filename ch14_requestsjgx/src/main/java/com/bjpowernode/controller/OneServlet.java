package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
//requeset实现数据共享（在请求转发的条件下）
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.将数据添加到请求作用域对象，作为共享数据
        request.setAttribute("key1","hello world");
        //2.代替浏览器，向tomcat索要twoservlet来完成剩余任务
        RequestDispatcher application=request.getRequestDispatcher("/two");
        application.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
