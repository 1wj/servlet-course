<%@ page import="com.bjpowernode.entity.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Student stu1=new Student("mike",18);
    Student stu2=new Student("allen",118);
    Student stu3=new Student("smith",218);
    List<Student> list=new ArrayList<>();
    list.add(stu1);
    list.add(stu2);
    list.add(stu3);

%>
<table border="2" align="center">
    <tr>
        <td>员工编号</td>
        <td>员工年龄</td>
    </tr>
    <%
        for(Student stu:list){
    %>
    <tr>
        <td><%=stu.getName()%></td>
        <td><%=stu.getAge()%></td>
    </tr>
    <%
        }
    %>


</table>

