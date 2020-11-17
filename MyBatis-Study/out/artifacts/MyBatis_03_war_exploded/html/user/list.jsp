<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
    <script type="text/javascript">
        function checkDel(uid){
            var checkDel = window.confirm("确认删除吗？");
            if(checkDel){
                window.location.href = "${pageContext.request.contextPath}/users?method=deleteUser&uid="+uid;
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
            <td width="39%" align="left">[员工管理]</td>

            <td width="57%"align="right">
                <a href="${pageContext.request.contextPath}/users?method=toAdd"><img src="${pageContext.request.contextPath}/images/button/cjyh.gif" /></a>
                <a href="${pageContext.request.contextPath}/users?method=toBatchAdd"><img src="${pageContext.request.contextPath}/images/button/pltj.png"/></a>
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
            <td width="10%" align="center">编号</td>
            <td width="10%" align="center">员工姓名</td>
            <td width="6%" align="center">性别</td>
            <td width="12%" align="center">出生日期</td>
            <td width="12%" align="center">入职时间</td>
            <td width="10%" align="center">登录名称</td>
            <%--<td width="15%" align="center">所属部门</td>
            <td width="10%" align="center">职务</td>--%>
            <td width="10%" align="center">操作</td>
        </tr>
        <c:forEach items="${users}" varStatus="vs" var="user">
        <tr class="tabtd2">
            <td align="center">${user.ucode}</td>
            <td align="center">${user.username}</td>
            <td align="center">${user.gender}</td>
            <td align="center">${user.birthday}</td>
            <td align="center">${user.dutydate}</td>
            <td align="center">${user.loginname}</td>
            <%--<td align="center">Java教学部</td>
            <td align="center">讲师</td>--%>
            <td width="7%" align="center">
                <a href="${pageContext.request.contextPath}/users?method=findUserById&uid=${user.uid}"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"></a>
                <a href="javascript:checkDel('${user.uid}')"><img src="${pageContext.request.contextPath}/images/button/delete.gif" class="img"></a>
            </td>
        </tr>
        </c:forEach>
    </table>
    <%--<table border="0" cellspacing="0" cellpadding="0" align="center">
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
    </table>--%>
</body>
</html>

