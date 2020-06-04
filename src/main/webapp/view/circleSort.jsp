<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2020/5/22
  Time: 15:20
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

        <div class="layout-l">
            <%--话题分类标签卡--%>
             <%for (int i=0;i<=5;i++){%>
                <div class="layui-card forum-card">
                    <div class="layui-card-body forum-card-body">
                        <dl class="group-info">
                            <dt class="group-name"><a href="">java</a></dt>
                            <dd class="group-pic"><a href="#"><img src="../static/icon/log.jpg"></a></dd>
                            <dd class="group-time">创建于<em>2017-10-31</em></dd>
                            <dd class="group-total"><em>520</em>个成员</dd>
                            <dd class="group-intro">老师、学生、其他人员，将课堂问题发布在圈中，大家都来回答或列出一些案例证明自己的观点</dd>
                        </dl>
                    </div>
                </div>
            <%}%>
                <div id="demo2-1"></div>
        </div>

        <div class="layout-r">
            <div class="layui-tab layui-tab-card">
                <ul class="layui-tab-title">
                    <li class="layui-this">最新话题</li>
                    <li>热门话题</li>
                    <li>热门回复</li>
                </ul>
                <div class="layui-tab-content" style="height: 400px; background-color: #ffffff" >
                    <div class="layui-tab-item layui-show">最新话题
                    </div>
                    <div class="layui-tab-item">热门话题</div>
                    <div class="layui-tab-item">热门回复</div>
                </div>
            </div>
        </div>



    </div>
    <!-- 底部固定区域 -->
    <div class="layui-footer" style="align-content: center">
        © layui.com - 底部固定区域
    </div>
</div>
</body>
<script>
    layui.use(['carousel','element','laypage'], function(){
        var carousel = layui.carousel;
        //注意：导航 依赖 element 模块，否则无法进行功能性操作
        var element = layui.element;
        var laypage = layui.laypage

        //建造实例
        carousel.render({
            elem: '#test1'  //绑定dom元素
            ,width: '100%' //设置容器宽度
            ,arrow: 'always' //始终显示箭头
        });
        laypage.render({
            elem: 'demo2-1'
            ,count: 100
            ,theme: '#FF5722'
        });
    });
</script>
</html>
