package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class Question_findServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao=new QuestionDao();
        List list = dao.find();
        request.setAttribute("key2",list);
        request.getRequestDispatcher("/questions.jsp").forward(request,response);
    }


}
