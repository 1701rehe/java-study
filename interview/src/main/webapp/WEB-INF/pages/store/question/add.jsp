<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../base.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>面面管理系统</title>
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
                        <a href="#tab-form" data-toggle="tab">新增题目</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <form id="editForm" action="${ctx}/store/question?operation=save" method="post"
                          enctype="multipart/form-data">
                        <div class="tab-pane active" id="tab-form">
                            <div class="row data-type">

                                <div class="col-md-2 title">所属企业</div>
                                <div class="col-md-4 data">
                                    <select class="form-control" name="companyId"
                                            onchange="document.getElementById('courseName').value=this.options[this.selectedIndex].text">
                                        <option value="">请选择</option>
                                        <c:forEach items="${companyList}" var="item">
                                            <option value="${item.id}">${item.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="col-md-2 title">所属类别</div>
                                <div class="col-md-4 data">
                                    <select class="form-control" name="catalogId"
                                            onchange="document.getElementById('catalogName').value=this.options[this.selectedIndex].text">
                                        <option value="">请选择</option>
                                        <c:forEach items="${catalogList}" var="item">
                                            <option value="${item.id}">${item.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="col-md-2 title rowHeight2x">题目简介</div>
                                <div class="col-md-10 data rowHeight2x">
                                    <textarea class="form-control" rows="3" name="remark"></textarea>
                                </div>

                                <div class="col-md-2 title rowHeight2x">题干</div>
                                <div class="col-md-10 data rowHeight2x">
                                    <textarea class="form-control" rows="3" name="subject"></textarea>
                                </div>

                                <div class="col-md-2 title">题干图片</div>
                                <div class="col-md-10 data ">
                                    <input type="file" class="form-control" placeholder="题干图片" name="picture">
                                </div>

                                <div class="col-md-2 title rowHeight2x">题目分析</div>
                                <div class="col-md-10 data rowHeight2x">
                                    <textarea class="form-control" rows="3" name="analysis"></textarea>
                                </div>

                                <div class="col-md-2 title">题目类型</div>
                                <div class="col-md-4 data">
                                    <select class="form-control" name="type">
                                        <option value="">请选择</option>
                                        <option value="1" selected>单选题</option>
                                        <option value="2">多选题</option>
                                        <option value="3">简答题</option>
                                    </select>
                                </div>

                                <div class="col-md-2 title">难易程度</div>
                                <div class="col-md-4 data">
                                    <select class="form-control" name="difficulty">
                                        <option value="">请选择</option>
                                        <option value="1" selected>★</option>
                                        <option value="2">★★</option>
                                        <option value="3">★★★</option>
                                        <option value="4">★★★★</option>
                                        <option value="5">★★★★★</option>
                                    </select>
                                </div>

                                <div class="col-md-2 title">是否经典</div>
                                <div class="col-md-4 data">
                                    <select class="form-control" name="isClassic">
                                        <option value="">请选择</option>
                                        <option value="1" selected>经典题</option>
                                        <option value="0">普通题</option>
                                    </select>
                                </div>

                                <div class="col-md-2 title">题目状态</div>
                                <div class="col-md-4 data">
                                    <select class="form-control" name="state">
                                        <option value="">请选择</option>
                                        <option value="1" selected>启用</option>
                                        <option value="0">禁用</option>
                                    </select>
                                </div>

                            </div>
                            <!--工具栏-->
                            <div class="box-tools text-center">
                                <button type="button" onclick='document.getElementById("editForm").submit()'
                                        class="btn bg-maroon">保存
                                </button>
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