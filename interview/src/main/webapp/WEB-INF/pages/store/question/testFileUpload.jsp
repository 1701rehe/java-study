﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../base.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>黑马面面管理系统</title>
</head>
<body>
    <div id="frameContent" class="content-wrapper" style="margin-left:0px;">
        <section class="content-header">
            <h1>
                题库管理
                <small>题目管理</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
            </ol>
        </section>
        <section class="content">
            <div class="box-body">
                <div class="nav-tabs-custom">
                    <ul class="nav nav-tabs">
                        <li class="active">
                            <a href="#tab-form" data-toggle="tab">文件上传测试</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <form id="editForm" action="${ctx}/store/question?operation=testUpload" method="post" enctype="multipart/form-data">
                            <div class="tab-pane active" id="tab-form">
                                <div class="row data-type">

                                    <div class="col-md-2 title">题干图片</div>
                                    <div class="col-md-10 data ">
                                        <input type="file" class="form-control" placeholder="题干图片" name="picture">
                                    </div>

                                </div>
                                <!--工具栏-->
                                <div class="box-tools text-center">
                                    <button type="button" onclick='document.getElementById("editForm").submit()' class="btn bg-maroon">保存</button>
                                    <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </div>
</body>

</html>