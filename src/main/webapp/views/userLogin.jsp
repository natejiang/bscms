<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>登陆-北京铁通宽带服务中心管理系统</title>
	<link rel="stylesheet" type="text/css" href="css/theme.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
	<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
	<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	// 在键盘按下并释放及提交后验证提交表单
	  $("#form").validate({
		  rules: 
		  {
	      	"managerInfo.username": 
	        {
		    	required: true,
		        minlength: 4
		    },
		    "managerInfo.password": 
		    {
		        required: true,
		        minlength: 4
		    },
		  },
		  messages: 
		  {
		    "managerInfo.username": 
		    {
		        required: "请输入用户名",
		        minlength: "用户名长度不能小于4个字符"
		    },
		    "managerInfo.password": 
		    {
		        required: "请输入密码",
		        minlength: "密码长度不能小于4个字符"
		     },
		  }
		});
	});
</script>
<style>
.error{
	color:red;
}
</style>
</head>
<body>
	<div id="container">	
		<div id="header">		
	    	<h2>北京铁通宽带服务中心管理系统</h2>
	    </div>     
	    <div id="wrapper">
	    	<div id="content">
	    		<div id="box">
				    <form id="form" action="/bscms/views/process_login" method="post">
				    	<fieldset>      
							<label>用户</label>
						    <input id="username" type="text" name="managerInfo.username" />	
						    <br />	    						    
						    <label>密码</label>
						    <input id="password" name="managerInfo.password" type="password"/>						 					       
						    <div>
						    	<input id="button1" type="submit" value="登陆" />
						    </div> 
					    </fieldset>
				    </form>
				    <label><s:fielderror/></label>
				</div>	        
			</div>
	    </div>
	</div>
</body>
</html>