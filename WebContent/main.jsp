<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.pojo.AdminUser"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主页面</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

</head>
<%
    AdminUser user=(AdminUser)session.getAttribute("user");
%>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    </ul>
    </div>
    
    <div class="mainindex">
    
    
    <div class="welinfo">
    <span><img src="images/sun.png" alt="天气" /></span>
    <b>${user.username}您好，欢迎使用酒店业务管理系统</b> 
    </div>
    
    <div class="welinfo">
    <span><img src="images/time.png" alt="时间" /></span>
    <i>您上次登录的时间：${user.last_time}</i> （不是您登录的？<a href="account/form.jsp" target="rightFrame">请点这里</a>）
    </div>
    
    <div class="xline"></div>
    
    <ul class="iconlist">
    
    <li><img src="images/ico01.png" /><p><a href="#">管理设置</a></p></li>
    <li><img src="images/ico02.png" /><p><a href="#">发布文章</a></p></li>
    <li><img src="images/ico03.png" /><p><a href="#">数据统计</a></p></li>
    <li><img src="images/ico04.png" /><p><a href="#">文件上传</a></p></li>
    <li><img src="images/ico05.png" /><p><a href="#">目录管理</a></p></li>
    <li><img src="images/ico06.png" /><p><a href="#">查询</a></p></li> 
            
    </ul>
    <div class="xline"></div>
    <div class="box"></div>
    
    <div class="welinfo">
    <span><img src="images/dp.png" alt="提醒" /></span>
    <b>酒店业务信息管理系统使用指南</b>
    </div>
    
    <ul class="infolist">
    <li><span>您可以进行酒店的业务管理操作</span><a class="ibtn">酒店业务操作</a></li>
    <li><span>您可以快速查询房间信息</span><a class="ibtn">查询信息</a></li>
    <li><span>您可以进行密码修改、账户设置等操作</span><a class="ibtn">账户管理</a></li>
    </ul>
    
    <div class="xline"></div> 
    </div>
</body>
</html>