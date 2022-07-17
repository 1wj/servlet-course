<%@ page import="com.example.entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%
        Student stu=new Student("mike",20);
    %>
    学生姓名：<%=stu.getName()%><br>
    学生年龄：<%=stu.getAge()%>
</html>
