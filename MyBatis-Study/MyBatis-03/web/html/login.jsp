<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
    <STYLE>
        .cla1 {
        FONT-SIZE: 12px; COLOR: #4b4b4b; LINE-HEIGHT: 18px; TEXT-DECORATION: none
        }
        .login_msg{
            font-family:serif;
        }
        .login_msg .msg{
            background-color: #acf;
        }
        .login_msg .btn{
            background-color: #9be;
            width: 73px;
            font-size: 18px;
            font-family: 微软雅黑;
        }
    </STYLE>
    <TITLE></TITLE>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
    <LINK href="../css/style.css" type=text/css rel=stylesheet>
    <META content="MSHTML 6.00.2600.0" name=GENERATOR>
    <script type="text/javascript">
        window.onload = function(){
            var errorMsg = '${errorMsg}';
            if(errorMsg != null && errorMsg != ''){
                alert(errorMsg);
            }
        }
    </script>
</HEAD>
<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0" background="${pageContext.request.contextPath}/images/rightbg.jpg">
<div ALIGN="center">
	<table border="0" width="1140px" cellspacing="0" cellpadding="0" id="table1">
		<tr>
			<td height="93"></td>
			<td></td>
		</tr>
		<tr>
			<td background="${pageContext.request.contextPath}/images/right.jpg"  width="740" height="412"></td>
			<td class="login_msg" width="400">
				<form action="${pageContext.request.contextPath}/users?method=login" method="post">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/images/title.png" width="185" height="26"/><br/><br/>
					用户名：<input class="msg" type="text" name="loginName"><br/><br/>
					密&nbsp;码：<input class="msg" type="text" name="password"><br/><br/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="btn" type="submit" value=" 登录 "/>
					<input class="btn" type="button" value=" 注册 " onclick="document.location='${pageContext.request.contextPath}/html/staff/register.jsp'"/>
				</form>
			</td>
		</tr>
	</table>
</div>
</BODY></HTML>