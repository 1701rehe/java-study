<%--
  Created by IntelliJ IDEA.
  User: CHY
  Date: 2020/11/9
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生登录</title>
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
    <form action="${pageContext.request.contextPath}/loginStudentServlet" method="get" autocomplete="off">
        姓名：<input type="text" name="username"/> <br/>
        密码：<input type="password" name="password"/> <br/>
        <button type="submit">登录</button>
    </form>
</body>
</html>
