<%--
  Created by IntelliJ IDEA.
  User: Wj
  Date: 2021/7/13
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%
    //   http://localhost:8080/myweb/index_2.jsp?userName=allen&password=123
    String userName= request.getParameter("userName");
    String passwd= request.getParameter("password");

%>
用户名 :<%=userName%>
用户密码：<%=passwd%>
