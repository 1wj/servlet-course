package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OnewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过【请求对象】，获取【请求行】中【url】信息
        String requestURL= request.getRequestURL().toString();//注意URL与URI区别
        String requestURI = request.getRequestURI();
      /*
            URI:资源文件精准定位地址，在请求行里并没有这个属性
            实际上是URL中截取的一个字符串，这个字符串格式“/网站名/资源文件名/”
            URI用于让http服务器（tomcat）对被访问的资源文件进行定位
       */
        //通过【请求对象】，获取【请求行】中【method】信息
        String method = request.getMethod();
        System.out.println("url==="+requestURL);
        System.out.println("uri==="+requestURI);
        System.out.println("method==="+method);
    }


}
