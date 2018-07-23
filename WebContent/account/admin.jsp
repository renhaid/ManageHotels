<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.pojo.AdminUser"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.js"></script>
<style type="text/css">
    #close{
       font-size: 18px;
       font-family: SimSun;
    }
    button{
      width:90px;
      heigth:30px;
      margin-left:10px;
      background-color: #3C97CD;    
    }
</style>
<script type="text/javascript">
	$(function(){
		
    $("#btn").hover(
    	function(){
    		$(this).css('background-color','#3C97CD');
    	},
    	function(){
    		$(this).css('background-color','#7A7A7A');
    	}
    
    );
});
    	
    

</script>
</head>
<%
     AdminUser user=(AdminUser)session.getAttribute("user");
%>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">账户查询</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    <li><label>姓名</label><input name="username" disabled="disabled" type="text" class="dfinput" value="${user.username}" /><i></i></li>
    <li><label>年龄</label><input name="age" disabled="disabled" type="text" class="dfinput" value="${user.age}" /></li>
    <li><label>Remark</label><input name="remark" disabled="disabled" type="text" class="dfinput" value="${user.remark}" /></li>
    <li><label>上次登录日期</label><input name="last_time" disabled="disabled" type="text" class="dfinput" value="${user.last_time}" /></li>
    <li><label>修改日期</label><input name="editor_time" disabled="disabled" type="text" class="dfinput" value="${user.editor_time}" /></li>
    <li><label>注册日期</label><input name="register_time" disabled="disabled" type="text" class="dfinput" value="${user.register_time}" /></li>
    <li><label>&nbsp;</label><button id="btn"><a id="close" href="${pageContext.request.contextPath}/main.jsp" target="rightFrame">关闭</a></button></li>
    </ul>
    
    
    </div>

</body>
</html>