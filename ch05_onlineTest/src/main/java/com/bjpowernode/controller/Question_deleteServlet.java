package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Question_deleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionId = request.getParameter("questionId");
        QuestionDao dao=new QuestionDao();
        int result=dao.delete(questionId);
        if(result==1){
            request.setAttribute("key1","删除成功");

        }else {
            request.setAttribute("key1","删除失败");

        }
        request.getRequestDispatcher("/s.jsp").forward(request,response);
    }


}
