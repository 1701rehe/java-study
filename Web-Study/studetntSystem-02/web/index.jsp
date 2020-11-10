<%--
  Created by IntelliJ IDEA.
  User: CHY
  Date: 2020/11/9
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <style>
        a{
            text-decoration: none;
        }
        a:hover{
            color: red;
        }
    </style>
</head>
<body>
<%
    Object username = session.getAttribute("username");
    if (username == null) {

%>
    <a href="/stu/login.jsp">请登录</a>
    <%} else {%>
    <a href="/stu/addStudent.jsp">添加学生</a>
    <a href="/stu/listStudentServlet">查看学生</a>
<%}%>
</body>
</html>
