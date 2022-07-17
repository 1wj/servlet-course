package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ThreeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //通过请求参数对象获取【请求头】信息
        String valueget = request.getParameter("useget");
        System.out.println("从请求头获取请求参数值 "+valueget);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通知请求对象，使用utf-8字符集对请求体内容进行一次重新解码
        request.setCharacterEncoding("utf-8");
        //通过请求参数对象,读取【请求体】信息
        String valueget2 = request.getParameter("usepost");
        System.out.println("从请求体获取请求参数值 "+valueget2);//null?为什么

    }
    /*
        问题：以GET方式发送中文参数内容“你好”时，得到正常结果
             以POST方式发送中文参数内容“你好”时，得到乱码
        原因： 浏览器以GET方式发送请求，请求参数保存在【请求头】，在http请求协议包到达http服务器之后，第一件事就是进行解码
              请求头二进制内容由tomcat负责解码，tomcat9.0默认使用【utf-8】字符集，可以解释一切国家文字

              浏览器以POST方式发送请求，请求参数保存在【请求体】，在http请求协议包到达http服务器之后，第一件事就是进行解码
              请求体二进制内容由request负责解码，request默认使用【ISO-8859-1】字符集，一个东欧语系字符集
              此时如果请求体参数内容时中文，将无法解码只能得到乱码
        解决方案：
         在post请求下，在读取请求体内容之前，应该通知【请求对象】使用utf-8字符集对请求内容进行一次重新解码

     */
}
