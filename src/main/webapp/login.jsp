<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2020/5/21
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%-- 引入jquery库的js --%>
    <script type="text/javascript" src="static/js/jquery-3.5.1.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学友网登录平台</title>
    <link rel="stylesheet" href="./static/css/login.css">
    <style type="text/css">
        h1 {text-transform: none}
    </style>
</head>

<body>
    <script type="text/javascript">
        //发送ajax请求登录页面
        login = function() {
            $.post({
                url : "/user/login",
                contentType :"application/json",
                dataType:"json",
                data : JSON.stringify({"userName" : $("#userName").val(), "password" : $("#password").val()}),
                success : function (data) {
                    console.log(data)
                    if (data.code == 200) {
                        //判断后端返回的数据状态码、如果是200，则跳转首页
                        window.location.href = "./index.jsp"
                    }else {
                        alert(data.message)
                    }
                }
            });
            
        }

    </script>

    <div class="d1">
        <audio src="./static/music/三亩地 - 城南花已开.mp3" autoplay loop></audio>
        <form class="box">
            <h1 >&lt;登录账号&gt;</h1>
            <input type="text" id="userName" placeholder="userName">
            <input type="password" id="password" placeholder="password">
            <input type="button" value="Login"onclick="login();">
        </form>
    </div>
</body>

</html>