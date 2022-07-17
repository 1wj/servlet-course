package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class twoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int i=97;
        PrintWriter out=response.getWriter();
       // out.write(i);
        /**
         * 问题描述：浏览器接收到的数据时a,不是97
         *   主要是因为：out.write方法可以将【字符】【字符串】【ascll】写入到响应体中
         *   ascll：   a------------>97
         *   所以换个方法print,println都行 ，之前的write就当做不存在
         */
        out.print(i);
    }


}
