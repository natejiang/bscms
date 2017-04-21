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
<!--[if IE]>
<link rel="stylesheet" type="text/css" href="css/ie-sucks.css" />
<![endif]-->
<s:debug/>
</head>
<s:if test="#session.username!=''">
<body>

	<div id="container">
    	<div id="header">
        	<h2>北京铁通宽带服务中心管理系统</h2>
    		<div id="topmenu">
            	<ul>
                	<li><a href="#">店面通知</a></li>
                	<li class="current"><a href="#">数据统计</a></li>
                    <li><a href="#">个人设置</a></li>
              	</ul>
         	 </div>
     	</div>
        <div id="top-panel">
            <div id="panel">
                <ul>
					<li><a href="/bscms/views/dailyReport_dailyReportSubmit" class="useradd">提交数据</a></li>
					<li><a href="/bscms/views/dailyReport_show" class="search">历史数据</a></li>
					<li>当前用户是<s:property value="#session.serviceCentreName"/><s:property value="#session.fullname"/><a href="/bscms/views/process_logout">logout</a></li>
                </ul>
            </div>
      	</div>
        <div id="wrapper">
            <div id="content">             
                <div id="box">
                	<h3 id="adduser">当日数据</h3>
                    <form id="form" action="/bscms/views/dailyReport_add" method="post">
                      <fieldset>
                        <legend>宽带新装</legend>
                        <label>(20M)爱家</label> 
                        <input name="newBroadband.ihomeBroadbandQuantity20" type="text" tabindex="1" />                    
                        <br />
                        <label>(30M)爱家</label> 
                        <input name="newBroadband.ihomeBroadbandQuantity30" type="text" tabindex="1" />                    
                        <br />
                        <label>(50M)爱家</label> 
                        <input name="newBroadband.ihomeBroadbandQuantity50" type="text" tabindex="1" />                    
                        <br />
                        <label>(100M)爱家</label> 
                        <input name="newBroadband.ihomeBroadbandQuantity100" type="text" tabindex="1" />                               
                        <br />
                        <label>(20M)裸宽</label> 
                        <input name="newBroadband.onlyBroadbandQuantity20" type="text" tabindex="1" />                    
                        <br />
                        <label>(30M)裸宽</label> 
                        <input name="newBroadband.onlyBroadbandQuantity30" type="text" tabindex="1" />                    
                        <br />
                        <label>(50M)裸宽</label> 
                        <input name="newBroadband.onlyBroadbandQuantity50" type="text" tabindex="1" />                    
                        <br />
                        <label>(100M)裸宽</label> 
                        <input name="newBroadband.onlyBroadbandQuantity100" type="text" tabindex="1" />                               
                      </fieldset>
                      <fieldset>
                        <legend>宽带续费</legend>
                        <label>(20M)爱家</label> 
                        <input name="renewBroadband.ihomeBroadbandQuantity20" type="text" tabindex="1" />                    
                        <br />
                        <label>(30M)爱家</label> 
                        <input name="renewBroadband.ihomeBroadbandQuantity30" type="text" tabindex="1" />                    
                        <br />
                        <label>(50M)爱家</label> 
                        <input name="renewBroadband.ihomeBroadbandQuantity50" type="text" tabindex="1" />                    
                        <br />
                        <label>(100M)爱家</label> 
                        <input name="renewBroadband.ihomeBroadbandQuantity100" type="text" tabindex="1" />                                  
                        <br />
                        <label>(20M)裸宽</label> 
                        <input name="renewBroadband.onlyBroadbandQuantity20" type="text" tabindex="1" />                    
                        <br />
                        <label>(30M)裸宽</label> 
                        <input name="renewBroadband.onlyBroadbandQuantity30" type="text" tabindex="1" />                    
                        <br />
                        <label>(50M)裸宽</label> 
                        <input name="renewBroadband.onlyBroadbandQuantity50" type="text" tabindex="1" />                    
                        <br />
                        <label>(100M)裸宽</label> 
                        <input name="renewBroadband.onlyBroadbandQuantity100"type="text" tabindex="1" />                               
                      </fieldset>  
					  <fieldset>
					  	<legend>入户服务</legend>
                        <label>入户装机</label> 
                        <input name="doorToDoor.installedQuantity" type="text" tabindex="1" />                    
                        <br />
                        <label>入户维修</label> 
                        <input name="doorToDoor.repairedQuantity" type="text" tabindex="1" />                               
                        <br />
                      </fieldset>  
                      <fieldset>
                        <legend>其它产品</legend>
                        <label>移动号卡</label> 
                        <input name="mobileProduct.simQuantity" type="text" tabindex="1" />                               
                        <br />
                        <label>终端</label> 
                        <input name="mobileProduct.televisionQuantity" type="text" tabindex="1" />                    
                        <br />
                        <label>电视</label> 
                        <input name="mobileProduct.terminalQuantity" type="text" tabindex="1" />                               
                      </fieldset>
                      <fieldset> 
                        <legend>店面客流</legend>
                        <label>客流量</label> 
                        <input name="customer.customerQuantity" type="text" tabindex="1" />                                         
                      </fieldset>                         
                      <div align="center">
	                  	<input id="button1" type="submit" value="提交 "  /> 
	                    <input id="button2" type="submit" value="重置"/>
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
        </div>
	  </div>
</div>
</body>
</s:if>
</html>
