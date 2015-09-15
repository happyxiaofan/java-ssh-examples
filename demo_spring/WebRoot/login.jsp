<%@ taglib prefix="spring" uri="/WEB-INF/spring.tld"%>
<%@ taglib prefix="form" uri="/WEB-INF/spring-form.tld"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Login Window</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form:form action="login.do" method="post">
    	<table align="center" border=1 style="margin-top:200px;">
    		<tr>
    			<td>用户名：</td>
    			<td>
    				<form:input path="username" /> <font color="red"><form:errors path="username" /></font>
    			</td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td>
    				<form:input path="password" /> <font color="red"><form:errors path="password" /></font>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit"/></td>
    		</tr>
    	</table>
    </form:form>
  </body>
</html>
