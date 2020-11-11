<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: CHY
  Date: 2020/11/9
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看学生信息</title>
</head>
<body>
    <table width="600px" border="1px" align="center">
        <tr>
            <th>学生姓名</th>
            <th>学生年龄</th>
            <th>学生成绩</th>
        </tr>
<%--        <%--%>
<%--        ArrayList<Student> students=(ArrayList<Student>) session.getAttribute("students");--%>
<%--        for(Student stu:students){--%>
<%--        %>--%>
    <c:forEach items="${students}" var="student">
        <tr align="center">
            <td>${student.username}</td>
            <td>${student.age}</td>
            <td>${student.grade}</td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
