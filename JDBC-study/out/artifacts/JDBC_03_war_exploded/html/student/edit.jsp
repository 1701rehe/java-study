<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/js/jquery-1.3.1.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            var but_jiben = $("#but_jiben");
            var but_xiangxi = $("#but_xiangxi");
            var xiangxi = $("#xiangxi");
            var jiben = $("#jiben");
            xiangxi.hide();

            but_jiben.click(function(){
                //alert();
                jiben.show();
                xiangxi.hide();
            });

            but_xiangxi.click(function(){
                jiben.hide();
                xiangxi.show();
            });
        });
    </script>
</head>
<body class="emp_body">
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <tr>
            <td class="topg"></td>
        </tr>
    </table>
    <table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
        <tr>
            <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
            <td width="44%" align="left">[编辑正式学员]</td>

            <td width="52%"align="right">
                <!--<a href="listLog.html"><img src="${pageContext.request.contextPath}/images/button/find.gif" class="img"/></a>
                <a href="addLog.html"><img src="${pageContext.request.contextPath}/images/button/add.gif" class="img"/></a>~-->

                <!-- <a href="#"><img src="${pageContext.request.contextPath}/images/button/close.gif" class="img"/></a>-->
                <a href="javascript:document.forms[0].submit()"><img src="${pageContext.request.contextPath}/images/button/save.gif" /></a>
                <a href="javascript:history.back()"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
            </td>
            <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
        </tr>
    </table>
    <<%--div class="emp_info"><input type="button" id="but_jiben" value="基本信息" />
        <input type="button"  id="but_xiangxi" value="详细资料"/>
    </div>--%>

    <div id="jiben">
        <form action="${pageContext.request.contextPath}/students?method=updateStudent" method="post">
            <input type="hidden" name="sid" value="${student.sid}"/>
            <table width="88%" class="emp_table">
                <tr>
                    <td width="10%" align="left">学生姓名：</td>
                    <td width="15%" align="left"><input type="text" name="name" value="${student.name}"/></td>
                    <td width="10%" align="left">学生年龄：</td>
                    <td width="15%" align="left"><input type="text" name="age" value="${student.age}"/></td>
                    <td width="10%" align="left">学生生日：</td>
                    <td width="15%" align="left"><input type="text" name="birthday" value="${student.birthday}"/></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
