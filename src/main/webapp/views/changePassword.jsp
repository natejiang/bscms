<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>店面管理 - 北京铁通宽带服务中心管理系统 </title>
<link rel="stylesheet" type="text/css" href="css/theme.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	// 在键盘按下并释放及提交后验证提交表单
	  $("#form").validate({		
		  errorElement: "span",
		  rules: 
		  {
		    "userInfo.password": 
		    {
		        required: true,
		        minlength: 6
		    },
		    newPassword: 
		    {
		        required: true,
		        minlength: 6
		    },
		    comfirm_password:
		    {
		        required: true,
		        minlength: 6,
		        equalTo: "#newPassword"
		    },
		    	
		  },
		  messages: 
		  {
		    "userInfo.password": 
		    {
		        required: "请输入原密码",
		        minlength: "密码长度不能小于6个字符"
		    },
		     newPassword: 
		    {
		        required: "请输入新密码",
		        minlength: "密码长度不能小于6个字符"
		    },
		    comfirm_password:
		    {
		    	 required: "请输入新密码",
			     minlength: "密码长度不能小于6个字符",
		    	 equalTo: "两次密码输入不一致"	    	 
		    }		     
		  }
		});
	
	  $(".cancel").click(function() {
			validator.resetForm();
		});
	});
</script>
<script>
   var StyleFile = "theme" + document.cookie.charAt(6) + ".css";
   document.writeln('<link rel="stylesheet" type="text/css" href="css/' + StyleFile + '">');
</script>
<style>
.error{
	color:red;
}
</style>
<!--[if IE]>
<link rel="stylesheet" type="text/css" href="css/ie-sucks.css" />
<![endif]-->
</head>
<s:if test="#session.username!=''">
<body>

	<div id="container">
    	<div id="header">
        	<h2>北京铁通宽带服务中心管理系统</h2>
    		<div id="topmenu">
            	<ul>
                	<li><a href="#">店面通知</a></li>
                	<li><a href="/bscms/views/page_dailyReportSubmit">数据统计</a></li>
                    <li class="current"><a href="#">个人设置</a></li>
              	</ul>
         	 </div>
     	</div>
        <div id="top-panel">
            <div id="panel">
                <ul>
					<li><a href="#" class="user">当前用户：<s:property value="#session.serviceCentre.serviceCentreName"/><s:property value="#session.fullname"/></a><a href="/bscms/views/process_logout">注销用户</a></li>
                </ul>
            </div>
      	</div>
        <div id="wrapper">
            <div id="content">             
                <div id="box">
                	<h3 id="adduser">账户管理</h3>
                    <form id="form" action="/bscms/views/userInfo_changePassword" method="post">
                      <fieldset>
                        <legend>修改密码<s:property value="tip"/></legend>
                        <input type="hidden" name="userInfo.username" value="<s:property value="#session.username"/>">
                        <label>原密码</label> 
                        <input name="userInfo.password" type="password" tabindex="1" />                    
                        <br />
                        <label>新密码</label> 
                        <input id="newPassword" name="newPassword" type="password" tabindex="1" />                    
                        <br />
                        <label>验证新密码</label> 
                        <input name="comfirm_password" type="password" tabindex="1" />                                                         
                      </fieldset>                                             
                      <div align="center">
	                  	<input id="button1" type="submit" value="提交 " /> 
	                    <input id="button2" type="submit" value="重置"/>
                      </div>                                   
                    </form>
                    <label><s:fielderror/></label>
                </div>
            </div>          
      </div>
      <div id="footer">
        <div id="credits">
   		Copyright © 2017 <a href="#">CMTT</a>
        </div>
        <div id="styleswitcher">
            <ul>
                <li><a href="javascript: document.cookie='theme='; window.location.reload();" title="Default" id="defswitch">d</a></li>
                <li><a href="javascript: document.cookie='theme=1'; window.location.reload();" title="Blue" id="blueswitch">b</a></li>
                <li><a href="javascript: document.cookie='theme=2'; window.location.reload();" title="Green" id="greenswitch">g</a></li>
                <li><a href="javascript: document.cookie='theme=3'; window.location.reload();" title="Brown" id="brownswitch">b</a></li>
                <li><a href="javascript: document.cookie='theme=4'; window.location.reload();" title="Mix" id="mixswitch">m</a></li>
            </ul>
        </div><br />
	  </div>
</div>
</body>
</s:if>
</html>
