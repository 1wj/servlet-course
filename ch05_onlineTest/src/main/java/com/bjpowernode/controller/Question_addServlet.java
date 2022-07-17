package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.entity.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Question_addServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        QuestionDao dao=new QuestionDao();
        String title =request.getParameter("title");
        String optionA =request.getParameter("optionA");
        String optionB=request.getParameter("optionB");
        String optionC=request.getParameter("optionC");
        String optionD=request.getParameter("optionD");
        String answer=request.getParameter("answer");
        Question question=new Question(title,optionA,optionB,optionC,optionD,answer);
        int result = dao.add(question);
        if(result==1){
            request.setAttribute("key1","成功添加");

        }else {
            request.setAttribute("key1","添加失败");

        }
        request.getRequestDispatcher("/s.jsp").forward(request,response);
    }


}
