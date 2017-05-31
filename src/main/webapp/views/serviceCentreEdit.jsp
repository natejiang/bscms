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
			"serviceCentre.serviceCentreName": 
	        {
		    	required: true,
		        minlength: 4
		    },
		  },
		  messages: 
		  {
			"serviceCentre.serviceCentreName": 
		    {
		        required: "请输入服务站名",
		        minlength: "长度不能小于4个字符"
		    },
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
                	<li><a href="#">通知管理 </a></li>
                	<li><a href="/bscms/views/dailyReport_showAll">数据统计 </a></li>
                	<li><a href="/bscms/views/page_userRegist">用户管理 </a></li>
                	<li class="current"><a href="#">服务中心管理 </a></li>
                    <li><a href="#">个人设置</a></li>
              	</ul>
         	 </div>
     	</div>
        <div id="top-panel">
            <div id="panel">
                <ul>
					<li><a href="#" class="pagenew">新增</a></li>
					<li><a href="/bscms/views/serviceCentre_list" class="manage_page">管理</a></li>
					<li><a href="#" class="search">查找</a></li>
					<li>当前用户是<s:property value="#session.serviceCentreName"/><s:property value="#session.fullname"/><a href="/bscms/views/process_logout">用户注销</a></li>
                </ul>
            </div>
      	</div>
        <div id="wrapper">
            <div id="content">             
                <div id="box">
                	<h3 id="adduser">新增服务中心</h3>
                    <form id="form" action="/bscms/views/serviceCentre_add" method="post">
                      <fieldset>
                        <legend>服务中心信息<s:property value="tip"/></legend>
                        <label>名称</label> 
                        <input name="serviceCentre.serviceCentreName" type="text" tabindex="1" />                    
                        <br />
                        <label>地址</label> 
                        <input name="#" type="text" tabindex="1" />                    
                        <br />
                        <label>隶属</label>
                        <select name="serviceCentre.company">
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
