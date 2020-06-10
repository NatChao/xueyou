<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2020/5/22
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.xueyouwang.xueyou.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../static/js/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script src="../layui/layui.js"></script>
    <link rel="stylesheet" href="../static/css/forum.css">
</head>
<%
    String token =(String) request.getSession().getAttribute("token");
    User user =(User)request.getSession().getAttribute("user");
%>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <%--教务系统登录--%>
    <div  class="btn">
        <p>快速学校教务系统： <a href="#">登录</a></p>
    </div>
    <div class="layui-header ">
        <div class="layui-logo">layui 后台布局</div>
        <%--    导航栏--%>
        <%
            if(token!=null){

        %>
        <div>
            <ul class="layui-nav layui-layout-right">

                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                        <%= user.getUserName()%>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="">基本资料</a></dd>
                        <dd><a href="">安全设置</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="/user/cancellation">退了</a></li>
            </ul>
        </div>
        <%
            }%>
    </div>
    <!-- 内容主体区域 -->
    <div class="layui-body forum-body">
        <%-- 搜索框--%>



        <%--资源展示列表  --%>
            <div style="text-align: center">
                <h3>话题标题</h3>
                <table border="1"   style="width: 400px;height: 400px;margin: 0 auto">
                    <tr>
                        <td valign="top">
                        <p>user_name </p><img src="webapp/static/icon/log.jpg">
                        </td>
                        <td valign="top">
                            <input type="text" name="话题详情"/>
                        </td>
                    </tr>
                </table>
                <script type="text/html" id="barDemo">
                    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="download">话题详情</a>
                </script>
            </div>


    </div>
    <!-- 底部固定区域 -->
    <div class="layui-footer" style="align-content: center">
        © layui.com - 底部固定区域
    </div>
</div>
</body>

<script>
    layui.use(['carousel', 'jquery','element','table','form','upload'], function(){
        var carousel = layui.carousel;
        var $ = layui.jquery;
        var upload = layui.upload;
        // 表单模块
        var form = layui.form
        //注意：导航 依赖 element 模块，否则无法进行功能性操作
        var element = layui.element;
        //表单模块
        var table = layui.table;
        //建造实例
        carousel.render({
            elem: '#test1'  //绑定dom元素
            ,width: '100%' //设置容器宽度
            ,arrow: 'always' //始终显示箭头
        });

        //上传文件

        upload.render({
            elem: '#test3'
            ,url: '/uploadSource/' //改成您自己的上传接口
            ,method:'post'
            ,accept: 'file' //普通文件
            ,done: function(res){
                layer.msg('上传成功');
                console.log(res);

            },

        });
        //监听下载工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'download'){
                console.log(data.id);
                window.open("/download?file_name="+data.file_name);
            }
        });
    });
</script>
</html>