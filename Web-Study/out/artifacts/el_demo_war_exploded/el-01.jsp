<%--
  Created by IntelliJ IDEA.
  User: CHY
  Date: 2020/11/9
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
<%--  1.向域对象中添加数据  --%>
<%
    request.setAttribute("username", "chy");
%>
<%--2.获取数据--%>
java代码块：<% out.println(request.getAttribute("username")); %><br/>

JSP：<%= request.getAttribute("username")%> <br/>

<%--EL表达式并不需要知道是哪一个作用域--%>
EL表达式：${username}<br/>
<%= request.getContextPath() %> <br/>
${pageContext.request.contextPath}<br/>
<c:out value="NULL" default="25"/>
</body>
</html>
