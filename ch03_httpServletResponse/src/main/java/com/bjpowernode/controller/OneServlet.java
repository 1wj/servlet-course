package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String ret="helo servlet";//执行结果
        //-------响应对象将结果写入到响应体----------start
       //1.通过响应对象 resp，向tomcat索要输出流
        PrintWriter out = resp.getWriter();
       //2.通过输出流，将执行结果以二进制形式写入到响应体
        out.write(ret);
        //-------响应对象将结果写入到响应体----------end
    }//doget执行完毕
    //tomcat将响应包推送给浏览器 浏览器从响应包响应体中拿到内容解析后就能展示出来了
}
