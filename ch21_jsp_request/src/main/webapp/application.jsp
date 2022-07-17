
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
    ServletContext application全局作用域对象
同一个网站中Servlet与jsp，都可以同过当前网站的全局作用域对象实现数据共享
jsp文件内置对象：application
-->
<%
    application.setAttribute("key1",2000);
%>
