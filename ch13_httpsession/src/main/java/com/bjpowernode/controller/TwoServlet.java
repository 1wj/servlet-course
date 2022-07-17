package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用请求对象，向tomcat索要当前用户在服务器的私人储物柜
        HttpSession session=request.getSession();
        /**
         *         tomcat在创建一个HttpSession对象时自动为这个HttpSession对象生成一个唯一的编号
         *         tomcat将编号保存到Cookie对象，推送到当前流浪器缓存 Cookie：JSESSION=编号
         *         等到用户第二次来访时，tomcat根据请求头JSESSION确认用户是否有HttpSession一个哪一个HttpSession是当前用户
         */

        Enumeration goodNames = session.getAttributeNames();
        while (goodNames.hasMoreElements()){
            String goodName = (String) goodNames.nextElement();
            int  goodNum = (int) session.getAttribute(goodName);
            System.out.println("商品名称"+goodName+",商品数量"+goodNum);
        }
    }


}
