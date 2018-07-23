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
		    },
		    priceType: {    
	    		validator: function(value,param){    
	        	var reg=/^[1-9]\d*(,\d{3})*(\.\d{2})?$/;  
	        	return reg.test(value);
	   	 	},    
	  	 	 message: '价格格式不对'   
		 	}
		});
		
		
		$('#custName').textbox({    
		    required: true,    // 不能为空  
		    validType: 'custType'
		});
		
		$('#price').textbox({    
		    required: true,    // 不能为空
		    validType: 'priceType'   
		}); 
		var needRequest = true;
		var needCustId=true;
	//点击事件
		//click点击事件
		$('#btn').click(function(){		
			$.ajax({
				url:"${pageContext.request.contextPath}/queryReasturantServlet.do",
				type:"post",
				data:{"seatSatus":"空闲"},
				dataType:"json",
				success:function(data){
					for(var i=0;i<data.length;i++){
						var seatId=data[i];
						var str="<option value=" + seatId + ">" + seatId + "</option>";
						$("#sel").append(str);
					}
				}
			});	
			
			$("#ff").show();
		});
		
		$("#restReceptId").click(function(){
			if(needRequest) {
				$("#restReceptId").empty();
				$.ajax({
					url:"${pageContext.request.contextPath}/queryReceptId",
					type:"post",
					data:{"status":"空闲"},
					dataType:"json",
					success:function(data){
						for(var i=0;i<data.length;i++){
							var restReceptId=data[i];
							var child=$("<option value=" + restReceptId + ">" + restReceptId + "</option>");
							$("#restReceptId").append(child);
						}
					}
				});	
				needRequest = false;
			}	
		})
		
		$("#custId").click(function(){
			if(needCustId){
				$("#custId").empty();
				$.ajax({
					url:"${pageContext.request.contextPath}/queryCustId",
					type:"post",
					data:{"remark":"在住"},
					dataType:"json",
					success:function(data){
						for(var i=0;i<data.length;i++){
							var custId=data[i];
							var child=$("<option value=" + custId + ">" + custId + "</option>");
							$("#custId").append(child);
						}
					}
				});	
				needCustId=false;
			}
				
		})
		
		
	
	
	
	
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
    <li><a href="#">酒店餐厅管理</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>顾客登记</span></div>
	<button id="btn" name="button">点击添加顾客信息</button>
	<form  id="ff" action="${pageContext.request.contextPath}/reasturantServelet" method="post" target="nb_name">
		<table id="ta">
				<tr>
					<td>顾客姓名：</td><td><input type="text" id="custName" name="custName"></td>
				</tr>
				<tr>
					<td>餐桌编号：</td><td><select id="sel" name="seatId"><option value="--请选择--">--请选择--</option></select></td>
				</tr>
				<tr>
					<td>接待人员编号:</td><td><select id="restReceptId" name="restReceptId"></select></td>
				</tr>
				<tr>
					<td>价格</td><td><input type="text" id="price" name="price"></td>	
				</tr>
				<tr>
					<td>顾客编号:</td><td><select id="custId" name="custId"></select></td>
				</tr>
				<tr>
					<td>说明：</td><td><input type="text" name="remark"></td>
				</tr>
				<tr>
					<td colspan="1" align="center"><input type="submit" id="btn" name="submit" value="添加"></td><td></td>
				</tr>
		
		</table>		
	</form>
	<iframe id="id_frame" name="nb_name" style="display: none;"></iframe>
	</div>
</body>
</html>