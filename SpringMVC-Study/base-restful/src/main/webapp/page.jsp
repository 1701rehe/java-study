<%@page pageEncoding="UTF-8" language="java" contentType="text/html;UTF-8" %>
<h1>restful风格请求表单</h1>
<%--切换请求路径为restful风格--%>
<%--GET请求通过地址栏可以发送，也可以通过设置form的请求方式提交--%>
<%--POST请求必须通过form的请求方式提交--%>
<form action="/user/100" method="post">
    <%--当添加了name为_method的隐藏域时，可以通过设置该隐藏域的值，修改请求的提交方式，切换为PUT请求或DELETE请求，但是form表单的提交方式method属性必须填写post--%>
    <%--该配置需要配合HiddenHttpMethodFilter过滤器使用，单独使用无效，请注意检查web.xml中是否配置了对应过滤器--%>
    <input type="text" name="_method" value="PUT"/>
    <input type="submit"/>
</form>