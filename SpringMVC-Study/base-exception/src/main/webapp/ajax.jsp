<%@page pageEncoding="UTF-8" language="java" contentType="text/html;UTF-8" %>

<a href="javascript:void(0);" id="testException">访问springmvc后台controller，传递Json格式POJO</a><br/>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
    $(function () {
        $("#testException").click(function () {
            $.ajax({
                contentType: "application/json",
                type: "POST",
                url: "save",
                /*通过修改参数，激活自定义异常的出现*/
                // name长度低于8位出现业务异常
                // age小于0出现业务异常
                // age大于100出现系统异常
                // age类型如果无法匹配将转入其他类别异常
                data: '{"name":"chy","age":"25"}',
                dataType: "text",
                //回调函数
                success: function (data) {
                    alert(data);
                }
            });
        });
    });
</script>