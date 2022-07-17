package com.bjpowernode;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
//方案一：重定向解决方案
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/ch09_cdx_war_exploded/two");
        System.out.println("oneservlet洗韭菜");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
