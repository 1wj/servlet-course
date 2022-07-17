package com.bjpowernode.controller;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            UserDao dao =new UserDao();
            //1.调用[dao]将查询命令推送到数据库服务器上，的到所有的用户信息【List】
            List<Users> userslist = dao.find();

            //2.调用[响应对象]将用户信息结合<table>标签命令以二进制形式写入到响应体中
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.print("<table border='2px' align='center'>");
            out.print("<tr>");
            out.print("<td>用户id</td>");
            out.print("<td>用户姓名</td>");
            out.print("<td>用户密码</td>");
            out.print("<td>用户性别</td>");
            out.print("<td>用户邮箱</td>");
            out.print("<td>操作</td>");
            out.print("</tr>");
            for(Users user:userslist){
                out.print("<tr>");
                out.print("<td>"+user.getUserId()+"</td>");
                out.print("<td>"+user.getUserName()+"</td>");
                out.print("<td>"+user.getPassword()+"</td>");
                out.print("<td>"+user.getSex()+"</td>");
                out.print("<td>"+user.getEmail()+"</td>");
                out.print("<td><a href='/ch05_onlineTest_war_exploded/user/delete?userId="+user.getUserId()+"'>删除用户</a></td>");
                out.print("</tr>");
            }
            out.print("</table>");


    }
}
