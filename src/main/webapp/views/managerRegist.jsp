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
<script>
   var StyleFile = "theme" + document.cookie.charAt(6) + ".css";
   document.writeln('<link rel="stylesheet" type="text/css" href="css/' + StyleFile + '">');
</script>
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
	      	"managerInfo.username": 
	        {
		    	required: true,
		        minlength: 6,
		        maxlength: 20,
		    },
		    "managerInfo.password": 
		    {
		        required: true,
		        minlength: 6
		    },
		    comfirm_password:
		    {
		        required: true,
		        minlength: 6,
		        equalTo: "#password"
		    },
		    "managerInfo.fullname": 
		    {
		        required: true,
		        minlength: 2
		    },
		  },
		  messages: 
		  {
		    "userInfo.username": 
		    {
		        required: "请输入用户名",
		        minlength: "用户名长度不能小于6个字符",
		        maxlength: "用户名长度不能大于20个字符",
		    },
		    "userInfo.password": 
		    {
		        required: "请输入密码",
		        minlength: "密码长度不能小于6个字符"
		     },
		    comfirm_password:
			{
		    	 required: "请输入新密码",
			     minlength: "密码长度不能小于6个字符",
		    	 equalTo: "两次密码输入不一致"	    	 
			},	
		     "userInfo.fullname": 
		    {
		        required: "请输入姓名",
		        minlength: "密码长度不能小于2个字符"
		     },
		     
		  }
		});	
	  $(".cancel").click(function() {
			validator.resetForm();
		});
	});
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
                	<li><a href="#">通知管理 </a></li>
                	<li><a href="/bscms/views/dailyReport_showAll">数据统计 </a></li>
                	<li class="current"><a href="#">用户管理 </a></li>
                	<li><a href="/bscms/views/page_serviceCentreRegist">服务中心管理</a></li>
                    <li><a href="#">个人设置</a></li>
              	</ul>
         	 </div>
     	</div>
        <div id="top-panel">
            <div id="panel">
                <ul>
					<li><a href="/bscms/views/page_userRegist" class="useradd">新增用户</a></li>
					<li><a href="#" class="useradd">新增管理员</a></li>
					<li><a href="/bscms/views/userInfo_list" class="group">管理用户</a></li>
					<li><a href="#" class="search">查找用户</a></li>					
					<li>当前用户是<s:property value="#session.service_centre_name"/><s:property value="#session.fullname"/><a href="/bscms/views/process_logout">用户注销</a></li>
                </ul>
            </div>
      	</div>
        <div id="wrapper">
            <div id="content">             
                <div id="box">
                	<h3 id="adduser">新增管理员</h3>
                    <form id="form" action="/bscms/views/userInfo_addManager" method="post">
                      <fieldset>
                        <legend>用户信息<s:property value="tip"/></legend>
                        <label>用户名</label> 
                        <input name="managerInfo.username" type="text" tabindex="1" />                    
                        <br />
                        <label>密码</label> 
                        <input id ="password" name="managerInfo.password" type="password" tabindex="1" />                    
                        <br />                      
                        <label>验证密码</label> 
                        <input name="comfirm_password" type="password" tabindex="1" />
                         <br />
                        <label>姓名</label> 
                        <input name="managerInfo.fullname" type="text" tabindex="1" />       
                        <br />
                        <label>隶属</label>
                        <select name="managerInfo.company">
                          <option selected="selected" label="机关" value="jiguan">机关</option> 
                          <option label="中心区" value="centre">中心区</option>                              
                          <option label="南区" value="south">南区</option>  
                          <option label="北区" value="north">北区</option>                         
                          <option label="朝阳" value="chaoyang">朝阳</option>
                          <option label="通顺" value="tongshu">通顺</option>
                          <option label="郊区" value="jiaoqv">郊区</option>
                          <option label="昌延" value="changyan">昌延</option> 
                        </select>             
                      </fieldset>                               
                      <div align="center">
	                  	<input id="button1" type="submit" value="确认"  /> 
	                    <input id="button2" type="reset" value="重置"/>
                      </div>                                   
                    </form>
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
