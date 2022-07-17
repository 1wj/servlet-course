<%@ page import="java.util.List" %>
<%@ page import="com.bjpowenode.entity.Student" %>
import java.util.List;
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
   List<Student>  list =(List) request.getAttribute("key1");
%>
      <table align="center" border="2px">
         <tr>
            <td>员工姓名</td>
            <td>员工年龄</td>
         </tr>
<%
   for (Student st:list) {
%>
         <tr>
            <td><%=st.getName()%></td>
            <td><%=st.getAge()%></td>
         </tr>
<%
   }
%>    </table>