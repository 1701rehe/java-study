<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>新增用户</title>
    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>
</head>
<body class="emp_body">
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <tr>
            <td class="topg"></td>
        </tr>
    </table>
    <table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
        <tr>
            <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
            <td width="44%" align="left">[员工管理]</td>
            <td width="52%" align="right">
                <a href="javascript:document.forms[0].submit()"><img src="${pageContext.request.contextPath}/images/button/save.gif"/></a>
                <a href="javascript:history.back()"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif"/></a>
            </td>
            <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
        </tr>
    </table>
        <!--员工新增的表单-->
        <form action="${pageContext.request.contextPath}/users?method=saveUser" method="post">
            <table width="88%" border="0" class="emp_table" style="width:80%;">
                <tr>
                    <td width="10%">登录名：</td>
                    <td width="20%"><input type="text" name="loginname"/></td>
                    <td width="10%">密码：</td>
                    <td width="20%"><input type="text" name="password"/></td>
                </tr>
                <tr>
                    <td>姓名：</td>
                    <td><input type="text" name="username"/></td>
                    <td>性别：</td>
                    <td>
                        <select name="gender" style="width:170px;">
                            <option>---请选择---</option>
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </td>
                </tr>
                <!--后期可以加上日期控件-->
                <tr>

                    <td width="10%">出生日期：</td>
                    <td width="20%"><input type="text" name="birthday"/></td>
                    <td width="8%">入职时间：</td>
                    <td width="62%"><input type="text" name="dutydate"/></td>
                </tr>
                <!--现在不考虑多表关系
                <tr>
                    <td width="10%">所属部门：</td>
                    <td width="20%"><select>
                        <option>----请--选--择----</option>
                    </select></td>
                    <td width="8%">职务：</td>
                    <td width="62%"><select>
                        <option>----请--选--择----</option>
                    </select></td>
                </tr>-->
            </table>
        </form>
    </body>
</html>

