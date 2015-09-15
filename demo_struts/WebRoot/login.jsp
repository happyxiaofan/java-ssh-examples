<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.rhwayfun.ssh.listener.CounterListener"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@ include file="loginCheck.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title><bean:message key="login.page.title"/></title>

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
		<bean:message key="login.page.count"/>
		<%
		  int count = CounterListener.getCount();
		  out.print(count);
		%>
		<form name="form1" action="login.do" method="post">
			<table align="center" border="1" style="margin-top: 200px;" width="400px">
				<tr>
					<td colspan="2">
						<h2>
							<bean:message key="login.page.title"/>
						</h2>
					</td>
				</tr>
				<tr>
					<td>
						<bean:message key="login.page.username"/>
					</td>
					<td>
						<!-- 判断name属性为loginFormBean的Bean是否存在，如果存在则显示属性username的值
							否则显示空值
						 -->
						<logic:present name="loginFormBean">
							<html:text property="username" name="loginFormBean" />
						</logic:present>
						<logic:notPresent name="loginFormBean">
							<input type="text" name="username" id="username" />
						</logic:notPresent> 
						<html:errors property="username"/>
					</td>
				</tr>
				<tr>
					<td>
						<bean:message key="login.page.password"/>
					</td>
					<td>
						<logic:present name="loginFormBean">
							<html:text property="password" name="loginFormBean"></html:text>
						</logic:present>
						<logic:notPresent name="loginFormBean">
							<input type="password" name="password" id="password" />
						</logic:notPresent> 
						<html:errors property="password"/>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value='<bean:message key="login.page.login"/>' 
						onclick="" />
					</td>
					<td>
						<a href="register.do?method=init"><bean:message key="login.page.register"/></a>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
