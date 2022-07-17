package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用请求对象，读取请求头参数，得到用户选择商品名
        String goodsName = request.getParameter("goodsName");
        //2.调用请求对象，向tomcat索要当前用户在服务端的私人储物柜(httpSession)
        HttpSession session= request.getSession();
        //3.将用户选购商品添加到当前用户私人储物柜
        Integer nums = (Integer) session.getAttribute(goodsName);
        if (nums==null){
            session.setAttribute(goodsName,1);
        }else {
            session.setAttribute(goodsName,nums+1);
        }

    }


}
