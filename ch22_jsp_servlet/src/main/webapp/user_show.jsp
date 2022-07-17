<%@ page import="java.util.List" %>
<%@ page import="com.bjpowenode.entity.Student" %>
import java.util.List;
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //从请求作用域得到OneServlet添加进去的集合
   List<Student>  list =(List) request.getAttribute("key1");
%>
<!--将处理结果写入到响应体-->
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
%>
      </table>