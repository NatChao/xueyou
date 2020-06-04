<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2020/5/22
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script src="../layui/layui.js"></script>
    <link rel="stylesheet" href="../static/css/forum.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <%--教务系统登录--%>
    <div  class="btn">
        <p>快速学校教务系统： <a href="#">登录</a></p>
    </div>
    <div class="layui-header ">
        <div class="layui-logo">layui 后台布局</div>
        <%--    导航栏--%>
        <div>
            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                        贤心
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="">基本资料</a></dd>
                        <dd><a href="">安全设置</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">退了</a></li>
            </ul>
        </div>
    </div>
    <!-- 内容主体区域 -->
    <div class="layui-body forum-body">
        <%-- 搜索框--%>
        <div>
            <form class="layui-form" style="float: left" action="">
                <div class="layui-form-item">
                    <div class="layui-input-inline">
                        <input type="text" name="resourceName" lay-verify="resourceName" autocomplete="off" placeholder="请输入资源名称" class="layui-input">
                    </div>
                    <div class="layui-input-inline">
                        <button type="submit" class="layui-btn layui-btn-normal layui-btn-radius">搜索</button>
                    </div>
                </div>
            </form>
        </div>
        <%--资源展示列表  --%>
        <div>
            <table class="layui-hide" id="test" lay-filter="test"></table>
            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="download">下载</a>
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
    layui.use(['carousel','element','table','form'], function(){
        var carousel = layui.carousel;
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
        table.render({
            elem: '#test'
            ,url:'../json/demo1.json'//数据加载
            ,title: '资源列表'
            ,cols: [[ //标题栏
                {field: 'id', title: 'ID', width: 80, sort: true}
                ,{field: 'username', title: '用户名', width: 120}
                ,{field: 'email', title: '邮箱', minWidth: 150}
                ,{field: 'sign', title: '签名', minWidth: 160}
                ,{field: 'sex', title: '性别', width: 80}
                ,{field: 'city', title: '城市', width: 100}
                ,{field: 'experience', title: '积分', width: 80, sort: true}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
            ]]
            ,page: true
        });
        //监听下载工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'download'){
                layer.confirm('真的删除行么', function(index){
                    obj.download();
                    layer.close(index);
                });
            }
        });
    });
</script>
</html>
