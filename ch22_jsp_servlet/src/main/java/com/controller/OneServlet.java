package com.controller;

import com.bjpowenode.entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OneServlet extends HttpServlet {
    //处理业务，得到处理结果-----查询学员信息
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student stu=new Student("mike",20);
        Student stu1=new Student("allen",21);
        List<Student> list=new ArrayList<>();
        list.add(stu);
        list.add(stu1);
        //将处理结果添加到请求作用域对象
         request.setAttribute("key1",list);
         //通过请求转发方案，向tomcat申请调用uesr_show.jsp
        //同时将request与respone通过tomcat交给user_show,jsp
         request.getRequestDispatcher("/user_show.jsp").forward(request,response);
    }

}
