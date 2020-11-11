<%--
  Created by IntelliJ IDEA.
  User: CHY
  Date: 2020/11/11
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>登录页面</title>
    <style>
        a {
            text-decoration: none;
        }

        a:hover {
            color: red;
        }
    </style>
</head>
<body>
<%--    <%--%>
<%--        Object username = session.getAttribute("username");--%>
<%--        if (username == null) {--%>

<%--    %>--%>
    <c:if test="${sessionScope.username eq null}">
        <a href="${pageContext.request.contextPath}/login.jsp">请登录</a>
    </c:if>
    <c:if test="${sessionScope.username ne null}">
        <a href="${pageContext.request.contextPath}/addStudent.jsp">添加学生</a>
        <a href="${pageContext.request.contextPath}/listStudentServlet">查看学生</a>
    </c:if>
</body>
</html>
