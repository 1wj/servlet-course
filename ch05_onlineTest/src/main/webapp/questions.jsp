<%@ page import="java.util.List" %>
<%@ page import="com.bjpowernode.entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: Wj
  Date: 2021/7/16
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
            <%
                List<Question> list = (List) request.getAttribute("key2");
                int count=0;
            %>
            <table align="center" border="2px">
                <tr align="center">
                    <td>id</td>
                    <td>题目</td>
                    <td>A：</td>
                    <td>B：</td>
                    <td>C：</td>
                    <td>D：</td>
                    <td>回答：</td>
                    <td colspan="2">操作：</td>
                </tr>

            <%
                for (Question i:list) {
                if(count%2==0){
                    count++;
            %>
                <tr style="background-color: gray">
            <%
                }else{
                    count++;
             %>
                <tr style="background-color: red">
             <%
                }
             %>

                    <td><%=i.getQuestionId()%></td>
                    <td><%=i.getTitle()%></td>
                    <td><%=i.getOptionA()%></td>
                    <td><%=i.getOptionB()%></td>
                    <td><%=i.getOptionC()%></td>
                    <td><%=i.getOptionD()%></td>
                    <td><%=i.getAnswer()%></td>
                    <td><a href="/ch05_onlineTest_war_exploded/question/delete?questionId=<%=i.getQuestionId()%>">用户删除</a></td>
                    <td><a href="/ch05_onlineTest_war_exploded/question/findId?questionId=<%=i.getQuestionId()%>">具体详情</a></td>

                </tr>
            <%
                }
            %>
            </table>

</body>
</html>
