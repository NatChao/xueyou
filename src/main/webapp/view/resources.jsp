<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2020/5/22
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../static/js/jquery-3.2.1.min.js"></script>
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
        <div style="float: right">
            <button type="button" class="layui-btn" id="test3"><i class="layui-icon"></i>上传文件</button>
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
        table.render({
            elem: '#test'
            ,url:'/queryFiles'//数据加载
            ,title: '资源列表'
            ,cols: [[ //标题栏
                {field: 'id', title: 'ID', width: 70, sort: true}
                ,{field: 'fileName', title: '文件名', width: 100}
                ,{field: 'path', title: '路径', minWidth: 120}
                ,{field: 'size', title: '大小', minWidth: 80}
                ,{field: 'type', title: '类型', width: 80}
                ,{field: 'downcounts', title: '下载次数', width: 80}
                ,{field: 'createTime', title: '上传时间', width: 100}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
            ]]
            ,page: true
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
                window.open("/download?fileName="+data.fileName);
            }
        });
    });
</script>
</html>