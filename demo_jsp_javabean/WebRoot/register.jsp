<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="registerCheck.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    
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
    <form name="form1" action="register_action.jsp" method="post">
    	<table align="center" border="1" style="margin-top:200px;">
    		<tr>
    			<td colspan="2"><h2>注册</h2></td>
    		</tr>
    		<tr>
    			<td>用户名：</td>
    			<td><input type="text" name="username" id="username"/></td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td><input type="password" name="password1" id="password1"/></td>
    		</tr>
    		<tr>
    			<td>确认密码：</td>
    			<td><input type="password" name="password2" id="password2"/></td>
    		</tr>
    		<tr>
    			<td>邮箱：</td>
    			<td><input type="text" id="email"/></td>
    		</tr>
    		<tr>
    			<td><input type="button" value="注册" onclick="valid()"/></td>
    			<td><a href="javascript:history.go(-1)">返回</a></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
