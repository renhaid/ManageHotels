<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.vo.PlayShow"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>roomPayInfo</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.js"></script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/demo（网页端示例）/demo.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/main.js"></script>

<script type="text/javascript">
	$(function(){
		//表单隐藏
		
		$('#btn').click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/queryReastPayInfo",
				type:"post",
				data:{"custId":$("#custId").val(),
					"custName":$("#custName").val()
					},
				dataType:"json",
				success:function(data){
					if(data!=null){
						alert("查询成功");
						$("#cust").val(data.custName);
						$("#seatId").val(data.seatId);
						$("#money").val(data.money);
						
					}
				}
			});
		});
	})

</script>
<style type="text/css">
	#tt{
		height: 300px;
		width: 750px;
	}
</style>
</head>
<%
	PlayShow play=(PlayShow)session.getAttribute("playshow");
%>
<body>
		<input type="text" id="custName" name="custName" placeholder="请输入顾客姓名">
		<input type="text" id="custId" name="custId" placeholder="请输入顾客编号">
		<button id="btn" name="button">点击查询</button>	
		<table id="tt">
			<tr><td>顾客姓名：</td><td><input type="text" id="cust" name="custName" readonly="readonly"  ></td></tr>
			<tr><td>座位编号:</td><td><input type="text" id="seatId" name="seatId" readonly="readonly" ></td></tr>
			<tr><td>消费金额:</td><td><input type="text" id="money" name="money" readonly="readonly" ></td></tr>
		</table>
</body>
</html>