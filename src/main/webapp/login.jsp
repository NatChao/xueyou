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
    <title>学友网登录平台</title>
    <link rel="stylesheet" href="./static/css/login.css">
    <style type="text/css">
        h1 {text-transform: none}
    </style>
</head>

<body>
<div class="d1">
    <audio src="./static/music/三亩地 - 城南花已开.mp3" autoplay loop></audio>
    <form class="box" action="/lp/user/login" method="POST">
        <h1 >Login</h1>
        <input type="text" name="" placeholder="userName">
        <input type="password" name="" placeholder="password">
        <input type="submit" name="" value="Login">
    </form>
</div>
</body>

</html>