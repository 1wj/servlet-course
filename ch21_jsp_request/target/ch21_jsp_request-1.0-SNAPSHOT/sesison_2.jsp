<%--
  Created by IntelliJ IDEA.
  User: Wj
  Date: 2021/7/13
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Integer str= (Integer) session.getAttribute("key1");
%>
session2的值<%=str%>