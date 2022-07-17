package com.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class OneFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        //1.通过拦截[请求对象]得到请求包参数信息，从而得到来访用户的真实年龄
        String age = servletRequest.getParameter("age");
        if( Integer.valueOf(age)<70){//合法请求
            //将所拦截的[请求对象和响应对象交还给tomcat，有tomcat继续调用资源文件

            filterChain.doFilter(servletRequest,servletResponse);//合法请求
        }else{
            //过滤器代替服务器拒绝请求
             servletResponse.setContentType("text/html;charset=utf-8");
            PrintWriter out = servletResponse.getWriter();
            out.print("<font style='color:red;fond-size:40'>不能看</font>");
        }

    }
}
