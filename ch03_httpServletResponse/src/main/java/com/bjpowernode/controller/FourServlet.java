package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FourServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String i="http://www.baidu.com?usernama=jj";
        //通过响应对象，将地址赋给响应头中的location属性
        resp.sendRedirect(i);//[响应头 locati=“http://www.bai”]
    }
    /**
     * 浏览器在接收到响应包之后，如果
     * 发现响应头中存在location属性
     * 自动通过地址栏向  【locatin指定的】网站发送请求
     * sendRedirect方法远程控制浏览器请求行为【请求地址，请求方式，请求参数】
     * 浏览器的请求方式可以由前端控制，也可由服务端控制（通过设置响应头）
     */
}
