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
</head>

<body>
	<div id="container">	
		<div id="header">		
	    	<h2>北京铁通宽带服务中心管理系统</h2>
	    </div>     
	    <div id="wrapper">
	    	<div id="content">
	    		<div id="box">
				    <form action="/bscms/views/process_login" method="post">
				    	<fieldset>      
							<label>用户</label>
						    <input type="text" name="userInfo.username" />					    						    
						    <label>密码</label>
						    <input type="text" name="userInfo.password" />						       
						    <div>
						    	<input type="submit" value="登陆" />
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