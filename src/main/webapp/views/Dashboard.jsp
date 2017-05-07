<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<s:debug/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>日报仪表 - 北京铁通宽带服务中心管理系统</title>
<link rel="stylesheet" type="text/css" href="css/theme.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
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
                	<li class="current"><a href="#">数据统计 </a></li>
                	<li><a href="/bscms/views/page_userRegist">用户管理 </a></li>
                	<li><a href="/bscms/views/page_serviceCentreRegist">服务中心管理</a></li>
                    <li><a href="#">个人设置</a></li>
              	</ul>
         	 </div>
      </div>
        <div id="top-panel">
            <div id="panel">
                <ul>
                    <li><a href="/bscms/views/dailyReport_showAll" class="search">全部数据</a></li>
					<li><a href="/bscms/views/dailyReport_showCompany?company=centre" class="">中心区</a></li>
					<li><a href="/bscms/views/dailyReport_showCompany?company=south" class="">南区</a></li>
					<li><a href="/bscms/views/dailyReport_showCompany?company=north" class="">北区</a></li>
					<li><a href="/bscms/views/dailyReport_showCompany?company=chaoyang" class="">朝阳</a></li>
					<li><a href="/bscms/views/dailyReport_showCompany?company=tongshun" class="">通顺</a></li>
					<li><a href="/bscms/views/dailyReport_showCompany?company=jiaoqv" class="">郊区</a></li>
					<li><a href="/bscms/views/dailyReport_showCompany?company=changyan" class="">昌延</a></li>
					<li>当前用户是<s:property value="#session.fullname"/><a href="/bscms/views/process_logout">logout</a></li>
                </ul>
            </div>
      </div>
        <div id="wrapper">
            <div id="content">
       			<div id="rightnow">
                    <h3 class="reallynow">
                        <span>昨日数据</span>
                        <a href="#" class="add"></a>
                        <a href="#" class="app_add"></a>
                        <br />
                    </h3>
				    <p class="youhave">今天<a href="#">19个服务站</a>未提交数据 
                    </p>
			  </div>
              <div id="infowrap">  
                  <div id="infobox">
                    <h3>宽带新增(昨日/累计)</h3>
                    <table>
						<thead>
							<tr>
                            	<th>爱家(20M)</th>
                                <th>爱家(30M)</th>
                                <th>爱家(50M)</th>
                                <th>爱家(100M)</th>
                            </tr>
						</thead>
						<tbody>
							<tr>
							<s:subset source="#sumNewBroadbandYesterday" start="0" count="4">
							<s:iterator>
								<td><s:property/></td>   
                            </s:iterator>
                            </s:subset>
                            </tr>
                            <tr>
                            <s:subset source="#sumNewBroadbandMonth" start="0" count="4">
							<s:iterator>
								<td><s:property/></td>   
                            </s:iterator>
                            </s:subset>
                            </tr>
						</tbody>
					</table>
					<table>
						<thead>
							<tr>
                                <th>裸宽(20M)</th>
                                <th>裸宽(30M)</th>
                                <th>裸宽(50M)</th>
                                <th>裸宽(100M)</th>
                            </tr>
						</thead>
						<tbody>
							<tr>
							<s:subset source="#sumNewBroadbandYesterday" start="4" count="4">
							<s:iterator>
								<td><s:property/></td>   
                            </s:iterator>
                            </s:subset>
                            </tr>
                            <tr>
                            <s:subset source="#sumNewBroadbandMonth" start="4" count="4">
							<s:iterator>
								<td><s:property/></td>   
                            </s:iterator>
                            </s:subset>
                            </tr>
						</tbody>
					 
					</table>            
                  </div>
                  <div id="infobox" class="margin-left">
                    <h3>宽带续费(昨日/累计)</h3>
                    <table>
						<thead>
							<tr>
                            	<th>爱家(20M)</th>
                                <th>爱家(30M)</th>
                                <th>爱家(50M)</th>
                                <th>爱家(100M)</th>
                            </tr>
						</thead>
						<tbody>
							<tr>
							<s:subset source="#sumRenewBroadbandYesterday" start="0" count="4">
							<s:iterator>
								<td><s:property/></td>   
                            </s:iterator>
                            </s:subset>
                            </tr>
                            <tr>
							<s:subset source="#sumRenewBroadbandMonth" start="0" count="4">
							<s:iterator>
								<td><s:property/></td>   
                            </s:iterator>
                            </s:subset>
                            </tr>
						</tbody>
					</table>
					<table>
						<thead>
							<tr>
                                <th>裸宽(20M)</th>
                                <th>裸宽(30M)</th>
                                <th>裸宽(50M)</th>
                                <th>裸宽(100M)</th>
                            </tr>
						</thead>
						<tbody>
							<tr>
							<s:subset source="#sumRenewBroadbandYesterday" start="4" count="4">
							<s:iterator>
								<td><s:property/></td>   
                            </s:iterator>
                            </s:subset>
                            </tr>
                            <tr>
							<s:subset source="#sumRenewBroadbandMonth" start="4" count="4">
							<s:iterator>
								<td><s:property/></td>   
                            </s:iterator>
                            </s:subset>
                            </tr>
						</tbody>				 
					</table>            
                  </div>
                  <div id="infobox">
                    <h3>客流量(昨日/累计)</h3>
                    <table>
						<thead>
							<tr>
                            	<th>客流量</th>
                            </tr>
						</thead>
						<tbody>
							<tr>
							<s:iterator value="#sumCustomerYesterday" id="name">					
								<td><s:property value="name"/></td>   
							</s:iterator>
                            </tr>
                            <tr>						
							<s:iterator value="#sumCustomerMonth" id="name">					
								<td><s:property value="name"/></td>   
							</s:iterator> 
                            </tr>
						</tbody>
					</table>				         
                  </div>
                  <div id="infobox" class="margin-left">
                    <h3>上门工作量(昨日/累计)</h3> 
                    <table>
						<thead>
							<tr>
                            	<th>装机</th>
                                <th>维修</th>
                            </tr>
						</thead>
						<tbody>
							<tr>
							<s:subset source="#sumDoorToDoorYesterday" start="0" count="2">
							<s:iterator>
								<td><s:property/></td>   
                            </s:iterator>
                            </s:subset>
                            </tr>
                            <tr>
							<s:subset source="#sumDoorToDoorMonth" start="0" count="2">
							<s:iterator>
								<td><s:property/></td>   
                            </s:iterator>
                            </s:subset>
                            </tr>
						</tbody>
					</table>					
                  </div>
                  <div id="infobox">
                    <h3>移动产品(昨日/累计)</h3> 
                    <table>
						<thead>
							<tr>
                            	<th>移动号卡</th>
                                <th>移动终端</th>
                                <th>移动电视</th>
                            </tr>
						</thead>
						<tbody>
							<tr>
							<s:subset source="#sumMobileProductYesterday" start="0" count="3">
							<s:iterator>
								<td><s:property/></td>   
                            </s:iterator>
                            </s:subset>
                            </tr>
                            <tr>
							<s:subset source="#sumMobileProductMonth" start="0" count="3">
							<s:iterator>
								<td><s:property/></td>   
                            </s:iterator>
                            </s:subset>
                            </tr>
						</tbody>
					</table>					
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
                <li><a href="javascript: document.cookie='theme=5'; window.location.reload();" title="Mix" id="defswitch">m</a></li>
            </ul>
        </div><br />
        </div>
</div>
</body>
</s:if>
</html>
