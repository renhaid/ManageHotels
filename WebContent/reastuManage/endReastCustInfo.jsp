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
       url : "${pageContext.request.contextPath}/selectReastCustInfo" , 
       columns : [[ // 二维数组 支持 多级表头， 每一个数组 就是表头一行
           {
               field: "id", // 用于和服务器返回json中字段对应 
               title: "编号", // 列标题显示内容， <th> 
               width: 100,
               hidden:true
           },
           {
               field: "seatId", // 用于和服务器返回json中字段对应 
               title: "座位编号", // 列标题显示内容， <th> 
               width: 100
           },
           {
               field: "custName", // 用于和服务器返回json中字段对应 
               title: "顾客姓名", // 列标题显示内容， <th> 
               width: 100
           },
           {
               field: "restReceptId", // 用于和服务器返回json中字段对应 
               title: "接待人员编号", // 列标题显示内容， <th> 
               width: 100
           },
           {
               field: "custId", // 用于和服务器返回json中字段对应 
               title: "客户编号", // 列标题显示内容， <th> 
               width: 100
           },
           {
               field: "price", // 用于和服务器返回json中字段对应 
               title: "消费价格", // 列标题显示内容， <th> 
               width: 100
           },
           {
               field: "remark", // 用于和服务器返回json中字段对应 
               title: "说明", // 列标题显示内容， <th> 
               width: 100
           },
           {
           field:'xxx',title:'操作',width:100,algin:'center',formatter:function(value,row,index){
       		var id=row.id;
       		return "<a class='easyui-linkbutton' href='javascript:del("+id+")'>结束用餐</a>";
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
     
});

function del(id){
	$.messager.confirm('确认','您确认想要结束用餐吗？',function(r){    
	    if (r){    
	        $.ajax({
	        	url:"${pageContext.request.contextPath}/endServlet",
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
	$('#grid').datagrid('reload');
	
}
</script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">酒店餐厅管理</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>结束用餐</span></div>
    	<!--数据表格-->
         <table id="grid"></table>
         <br></br>
     </div>
    
      

</body>
</html>