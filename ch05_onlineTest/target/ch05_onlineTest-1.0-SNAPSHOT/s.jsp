
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            String value = (String) request.getAttribute("key1");
        %>
        <font style="color: red;font-size: 40px"><%=value%></font>
</body>
</html>
