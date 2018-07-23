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
		    idCardType:{    
		        validator: function(value,param){    
		        	var reg=/^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
		            return reg.test(value);    
		        },    
		        message: '身份证格式有误！'   
		    }
		});
		
		
		$('#stayId').textbox({    
		    required: true,    // 不能为空  
		})
		$('#cust').textbox({
			required:true,
			validType: 'custType'
		})
		$('#idCard').textbox({
			required:true,
			validType:'idCardType'
		})
		$('#checkDate').textbox({    
		    required: true,    // 不能为空  
		})
		$('#custId').textbox({    
		    required: true,    // 不能为空  
		})
		$('#checkDate').datebox({    
    		required:true   
		});  
		
		
	//点击事件
		//click点击事件
		$('#btn').click(function(){
			
			$.ajax({
				url:"${pageContext.request.contextPath}/queryServlet.do",
				type:"post",
				data:{"status":"空房"},
				dataType:"json",
				success:function(data){
					for(var i=0;i<data.length;i++){
						var roomId=data[i];
						var str="<option value=" + roomId + ">" + roomId + "</option>";
						$("#sel").append(str);
					}
				}
			});	
			
			$("#ff").show();
			var randnum=rand(1000,9999);
			$('#stayId').textbox('setValue',randnum);
			var randnumn=rand(1000,9999); 
			$('#custId').textbox('setValue',randnumn);
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
    <li><a href="#">酒店客房管理</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>入住手续</span></div>
	<button id="btn" name="button">点击添加入住信息</button>
	<form  id="ff" action="${pageContext.request.contextPath}/stayInfoServlet.do" method="post" target="nb_name">
		<table id="ta">
				<tr>
					<td>住房编号：</td><td><input type="text" id="stayId" readonly="readonly" name="stayId"></td>
				</tr>
				<tr>
					<td>房间编号：</td><td><select id="sel" name="roomId"><option value="--请选择--">--请选择--</option></select></td>
				</tr>
				<tr>
					<td>顾客姓名:</td><td><input type="text" id="cust" name="custName"></td>
				</tr>
				<tr>
					<td>身份证号:</td><td><input type="text" id="idCard" name="idCard"></td>
				</tr>
				<tr>
					<td>登记日期:</td><td><input type="text"  id="checkDate" name="checkDate"></td>
				</tr>
				<tr>
					<td>酒店操作员：</td><td><input type="text" readonly="readonly" name="opreationer" value="${user.username}"></td>
				</tr>
				<tr>
					<td>顾客编号：</td><td><input type="text" id="custId" readonly="readonly" name="custId"></td>
				</tr>
				<tr>
					<td>说明：</td><td><input type="text" name="remark" value="在住"></td>
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