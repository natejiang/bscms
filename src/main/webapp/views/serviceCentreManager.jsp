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
					<li><a href="/bscms/views/page_serviceCentreRegist" class="pagenew">新增</a></li>
					<li><a href="#" class="manage_page">管理</a></li>
					<li><a href="#" class="search">查找</a></li>
					<li>当前用户是<s:property value="#session.serviceCentreName"/><s:property value="#session.fullname"/><a href="/bscms/views/process_logout">用户注销</a></li>
                </ul>
            </div>
      	</div>
        <div id="wrapper">
            <div id="content">             
                <div id="box">
                	<h3>管理服务中心<s:property value="tip"/></h3>  
                	<table width="100%">
						<thead>
							<tr>
                            	<th>序号</th>
					            <th>服务站名称</th>
					            <th>所属分公司</th>
					            <th>操作</th>
                            </tr>
						</thead>
						<tbody>
							 <s:iterator value="#request.pageBean.list" id="serviceCentre">
    
						        <tr>
						            <th><s:property value="#serviceCentre.serviceCentreId"/></th>
						            <th><s:property value="#serviceCentre.serviceCentreName"/></th>
						            <th><s:property value="#serviceCentre.company"/></th> 
						            <th><a href="serviceCentre_deleteById?id=<s:property value="#serviceCentre.serviceCentreId"/>" onclick="javascript: return confirm('真的要删除吗？');">删除</a></th>       
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
				            <a href="/bscms/views/serviceCentre_list">首页</a>
				            &nbsp;&nbsp;&nbsp;
				            <a href="/bscms/views/serviceCentre_list?page=<s:property value="#request.pageBean.currentPage - 1"/>">上一页</a>
				            &nbsp;&nbsp;&nbsp;
				        </s:else>
				        
				        <s:if test="#request.pageBean.currentPage != #request.pageBean.totalPage">
				            <a href="/bscms/views/serviceCentre_list?page=<s:property value="#request.pageBean.currentPage + 1"/>">下一页</a>
				            &nbsp;&nbsp;&nbsp;
				            <a href="/bscms/views/serviceCentre_list?page=<s:property value="#request.pageBean.totalPage"/>">尾页</a>
				        </s:if>				        
				        <s:else>
				            下一页&nbsp;&nbsp;&nbsp;尾页
				        </s:else>				       
					</div>       
					<div align="center">
				        <form id="form" action="/bscms/views/serviceCentre_list" onsubmit="return validate();">
					            跳转至
					            <input type="text" size="2" name="page">页
					            <input type="submit" value="跳转">
			        	</form>
			        </div>        
                </div>
            </div>  
      </div>
      <br />
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
