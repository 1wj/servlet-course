package com.bjpowernode;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
//方案一：重定向解决方案
public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("twoservlet炒韭菜");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
