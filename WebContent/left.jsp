<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.pojo.AdminUser"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
});	
</script>

</head> 
<%
	AdminUser user=(AdminUser)session.getAttribute("user");
%>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>通讯录</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>管理信息
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="main.jsp" target="rightFrame">首页模版</a><i></i></li>
<!--         <li class="active"><cite></cite><a href="right.html" target="rightFrame">数据列表</a><i></i></li>
        <li><cite></cite><a href="imgtable.html" target="rightFrame">图片数据表</a><i></i></li>
        <li><cite></cite><a href="form.html" target="rightFrame">添加编辑</a><i></i></li>
        <li><cite></cite><a href="imglist.html" target="rightFrame">图片列表</a><i></i></li>
        <li><cite></cite><a href="imglist1.html" target="rightFrame">自定义</a><i></i></li>
        <li><cite></cite><a href="tools.html" target="rightFrame">常用工具</a><i></i></li>
        <li><cite></cite><a href="filelist.html" target="rightFrame">信息管理</a><i></i></li>
        <li><cite></cite><a href="tab.html" target="rightFrame">Tab页</a><i></i></li> -->
        <li><cite></cite><a href="error.html" target="rightFrame">404页面</a><i></i></li>
        </ul>    
    </dd>
        
    
    <dd><div class="title"><span><img src="images/leftico03.png" /></span>酒店客房管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="roomManage/roomInfo.jsp" target="rightFrame">客房信息</a><i></i></li>
        <li><cite></cite><a href="roomManage/stayInfo.jsp" target="rightFrame">入住手续</a><i></i></li>
        <li><cite></cite><a href="roomManage/checkout.jsp" target="rightFrame">退房手续</a><i></i></li>
    </ul>    
    </dd>  
    
      
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>酒店餐厅管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="reastuManage/seatInfo.jsp" target="rightFrame">座位信息</a><i></i></li>
        <li><cite></cite><a href="reastuManage/reastCustInfo.jsp" target="rightFrame">预定座位</a><i></i></li>
        <li><cite></cite><a href="reastuManage/endReastCustInfo.jsp" target="rightFrame">结束用餐</a><i></i></li> 
        </ul>     
    </dd> 
       
    
    <dd><div class="title"><span><img src="images/leftico04.png" /></span>酒店车库管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="garageManage/garaInfo.jsp"  target="rightFrame">车库信息</a><i></i></li>
        <li><cite></cite><a href="garageManage/garaCheckInfo.jsp" target="rightFrame">车位信息登记</a><i></i></li>
        <li><cite></cite><a href="garageManage/endCheckInfo.jsp" target="rightFrame">结束使用车库</a><i></i></li>
    </ul>
    
    </dd> 
    
    <dd><div class="title"><span><img src="images/leftico04.png" /></span>酒店人事管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="personManage/roomWiterManage.jsp" target="rightFrame">客房人员管理</a><i></i></li>
        <li><cite></cite><a href="personManage/reastWaiter.jsp" target="rightFrame">餐厅人员管理</a><i></i></li>
        <li><cite></cite><a href="personManage/garageWaiter.jsp" target="rightFrame">车库人员管理</a><i></i></li>
    </ul>
    </dd> 
    
    <dd><div class="title"><span><img src="images/leftico04.png" /></span>费用管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="payManage/roomPayInfo.jsp" target="rightFrame">住房消费</a><i></i></li>
        <li><cite></cite><a href="payManage/reastPayInfo.jsp" target="rightFrame">餐厅消费</a><i></i></li>
        <li><cite></cite><a href="payManage/garaPayInfo.jsp" target="rightFrame">车库消费</a><i></i></li>
    </ul>
    </dd>   
    
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>账号设置</div>
    <ul class="menuson">
        <li><cite></cite><a href="account/admin.jsp" target="rightFrame">账号信息查询</a><i></i></li>
        <li><cite></cite><a href="account/form.jsp" target="rightFrame">账号修改</a><i></i></li>
        </ul>     
    </dd>  
    
    </dl>
</body>
</html>