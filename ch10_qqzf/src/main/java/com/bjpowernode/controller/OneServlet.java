package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
//方案二：请求转发方案
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("oneservlet run...");
        //1.通过当前【请求对象】生成 【资源文件申请报告】 对象
        RequestDispatcher rd=request.getRequestDispatcher("/two");//一定要以"/"开头
        //2.将【资源文件报告对象】 发送给tomcat
        rd.forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
