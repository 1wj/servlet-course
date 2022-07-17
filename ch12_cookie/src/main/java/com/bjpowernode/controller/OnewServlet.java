package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OnewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用请求对象读取请求头参数信息
        String userName = request.getParameter("userName");
        String userMoney = request.getParameter("userMoney");
        //2.开卡
        Cookie card=new Cookie("key1",userName);//key1
        Cookie card2=new Cookie("key2",userMoney);//key2
        //3.指定card2在客户端硬盘上存活1分钟
        card2.setMaxAge(60);
       //4.发卡 将cookie写入到响应头中交给浏览器
        response.addCookie(card);
        response.addCookie(card2);
        //5.资源申请报告（通知浏览器将 点餐页面 写入到响应体中交个浏览器）
        RequestDispatcher application=request.getRequestDispatcher("/index_2.html");//这个不需要写全
        application.forward(request,response);

    }


}
