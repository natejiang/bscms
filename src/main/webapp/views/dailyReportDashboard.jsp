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
                    <li><a href="/bscms/views/page_dailyReportSubmit" class="useradd">提交数据</a></li>
					<li><a href="#" class="search">历史数据</a></li>
					<li>当前用户是<s:property value="#session.serviceCentreName"/><s:property value="#session.fullname"/><a href="/bscms/views/process_logout">logout</a></li>
                </ul>
            </div>
      </div>
        <div id="wrapper">
            <div id="content">
       			<div id="rightnow">
                    <h3 class="reallynow">
                        <span>Yesterday</span>
                        <a href="#" class="add">Add New Product</a>
                        <a href="#" class="app_add">Some Action</a>
                        <br />
                    </h3>
				    <p class="youhave">You have <a href="#">19 new orders</a>, <a href="#">12 new users</a> and <a href="#">5 new reviews</a>, today you made <a href="#">$1523.63 in sales</a> and a total of <strong>$328.24 profit </strong>
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
							<s:iterator value="#newBroadband">
								<td><s:property value="ihomeBroadbandQuantity20"/></td>
                            	<td><s:property value="ihomeBroadbandQuantity30"/></td>
                                <td><s:property value="ihomeBroadbandQuantity50"/></td>
                                <td><s:property value="ihomeBroadbandQuantity100"/></td>
                            </s:iterator>
                            </tr>
                            <tr>
							<s:iterator value="#newBroadbandTotal" id="nBT">
								<td><s:property value="nBT[0]"/></td>
                            	<td><s:property value="nBT[1]"/></td>
                                <td><s:property value="nBT[2]"/></td>
                                <td><s:property value="nBT[3]"/></td>
                            </s:iterator>
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
							<s:iterator value="#newBroadband">
								<td><s:property value="ihomeBroadbandQuantity20"/></td>
                            	<td><s:property value="ihomeBroadbandQuantity30"/></td>
                                <td><s:property value="ihomeBroadbandQuantity50"/></td>
                                <td><s:property value="ihomeBroadbandQuantity100"/></td>
                            </s:iterator>
                            </tr>
                            <tr>
                            <s:iterator value="#newBroadbandTotal">
								<td><s:property value="ihomeBroadbandQuantity20"/></td>
                            	<td><s:property value="ihomeBroadbandQuantity30"/></td>
                                <td><s:property value="ihomeBroadbandQuantity50"/></td>
                                <td><s:property value="ihomeBroadbandQuantity100"/></td>
                            </s:iterator>
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
							<s:iterator value="#renewBroadband">
								<td><s:property value="onlyBroadbandQuantity20"/></td>
                            	<td><s:property value="onlyBroadbandQuantity30"/></td>
                                <td><s:property value="onlyBroadbandQuantity50"/></td>
                                <td><s:property value="onlyBroadbandQuantity100"/></td>
                            </s:iterator>
                            </tr>
                            <tr>
							<s:iterator value="#renewBroadbandTotal">
								<td><s:property value="onlyBroadbandQuantity20"/></td>
                            	<td><s:property value="onlyBroadbandQuantity30"/></td>
                                <td><s:property value="onlyBroadbandQuantity50"/></td>
                                <td><s:property value="onlyBroadbandQuantity100"/></td>
                            </s:iterator>
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
							<s:iterator value="#renewBroadband">
								<td><s:property value="onlyBroadbandQuantity20"/></td>
                            	<td><s:property value="onlyBroadbandQuantity30"/></td>
                                <td><s:property value="onlyBroadbandQuantity50"/></td>
                                <td><s:property value="onlyBroadbandQuantity100"/></td>
                            </s:iterator>
                            </tr>
                            <tr>
							<s:iterator value="#renewBroadbandTotal">
								<td><s:property value="onlyBroadbandQuantity20"/></td>
                            	<td><s:property value="onlyBroadbandQuantity30"/></td>
                                <td><s:property value="onlyBroadbandQuantity50"/></td>
                                <td><s:property value="onlyBroadbandQuantity100"/></td>
                            </s:iterator>
                            </tr>
						</tbody>				 
					</table>            
                  </div>
                  <div id="infobox">
                    <h3>Bestsellers</h3> 
                    <table>
						<thead>
							<tr>
                            	<th>Product Name</th>
                                <th>Price</th>
                                <th>Orders</th>
                            </tr>
						</thead>
						<tbody>
							<tr>
                            	<td><a href="#">Apple iPhone 3G 8GB</a></td>
                                <td>199.00 €</td>
                                <td>24</td>
                            </tr>
							<tr>
                            	<td><a href="#">Fuji FinePix S5800</a></td>
                            	<td>365.24 €</td>
                                <td>19</td>
                            </tr>
							<tr>
                            	<td><a href="#">Canon PIXMA MP140</a></td>
                                <td>59.50 €</td>
                                <td>12</td>
                            </tr>
							<tr>
                            	<td><a href="#">Apple iPhone 3G 16GB</a></td>
                                <td>199.00 €</td>
                                <td>10</td>
                            </tr>
                            <tr>
                            	<td><a href="#">Prenosnik HP 530 1,6GHz</a></td>
                                <td>499.00 €</td>
                                <td>6</td>
                            </tr>
						</tbody>
					</table>
                  </div>
                  <div id="infobox" class="margin-left">
                    <h3>New Customers</h3>
                    <table>
						<thead>
							<tr>
                            	<th>Customer</th>
                                <th>Orders</th>
                                <th>Average</th>
                                <th>Total</th>
                            </tr>
						</thead>
						<tbody>
							<tr>
                            	<td><a href="#">Jennifer Kyrnin</a></td>
                                <td>1</td>
                                <td>5.6€</td>
                                <td>14.95 €</td>
                            </tr>
							<tr>
                            	<td><a href="#">Mark Kyrnin</a></td>
                            	<td>2</td>
                                <td>14.97€</td>
                                <td>34.27 €</td>
                            </tr>
							<tr>
                            	<td><a href="#">Virgílio Cezar</a></td>
                                <td>2</td>
                                <td>15.31€</td>
                                <td>61.39 €</td>
                            </tr>
							<tr>
                            	<td><a href="#">Todd Simonides</a></td>
                                <td>5</td>
                                <td>502.61€</td>
                                <td>1472.56 €</td>
                            </tr>
                            <tr>
                            	<td><a href="#">Carol Elihu</a></td>
                                <td>1</td>
                                <td>5.1€</td>
                                <td>9.95 €</td>
                            </tr>
						</tbody>
					</table>                 
                  </div>
                  <div id="infobox">
                    <h3>Last 5 Reviews</h3> 
                    <table>
						<thead>
							<tr>
                            	<th>Reviewer</th>
                                <th>Product</th>
                                <th>Action</th>
                            </tr>
						</thead>
						<tbody>
							<tr>
                            	<td><a href="#">Jennifer Kyrnin</a></td>
                                <td><a href="#">Apple iPhone 3G 8GB</a></td>
                                <td><a href="#"><img src="img/icons/page_white_link.png" /></a><a href="#"><img src="img/icons/page_white_edit.png" /></a><a href="#"><img src="img/icons/page_white_delete.png" /></a></td>
                            </tr>
							<tr>
                            	<td><a href="#">Mark Kyrnin</a></td>
                            	<td><a href="#">Prenosnik HP 530 1,6GHz</a></td>
                                <td><a href="#"><img src="img/icons/page_white_link.png" /></a><a href="#"><img src="img/icons/page_white_edit.png" /></a><a href="#"><img src="img/icons/page_white_delete.png" /></a></td>
                            </tr>
							<tr>
                            	<td><a href="#">Virgílio Cezar</a></td>
                                <td><a href="#">Fuji FinePix S5800</a></td>
                                <td><a href="#"><img src="img/icons/page_white_link.png" /></a><a href="#"><img src="img/icons/page_white_edit.png" /></a><a href="#"><img src="img/icons/page_white_delete.png" /></a></td>
                            </tr>
							<tr>
                            	<td><a href="#">Todd Simonides</a></td>
                                <td><a href="#">Canon PIXMA MP140</a></td>
                                <td><a href="#"><img src="img/icons/page_white_link.png" /></a><a href="#"><img src="img/icons/page_white_edit.png" /></a><a href="#"><img src="img/icons/page_white_delete.png" /></a></td>
                            </tr>
                            <tr>
                            	<td><a href="#">Carol Elihu</a></td>
                                <td><a href="#">Prenosnik HP 530 1,6GHz</a></td>
                                <td><a href="#"><img src="img/icons/page_white_link.png" /></a><a href="#"><img src="img/icons/page_white_edit.png" /></a><a href="#"><img src="img/icons/page_white_delete.png" /></a></td>
                            </tr>
						</tbody>
					</table>
                  </div>
              </div>
            </div>
         
      </div>
        <div id="footer">
        <div id="credits">
   		Template by <a href="http://www.bloganje.com">Bloganje</a>
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
</html>
