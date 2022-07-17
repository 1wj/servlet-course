package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.entity.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Question_updateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao=new QuestionDao();
        String title =request.getParameter("title");
        String optionA =request.getParameter("optionA");
        String optionB=request.getParameter("optionB");
        String optionC=request.getParameter("optionC");
        String optionD=request.getParameter("optionD");
        String answer=request.getParameter("answer");
        String questionId=request.getParameter("questionId");
        Question question=new Question(Integer.valueOf(questionId),title,optionA,optionB,optionC,optionD,answer);
        int result = dao.update(question);
        if(result==1){
            request.setAttribute("key1","更新成功");

        }else {
            request.setAttribute("key1","更新失败");

        }
        request.getRequestDispatcher("/s.jsp").forward(request,response);
    }


}
