package com.bjpowernode.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
         HttpServletRequest request=(HttpServletRequest) servletRequest;
         String uri = request.getRequestURI();
        //2.如果本次请求资源对象与登录相关，【login.html  或loginServlet】
        //此时应该无条件放行
        if(uri.indexOf("login")!=-1 || "/ch05_onlineTest_war_exploded/".equals(uri)){
            //3.放行
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        //3.如果本次请求访问的是其他资源文件，需要的到用户在服务端httpSession
        HttpSession session=request.getSession(false);
        if(session !=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            servletRequest.getRequestDispatcher("/login_error.html").forward(servletRequest,servletResponse);
        }

    }
}
