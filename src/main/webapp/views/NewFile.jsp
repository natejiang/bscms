<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><font color="blue">分页查询</font></h1><hr>
    
    <table border="1" align="center" bordercolor="yellow" width="50%">
    
        <tr>
            <th>序号</th>
            <th>服务站名称</th>
            <th>所属分公司</th>
            <th>操作</th>
        </tr>
    
    
    <s:iterator value="#request.pageBean.list" id="serviceCentre">
    
        <tr>
            <th><s:property value="#serviceCentre.serviceCentreId"/></th>
            <th><s:property value="#serviceCentre.serviceCentreName"/></th>
            <th><s:property value="#serviceCentre.company"/></th> 
            <th><a href="serviceCentre_deleteById?id=<s:property value="#serviceCentre.serviceCentreId"/>" onclick="javascript: return confirm('真的要删除吗？');">删除</a></th>       
        </tr>
    
    </s:iterator>
    
    </table>
    
    <center>
    
        <font size="5">共<font color="red"><s:property value="#request.pageBean.totalPage"/></font>页 </font>&nbsp;&nbsp;
        <font size="5">共<font color="red"><s:property value="#request.pageBean.allRows"/></font>条记录</font><br><br>
        
        <s:if test="#request.pageBean.currentPage == 1">
            首页&nbsp;&nbsp;&nbsp;上一页
        </s:if>
        
        <s:else>
            <a href="/bscms/views/serviceCentre_list">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/bscms/views/serviceCentre_list?page=<s:property value="#request.pageBean.currentPage - 1"/>">上一页</a>
        </s:else>
        
        <s:if test="#request.pageBean.currentPage != #request.pageBean.totalPage">
            <a href="/bscms/views/serviceCentre_list?page=<s:property value="#request.pageBean.currentPage + 1"/>">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/bscms/views/serviceCentre_list?page=<s:property value="#request.pageBean.totalPage"/>">尾页</a>
        </s:if>
        
        <s:else>
            下一页&nbsp;&nbsp;&nbsp;尾页
        </s:else>
    
    </center><br>
    
    <center>
        
        <form action="/bscms/views/serviceCentre_list" onsubmit="return validate();">
            <font size="4">跳转至</font>
            <input type="text" size="2" name="page">页
            <input type="submit" value="跳转">
        </form>
        
    </center>
</body>
</html>