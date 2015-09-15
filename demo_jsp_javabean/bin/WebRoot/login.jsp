<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.rhwayfun.ssh.listener.CounterListener"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="loginCheck.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
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
  当前在线用户：
  <%
  int count = CounterListener.getCount();
  out.print(count);
  %>
    <form name="form1" action = "login_action.jsp" method="post">
    	<table align="center" border="1" style="margin-top: 200px;">
    		<tr>
    			<td colspan="2"><h2>登录</h2></td>
    		</tr>
    		<tr>
    			<td>用户名：</td>
    			<td><input type="text" name="username" id="username"/></td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td><input type="password" name="password" id="password"/></td>
    		</tr>
    		<tr>
    			<td><input type="button" value="登录" onclick="valid()"/></td>
    			<td><a href="register.jsp">注册新用户</a></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
