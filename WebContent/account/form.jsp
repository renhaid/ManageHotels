<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.pojo.AdminUser"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.js"></script>
<script type="text/javaScript">
$(function(){
	$("#btn").click(function(){
		$.ajax({
			url:"${pageContext.request.contextPath}/editorServlet.do",
			type:"post",
			data:{"id":$("#id").val(),
				  "username":$("#username").val(),
				  "password":$("#password").val(),
				  "age":$("#age").val(),
				  "remark":$("#remark").val()
				},
			dataType:"json",
			success:function(data){
				if(data!=null){
				alert(data.message);
				//ajax页面跳转，并且从一个地址一直跳转到你login页面的地址，而且页面不会在框架中
				 if(window!=top){
		                parent.window.location.href ='${pageContext.request.contextPath}/login.jsp';
		                return;
		            }
				}else {
					alert("修改失败！");
				}
				
			}
		});
	});
})


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
    <li><a href="#">账户修改</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    <li><label>姓名</label><input id="username" name="username" disabled="disabled"  type="text" class="dfinput"  value="${user.username}"/><i></i></li>
    <li><label>密码</label><input id="password" name="password" type="text" class="dfinput" value="${user.password}"/><i></i></li>
    <li><label>年龄</label><input id="age"name="age" type="text" class="dfinput" value="${user.age}" /></li>
    <li><label>备注</label><input id="remark"name="remark" type="text" class="dfinput" value="${user.remark}" /></li>
    <li><label></label><input id="id" name="id" type="hidden" class="dfinput" value="${user.id}" /></li> 
    <li><label>&nbsp;</label><input id="btn" name="btn" type="button" class="btn" value="确认保存"/></li>
    </ul>
       
    </div>
</body>
</html>
