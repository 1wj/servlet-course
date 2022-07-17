package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 问题描述：java<br>mysql<br>c#
 *          浏览器在接收到响应结果时将<br/>作为
 *          文字内容在窗口展示出来，没有将<br/>
 *          当做html标签命令来执行
 *  原因：浏览器在接收到响应包之后，根据【响应头中Content-type】
 *     属性的值，采用对应【编译器】对【响应体中二进制内容】进行编译处理
 *     在默认情况下，content-type属性的值是“text” context-type=“text”
 *    此时浏览器会采用【文本编译器】对响应体二进制数据进行解析
 *    解决方法： 一定要在得到输出流之前，通过响应对象对响应头中context-type属性进行
 *    一次重新赋值用于指定浏览器采用正确编译器
 */
public class ThreeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String i="java<br>mysql<br>c#";
        String i2="<br>红烧肉<br>鱼香肉丝<br>水饺";
        //设置响应头context-text   切记：如果内容有中文还要注意字符集
        response.setContentType("text/html;charset=utf-8");
        //向tomcat索要输出流
        PrintWriter out=response.getWriter();
        //通过输出流将结果写入到响应体中
        out.print(i);
        out.print(i2);
    }


}
