package com.bjpowernode.controller;

import com.bjpowernode.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,password;
        UserDao dao=new UserDao();
        //1.【请求对象】对【请求体】使用utf-8字符进行重新编辑
         request.setCharacterEncoding("utf-8");
        //2.【请求对象】读取【请求头】参数信息
         userName = request.getParameter("userName");
         password=request.getParameter("userpasswd");
        //3.调用【dao】将查询验证信息推送到数据库服务器上
        int result = dao.login(userName, password);
        //4.【响应对象】根据验证结果将不同资源我呢见写入到响应头，交给浏览器
        if(result==1){
            //在判断来访用户身份合法后，通过请求对象向tomcat为当前用户申请一个HttpSession
             HttpSession session=request.getSession();
            response.sendRedirect("/ch05_onlineTest_war_exploded/index.html");
        }else{
            response.sendRedirect("/ch05_onlineTest_war_exploded/login_error.html");
        }

    }
}
