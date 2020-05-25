<%@ page import="com.sun.org.apache.bcel.internal.util.ClassPath" %><%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2020/5/21
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>首页</title>
  <link rel="stylesheet" href="./layui/css/layui.css">
  <script src="./layui/layui.js"></script>
  <link rel="stylesheet" href="./static/css/forum.css">
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
              浩子
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
      <div class="forum-layout">
        <%--轮播图--%>
        <div class="layout-l">
          <div class="layui-carousel" id="test1">
            <div carousel-item>
              <div>条目1</div>
              <div>条目2</div>
              <div>条目3</div>
              <div>条目4</div>
              <div>条目5</div>
            </div>
          </div>
        </div>
        <%--登录界面--%>
        <div class="layout-r">
          <div class="layout-r">
            <dl class="member-no-login">
              <dd class="avatar"><img src="./static/icon/log.jpg"> </dd>
              <dd class="welcomes">您好,欢迎来到<strong>学习交流圈子</strong></dd>
              <dd class="quick-link"> 如果您已经是会员请<a href="./login.jsp" nctype="login" class="url">[登录]</a>后进行操作;<br>
                或现在就<a href="#" class="url">[注册]</a>成为会员。</dd>
            </dl>
            <div class="group-theme-list">
              <ul>
                <li><span>[默认]</span><a href="#" title="学习资料理论类：基本管理方法（法律方法、经济方法、教育方法、行政方法）">学习资料理论类：基本管理方法（法律方法、经济方法、教育方法、行政方法）</a></li>
                <li><span>[默认]</span><a href="#" title="管理问题思考讨论：什么是管理？举出一些管理活动的例子并说明其价值">管理问题思考讨论：什么是管理？举出一些管理活动的例子并说明其价值</a></li>
                <li><span>[默认]</span><a href="#" title="管理问题思考讨论：关键影响因素分析方法及其案例（可是论文成果介绍）">管理问题思考讨论：关键影响因素分析方法及其案例（可是论文成果介绍）</a></li>
                <li><span>[默认]</span><a href="#" title="学习资料理论类：计划评价标准、政策评价标准等（课堂学习）">学习资料理论类：计划评价标准、政策评价标准等（课堂学习）</a></li>
                <li><span>[默认]</span><a href="#" title="管理问题思考讨论：介绍一些预测方法及其应用案例（可以是论文等研究成果介绍）">管理问题思考讨论：介绍一些预测方法及其应用案例（可以是论文等研究成果介绍）</a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
        <%--功能面板选择--%>
      <div class="recommend-group">
        <div class="layui-card">
          <div class="layui-card-body">
            <a href="./view/resources.jsp">超级资料库</a>
          </div>
        </div>
        <div class="layui-card">
          <div class="layui-card-body">
            <a href="./view/infor.jsp">超级信息库</a>
          </div>
        </div>
        <div class="layui-card">
          <div class="layui-card-body">
            <a href="view/circleSort.jsp">学习社区</a>
          </div>
        </div>
        <div class="layui-card">
          <div class="layui-card-body">
            <a href="#">学习一对一</a>
          </div>
        </div>
      </div>

      <%--话题推荐--%>
      <div class="recommend-group">
        <div class="layout-l forum-tab-size">
          <div class="layui-tab layui-tab-card">
            <ul class="layui-tab-title">
              <li class="layui-this">最新话题</li>
              <li>热门话题</li>
              <li>热门回复</li>
            </ul>
            <div class="layui-tab-content" style="height: 400px;">
              <div class="layui-tab-item layui-show">最新话题
              </div>
              <div class="layui-tab-item">热门话题</div>
              <div class="layui-tab-item">热门回复</div>
            </div>
          </div>
        </div>
        <div class="layout-r forum-tab-size">
          <div class="layui-tab layui-tab-card">
            <ul class="layui-tab-title">
              <li class="layui-this">推荐话题</li>
            </ul>
            <div class="layui-tab-content" style="height: 400px;">
              <div class="layui-tab-item layui-show">推荐话题
              </div>
            </div>
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
  layui.use(['carousel','element'], function(){
    var carousel = layui.carousel;
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    var element = layui.element;
    //建造实例
    carousel.render({
      elem: '#test1'
      ,width: '100%' //设置容器宽度
      ,arrow: 'always' //始终显示箭头
    });

      //…
    });
</script>
</html>
