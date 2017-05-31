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
<style>
.error{
	color:red;
}
</style>
<script>
   var StyleFile = "theme" + document.cookie.charAt(6) + ".css";
   document.writeln('<link rel="stylesheet" type="text/css" href="css/' + StyleFile + '">');
</script>
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
					<li><a href="/bscms/views/page_managerRegist" class="useradd">新增管理员</a></li>
					<li><a href="#" class="group">管理用户</a></li>
					<li><a href="#" class="search">查找用户</a></li>					
					<li>当前用户是<s:property value="#session.serviceCentreName"/><s:property value="#session.fullname"/><a href="/bscms/views/process_logout">用户注销</a></li>
                </ul>
            </div>
      	</div>
        <div id="wrapper">
            <div id="content">             
                <div id="box">
                	<h3 id="adduser">账号管理<s:property value="tip"/></h3>
					<table width="100%">
						<thead>
							<tr>
                            	<th>序号</th>
					            <th>用户名称</th>
					            <th>全名</th>
					            <th>归属</th>
					            <th>操作</th>
                            </tr>
						</thead>
						<tbody>
							 <s:iterator value="#request.pageBean.list" id="userInfo">
    
						        <tr>
						            <th><s:property value="#userInfo.userId"/></th>
						            <th><s:property value="#userInfo.username"/></th>
						            <th><s:property value="#userInfo.fullname"/></th> 
						            <th><s:property value="#userInfo.serviceCentre.serviceCentreName"/></th> 
						            <th><a href="userInfo_deleteById?id=<s:property value="#userInfo.userId"/>" onclick="javascript: return confirm('真的要删除吗？');">删除</a></th>       
						        </tr>
						    
						    </s:iterator>
						</tbody>
					</table>  
					<div align="center" id="pager">
						共<font color="red"><s:property value="#request.pageBean.totalPage"/></font>页&nbsp;&nbsp;&nbsp;
				        共<font color="red"><s:property value="#request.pageBean.allRow"/></font>条记录&nbsp;&nbsp;&nbsp;
				        
				        <s:if test="#request.pageBean.currentPage == 1">
				            首页&nbsp;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;
				        </s:if>
				        
				        <s:else>
				            <a href="/bscms/views/userInfo_list">首页</a>
				            &nbsp;&nbsp;&nbsp;
				            <a href="/bscms/views/userInfo_list?page=<s:property value="#request.pageBean.currentPage - 1"/>">上一页</a>
				            &nbsp;&nbsp;&nbsp;
				        </s:else>
				        
				        <s:if test="#request.pageBean.currentPage != #request.pageBean.totalPage">
				            <a href="/bscms/views/userInfo_list?page=<s:property value="#request.pageBean.currentPage + 1"/>">下一页</a>
				            &nbsp;&nbsp;&nbsp;
				            <a href="/bscms/views/userInfo_list?page=<s:property value="#request.pageBean.totalPage"/>">尾页</a>
				        </s:if>				        
				        <s:else>
				            下一页&nbsp;&nbsp;&nbsp;尾页
				        </s:else>				       
					</div>       
					<div align="center">
				        <form id="form" action="/bscms/views/userInfo_list" onsubmit="return validate();">
					            跳转至
					            <input type="text" size="2" name="page">页
					            <input type="submit" value="跳转">
			        	</form>
			        </div>  
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
