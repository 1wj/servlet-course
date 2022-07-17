package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.entity.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Question_findByidServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        QuestionDao dao=new QuestionDao();
        Question question=new Question();
        String questionId;
        //调用请求对象读取请求头参数信息，得到试题编号
        questionId=request.getParameter("questionId");
        //调用dao推送查询命令得到这个试题编号对应的参数信息
        question=dao.findId(questionId);
        //调用requestionFindByid.jsp将试题信息写入到响应体中
        request.setAttribute("key3",question);
        request.getRequestDispatcher("/question_update.jsp").forward(request,response);
    }


}
