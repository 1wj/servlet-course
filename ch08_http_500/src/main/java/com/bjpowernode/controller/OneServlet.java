package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 500：通知浏览器，在服务段已经定位到被访问的资源文件（servlet）
 * 这个servlet也可以接收浏览器采用的请求方式，但是servlet在处理
 * 这个请求期间，由于Java异常导致处理失败
 *
 * 小窍门；404估计是文件写错了
 *       405 doget 或者dopost方法用错了或少了
 *       500 代码里面有异常
 *  浏览器一次只能访问一个资源文件（一个index.html或一个one...或一个servlet）
 */
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map map=new HashMap();
        //int num = (int) map.get("key1");//报个空指针异常
        Integer num= (Integer) map.get("key1");//所有高级类型都可以赋值给null，基本引用类型就不行
        System.out.println("报个空指针");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
