package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class TwoServlet extends HttpServlet {
    public TwoServlet() {
        System.out.println("shiyongl fangfa");
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过请求对象获得【请求头】中【所有请求参数名】
        Enumeration paramNames = req.getParameterNames();//将所有请求参数名称报存到一个枚举对象进行返回
        while (paramNames.hasMoreElements()){
            String o = (String) paramNames.nextElement();
            //通过请求参数对象读取指定的请求参数的值
            String value = req.getParameter(o);
            System.out.println("请求参数名 "+o+"参数的值"+value);
        }
    }
}
