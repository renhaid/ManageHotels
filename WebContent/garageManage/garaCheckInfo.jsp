<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.pojo.AdminUser"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>stayInfo</title>
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
		$("#ff").hide();
		//表单验证
		$.extend($.fn.validatebox.defaults.rules, {    
			custType: {    
		        validator: function(value,param){    
		            return value.length>0&&value.length<=4;    
		        },    
		        message: '顾客姓名不可超过四位字符！'   
		    }
		});	
		$('#garaUseName').textbox({    
		    required: true,    // 不能为空  
		    validType: 'custType'
		});
		$('#garaDate').datebox({    
    		required:true   
		});  
		$('#garaId').textbox({    
    		required:true   
		});  
		$('#custId').textbox({    
    		required:true   
		});  
		
				 
		var needRequest = true;
		var needCustId=true;
	//点击事件
		//click点击事件
		$('#btn').click(function(){		
			$.ajax({
				url:"${pageContext.request.contextPath}/queryGarageServlet",
				type:"post",
				data:{"status":"空闲"},
				dataType:"json",
				success:function(data){
					for(var i=0;i<data.length;i++){
						var garaPersonId=data[i];
						var str="<option value=" + garaPersonId + ">" + garaPersonId + "</option>";
						$("#garaPersonId").append(str);
					}
				}
			});	
			
			$("#ff").show();
			var randnum=rand(1000,9999);
			$('#garaId').textbox('setValue',randnum);
			var randm=rand(1000,9999);
			$('#custId').textbox('setValue',randm);
		});
		
		
	
	});
	
	//随机生成四位数的方法
	function rand(min,max) {  
    	return Math.floor(Math.random()*(max-min))+min;  
	} 
</script>

<style type="text/css">
		#ff{
			width: 750px;
			height: 300px;
		}
		#ta{
			width: 750px;
			height: 300px;
			border: 1px solider red;
			background-color: #4A8AF4;
			}
</style>
</head>
<% 
	AdminUser user=(AdminUser)session.getAttribute("user");
%>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">酒店车库管理</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>车库信息登记</span></div>
	<button id="btn" name="button">点击添加信息</button>
	<form  id="ff" action="${pageContext.request.contextPath}/garageCheckServelet" method="post" target="nb_name">
		<table id="ta">
				<tr>
					<td>车位编号：</td><td><input type="text" id="garaId" readonly="readonly" name="garaId"></td>
				</tr>
				<tr>
					<td>使用人姓名：</td><td><input type="text" id="garaUseName" name="garaUseName"></td>
				</tr>
				<tr>
					<td>接待人员编号:</td><td><select id="garaPersonId" name="garaPersonId"></select></td>
				</tr>
				<tr>
					<td>使用日期</td><td><input type="text" id="garaDate" name="garaDate"></td>	
				</tr>
				<tr>
					<td>顾客编号:</td><td><input type="text" readonly="readonly" id="custId"  name="custId"></td>
				</tr>
				<tr>
					<td>说明：</td><td><input type="text" id="remark" name="remark"></td>
				</tr>
				<tr>
					<td colspan="1" align="center"><input type="submit" id="sbt" name="submit" value="添加"></td><td></td>
				</tr>
		
		</table>		
	</form>
	<iframe id="id_frame" name="nb_name" style="display: none;"></iframe>
	</div>
</body>
</html>