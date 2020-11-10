<%@ page import="java.util.ArrayList" %>
<%@ page import="yf513.yhc.bean.Student" %>
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
    <table width="600" border="1px">
        <tr>
            <th>学生姓名</th>
            <th>学生年龄</th>
            <th>学生成绩</th>
        </tr>
        <%
        ArrayList<Student> students=(ArrayList<Student>) session.getAttribute("students");
        for(Student stu:students){
        %>
        <tr align="center">
            <td><%=stu.getUsername()%></td>
            <td><%=stu.getAge()%></td>
            <td><%=stu.getGrade()%></td>
        </tr>
        <%}%>
    </table>
</body>
</html>
