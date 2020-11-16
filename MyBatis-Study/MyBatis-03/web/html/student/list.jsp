<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
    <script type="text/javascript">
        function checkDel(sid){
            var checkDel = window.confirm("确认删除吗？");
            if(checkDel){
                window.location.href = "${pageContext.request.contextPath}/students?method=deleteStudent&sid="+sid;
            }
        }
    </script>
</head>
<body >
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="39%" align="left">[在校学生管理]</td>
        <td width="57%"align="right">
            <a href="${pageContext.request.contextPath}/students?method=toAdd"><img src="${pageContext.request.contextPath}/images/button/add.gif" /></a>
            <a href="#"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
    <tr>
        <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
    </tr>
</table>
<table width="100%" border="1" >
    <tr class="henglan" style="font-weight:bold;">
        <td width="10%" align="center">姓名</td>
        <td width="10%" align="center">年龄</td>
        <td width="10%" align="center">生日</td>
        <td width="10%" align="center">操作</td>
    </tr>
    <c:forEach items="${students}" var="student" varStatus="vs">
    <tr class="tabtd2">
        <td align="center">${student.name}</td>
        <td align="center">${student.age}</td>
        <td align="center">${student.birthday}</td>
        <td align="center">
            <a href="${pageContext.request.contextPath}/students?method=findStudentById&sid=${student.sid}"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"></a>
            <a href="javascript:checkDel('${student.sid}')"><img src="${pageContext.request.contextPath}/images/button/delete.gif" class="img"></a>
        </td>
    </tr>
    </c:forEach>
</table>
<table border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
        <td align="right">
            <span>第1/3页</span>
            <span>
        	<a href="#">[首页]</a>&nbsp;&nbsp;
            <a href="#">[上一页]</a>&nbsp;&nbsp;
            <a href="#">[下一页]</a>&nbsp;&nbsp;
            <a href="#">[尾页]</a>
        </span>
        </td>
    </tr>
</table>
</body>
</html>

