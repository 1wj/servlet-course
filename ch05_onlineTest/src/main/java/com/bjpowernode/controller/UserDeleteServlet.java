package com.bjpowernode.controller;

import com.bjpowernode.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao=new UserDao();
        //1.调用【请求对象】读取【请求头】参数值(用户编号)
        String userId = request.getParameter("userId");//这个userIiid时浏览器传过来的随意写只要与链接中的一致就行了
        //2.调用【dao对象】删除用户
        int result = dao.delete(userId);
        //3、调用【响应对象】把结果返回给浏览器
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        if (result==1){
            out.print("<font sytle='color:red;size:30px'>用户删除成功</font>");
        }else{
            out.print("<font sytle='color:red;size:30px'>用户删除失败</font>");
        }

    }


}
