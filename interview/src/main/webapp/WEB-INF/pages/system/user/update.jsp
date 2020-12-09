<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../../base.jsp"%>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>面面管理系统</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- 页面meta /-->
</head>
<body>
<div id="frameContent" class="content-wrapper" style="margin-left:0px;">
    <!-- 内容头部 -->
    <section class="content-header">
        <h1>
            系统管理
            <small>用户管理</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="${ctx}"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="${ctx}/system/user/list.do">用户列表</a></li>
        </ol>
    </section>
    <!-- 内容头部 /-->

    <!-- 正文区域 -->
    <section class="content">

        <!--订单信息-->
        <div class="panel panel-default">
            <div class="panel-heading">用户信息</div>
            <form id="editForm" action="${ctx}/system/user?operation=edit" method="post">
                <div class="row data-type" style="margin: 0px">
                    <input type="hidden" name="id" value="${user.id}">

                    <div class="col-md-2 title">邮箱</div>
                    <div class="col-md-4 data">
                        <input disabled type="text" class="form-control" placeholder="邮箱" name="email" value="${user.email}">
                    </div>

                    <div class="col-md-2 title">姓名</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="用户名称" name="userName" value="${user.userName}">
                    </div>

                    <div class="col-md-2 title">所在部门</div>
                    <div class="col-md-4 data">
                        <select class="form-control" onchange="document.getElementById('deptName').value=this.options[this.selectedIndex].text" name="deptId">
                            <option value="">请选择</option>
                            <c:forEach items="${deptList}" var="item">
                                <option ${user.deptId == item.id ?'selected':''} value="${item.id}">${item.deptName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="col-md-2 title">职位</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="职位" name="station" value="${user.station}">
                    </div>

                    <div class="col-md-2 title">性别</div>
                    <div class="col-md-4 data">
                        <div class="form-group form-inline">
                            <div class="radio"><label><input type="radio" ${user.gender==0?'checked':''} name="gender" value="0">男</label></div>
                            <div class="radio"><label><input type="radio" ${user.gender==1?'checked':''} name="gender" value="1">女</label></div>
                        </div>
                    </div>

                    <div class="col-md-2 title">出生日期</div>
                    <div class="col-md-4 data">
                        <div class="input-group date">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <input disabled type="text" placeholder="出生年月" class="form-control pull-right" name="birthday"
                                   value="<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>" id="datepicker1">
                        </div>
                    </div>

                    <div class="col-md-2 title">状态</div>
                    <div class="col-md-4 data">
                        <div class="form-group form-inline">
                            <div class="radio"><label><input type="radio" ${user.state==0?'checked':''} name="state" value="0">停用</label></div>
                            <div class="radio"><label><input type="radio" ${user.state==1?'checked':''} name="state" value="1">启用</label></div>
                        </div>
                    </div>

                    <div class="col-md-2 title">电话</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="电话" name="telephone" value="${user.telephone}">
                    </div>

                    <div class="col-md-2 title">入职日期</div>
                    <div class="col-md-4 data">
                        <div class="input-group date">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <input type="text" placeholder="入职时间"  name="joinDate" class="form-control pull-right"
                                   value="<fmt:formatDate value="${user.joinDate}" pattern="yyyy-MM-dd"/>" id="2">
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <!--订单信息/-->

        <!--工具栏-->
        <div class="box-tools text-center">
            <button type="button" onclick='document.getElementById("editForm").submit()' class="btn bg-maroon">保存</button>
            <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
        </div>
        <!--工具栏/-->

    </section>
    <!-- 正文区域 /-->

</div>
<!-- 内容区域 /-->
</body>
<script src="${ctx}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="${ctx}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<link rel="stylesheet" href="${ctx}/css/style.css">
<script>
    $('#datepicker').datepicker({
        autoclose: true,
        format: 'yyyy-mm-dd'
    });
    $('#datepicker1').datepicker({
        autoclose: true,
        format: 'yyyy-mm-dd'
    });
</script>
</html>