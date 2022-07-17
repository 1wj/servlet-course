package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OnewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //1.通过【请求对象】向tomcat索要当前网站的全局作用域对象
       ServletContext application=request.getServletContext();
       //2.将数据添加到全局作用域对象，作为共享数据
       application.setAttribute("key1",20);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
