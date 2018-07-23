<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Register</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="css/regitser_style.css">
<script type="text/javascript" src="js/jquery-1.4.4.js"></script>
<style type="text/css">
      #back{
			text-decoration: none;
			height: 45px;
			width: 123px;         
      }
     

</style>
<script type="text/javascript">	
		$(function(){
			$("#pwd").focus(function(){	
					$("#msg1").html("该栏不许为空");
			});
			
			$("#pwd").blur(function(){
				var value=$("#pwd").val();
				if(value==null){
					$("#msg1").html("该栏不许为空");
				}else{
					$("#msg1").hide();
				}
			});
			
			$("#confirmPwd").focus(function(){
					$("#msg").html("该栏不许为空");
			});
				
			$("#confirmPwd").blur(function(){
				var value=$("#confirmPwd").val();
				var pwd=$("#pwd").val();
				if(value!=pwd){
					$("#msg").html("密码输入不一致！");
				}else{
					$("#msg").hide();
					}
				});
			
		});
</script>  
</head>
<body>
  <div class="container">
  <div class="login">
  	<h1 class="login-heading">
      <strong>Welcome.</strong> Please register.</h1>
      <form method="post" action="registerServlet.do">
        <input type="text" name="username" placeholder="Username" required="required" class="input-txt" />
        <input type="password" name="password" placeholder="Password" required="required" class="input-txt" id="pwd"/><span id="msg1"></span><br>
        <input type="password" name="Confirmpassword" placeholder="ConfirmPassword" required="required"class="input-txt" id="confirmPwd"/><span id="msg"></span>
         <input type="text" name="age" placeholder="Age" required="required" class="input-txt" />
          <div class="login-footer">
             <a href="#" class="lnk">
              <span class="icon icon--min">^v^</span> 
              Please register after repeated confirmation.
            </a>
            <button type="submit" class="btn btn--right">Register in  </button> <br><br>
            <button class="btn btn--right"><a id="back" href="login.jsp">Back</a></button>  
          </div>
      </form>
  </div>
</div> 
    <script  src="js/index.js"></script>
</body>
</html>