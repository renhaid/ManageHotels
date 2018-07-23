<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>roomInfo</title>
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
	 // 页面加载后，对datagrid 进行设置
   $("#grid").datagrid({
       // 设置表格一些属性 
       url : "${pageContext.request.contextPath}/selectGaraWaiter" , 
       columns : [[ // 二维数组 支持 多级表头， 每一个数组 就是表头一行
           {
               field: "id", // 用于和服务器返回json中字段对应 
               title: "编号", // 列标题显示内容， <th> 
               width: 100,
               hidden:true
           },
           {
               field: "garaWaiterId", // 用于和服务器返回json中字段对应 
               title: "人员编号", // 列标题显示内容， <th> 
               width: 100
           },
           {
               field: "waiterName", // 用于和服务器返回json中字段对应 
               title: "服务人员姓名", // 列标题显示内容， <th> 
               width: 100
           },
           {
               field: "garaId", // 用于和服务器返回json中字段对应 
               title: "车位编号", // 列标题显示内容， <th> 
               width: 100
           },
           {
               field: "status", // 用于和服务器返回json中字段对应 
               title: "人员状态", // 列标题显示内容， <th> 
               width: 100
           },
           {
               field: "remark", // 用于和服务器返回json中字段对应 
               title: "备注", // 列标题显示内容， <th> 
               width: 100
           },
           {
           field:'xxx',title:'操作',width:100,algin:'center',formatter:function(value,row,index){
       		var id=row.id;
       		return "<a class='easyui-linkbutton' href='javascript:del("+id+")'>删除</a>";
       	} 
           }
       ]],
      // 加载json数据，显示表格数据 
       pagination : true , // 分页工具条
       //选择当前页
       pageNumber : 1,
       //页面显示几个
       pageSize : 3,
       //可选页面显示几个
       pageList : [3,6,9],
       width:750,
	   height:300,
       rownumbers:true,
       singleSelect:true,
       toolbar : [  // 一维数组，定义按钮 
           {
               id : "saveBtn",
               text : "保存",
               iconCls : "icon-save",
               handler : function(){
                   alert("保存...");
               }
           }
       ]
   });
   $('#dg').datagrid('reload');
   
   //表单验证
  	 $.extend($.fn.validatebox.defaults.rules, {    
  		roomType: {    
        	validator: function(value,param){    
            	var reg=/^[0-9]{4}$/;  
            	return reg.test(value);
       	 },    
      	  message: '房间号输入格式有误！'   
   	 },
   		waiterNameType: {    
    		validator: function(value,param){    
        	return value.length>0&&value.length<=4;
   	 	},    
  	 	 message: '姓名字符不超过四个字'   
	 	}
   	 
	});  
	
  			$('#garaId').textbox({    
				prompt:'车位编号',    
			   	required:true,
			    validType:'roomType'
			})
			$('#waiterName').textbox({    
			    required: true,    // 不能为空
			    validType: 'waiterNameType'   
			}); 
			$('#garaWaiterId').textbox({    
			    required: true,    // 不能为空
			}); 
  			
  	//添加的保存点击事件
  	$("#btn").click(function(){
  		$.ajax({
  			url:"${pageContext.request.contextPath}/addGaraWaiter",
  			type:"post",
  			data:{"garaWaiterId":$("#garaWaiterId").val(),
  					"waiterName":$("#waiterName").val(),
  					"garaId":$("#garaId").val(),
  					"status":$("#status").val(),
  					"remark":$("#remark").val()	
  			},
  			dataType:"json",
  			success:function(data){
  				if(data!=null){
  					alert(data.message);
  					$('#grid').datagrid('reload');
  				}else{
  					alert("添加失败");
  				}
  				
  			}
  			
  			
  		});
  		
  	});
  		
  	
 			
   
});

function del(id){
	$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
	    if (r){    
	        $.ajax({
	        	url:"${pageContext.request.contextPath}/delGaraWaiter",
	        	type:"post",
	        	data:{"id":id},
	        	dataType:"json",
	        	success:function(data){
	        		$('#grid').datagrid('reload');
	        		$.messager.alert('提示',data.message);
	        	}
	        })   
	    }    
	});
	
}
</script>
<style type="text/css">
	#table{
		width:750px;
		height:300px;
		border: 1px solider red;
		background-color: #4A8AF4;
	}
		

</style>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">酒店人事管理</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>车库人员管理</span></div>
    	<!--数据表格-->
         <table id="grid"></table>
         <font size="4">添加人员</font>
         <br></br>
         <form 	id="ff" action="addRoomServlet.do" method="post">
         	<table id="table" border="1">
         		<tr><td>车库人员编号:</td><td><input type="text" id="garaWaiterId" name="garaWaiterId"></td></tr>
         		<tr><td>车库人员姓名:</td><td><input type="text" id="waiterName" name="waiterName"></td></tr>
         		<tr><td>车位编号：</td><td><input type="text"  id="garaId" name="garaId"><td></tr>
         		<tr><td>状态：</td><td><select id="status" name="status">
         								<option value="空闲">空闲</option>
         								<option value="工作">工作</option>       		
         								</select></td></tr>
         		<tr><td>说明：</td><td><input type="text" id="remark" name="remark"></td></tr>
         		<tr><td colspan="1" align="center"><input type="button" id="btn" name="submit" value="添加"></td><td></td></tr>
         	  </table>      
         </form>
     </div>
    
</body>
</html>