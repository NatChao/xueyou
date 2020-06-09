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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学友网平台注册账号</title>
    <link rel="stylesheet" href="./static/css/login.css">
    <style type="text/css">
        h1 {text-transform: none}
    </style>
</head>

<body>
<div class="d1">
    <audio src="./static/music/三亩地 - 城南花已开.mp3" autoplay loop></audio>
    <form class="box" action="/user/register" method="POST">
        <h1 >&lt;注册账号&gt;</h1>
        <p><h4><font color="#f0f8ff">用户名</font></h4><input type="text" name="userName" placeholder="userName"></p>
        <p><h4><font color="#f0f8ff">密码</font></h4><input type="password" name="password" placeholder="password"></p>
        <input type="submit" name="" value="注册">
    </form>
</div>
</body>

</html>