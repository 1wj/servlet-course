<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<body>
<!--在jsp文件中直接书写java命令，是不能被jsp文件识别，此时只会被当成字符串写入到响应体中-->
            int num=1;
            int num2=2;
            int num3=num1+num2;
<%
  //在jsp文件中，只有书写在执行标记中内容才会被当成java命令
  //1.声明java变量
   int num=100;
   int num2=100;

   //2.声明运行表达式：数学运算，关系运算，逻辑运算
   int num3=num+num2;//数学运算
   int num4=num2>=num?num2:num;//关系运算
   boolean num5=num>=200 && num2>=100;//逻辑运算
   //3.申明控制语句

%>
<!--在jsp文件中，通过输出标记，通知jsp将java变量的值写入到响应体中-->
num的值：<%=10%><br>
num2的值：<%=num2%>
<!--执行标记还可以通知jsp将运算结果写入到响应体-->
num+num2=<%=num+num2%>
</body>
</html>