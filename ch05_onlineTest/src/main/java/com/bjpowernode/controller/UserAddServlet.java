package com.bjpowernode.controller;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class UserAddServlet extends HttpServlet {
    /**
     *  1.调用【请求对象】读取【请求头】参数信息，得到用户的信息
     *  2.调用【UserDao】将用户信息填充到insert命令借助jdbc规范发送到数据库服务器
     *  3.调用【响应对象】将【处理结果】以二进制形式写入到响应体
     *  tomcat负责销毁【请求对象】和【响应对象】
     *  tomcat负责将http响应包推送到发起请求的浏览器上
     *  浏览器根据响应头content-type指定编译器对响应体二进制内容编辑
     *  浏览器将编译后得结果在窗口中展示个用户【结束】
     *
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username,password,sex,email;
        UserDao dao=new UserDao();
       // 1.调用【请求对象】读取【请求头】参数信息，得到用户的信息
        username=request.getParameter("username");
        password=request.getParameter("userpasswd");
        sex=request.getParameter("sex");
        email=request.getParameter("email");
       //2.调用【UserDao】将用户信息填充到insert命令借助jdbc规范发送到数据库服务器
        Users user=new Users(null,username,password,sex,email);
        Date startDate=new Date();
       // int resutl = dao.add(user);
        int resutl = dao.add(user,request);
        Date endDate=new Date();
        System.out.println("创建时间"+(endDate.getTime()-startDate.getTime())+"毫秒");
        //3.调用【响应对象】将【处理结果】以二进制形式写入到响应体
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if(resutl==1){
            out.print("<font style='color:red;font-size:40px'>用户信息注册成功</font>");
        }else{
            out.print("<font style='color:red;font-size:40px'>用户信息注册失败</font>");
        }


    }


}
