<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@ include file="registerCheck.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title><bean:message key="register.page.title"/></title>

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
		<form name="form1" action="register.do?method=register" method="post">
			<table align="center" border="1" style="margin-top: 200px;">
				<tr>
					<td colspan="2">
						<h2>
							<bean:message key="register.page.title"/>
						</h2>
					</td>
				</tr>
				<tr>
					<td>
						<bean:message key="register.page.username"/>
					</td>
					<td>
						<logic:present name="registerFormBean">
							<html:text property="username" name="registerFormBean"/>
						</logic:present>
						<logic:notPresent name="registerFormBean">
							<input type="text" name="username" id="username" />
						</logic:notPresent>
						<html:errors property="username"/>
					</td>
				</tr>
				<tr>
					<td>
						<bean:message key="register.page.password1"/>
					</td>
					<td>
						<logic:present name="registerFormBean">
							<html:text property="password1" name="registerFormBean"/>
						</logic:present>
						<logic:notPresent name="registerFormBean">
							<input type="password" name="password1" id="password1" />
						</logic:notPresent>
						<html:errors property="password1"/>
					</td>
				</tr>
				<tr>
					<td>
						<bean:message key="register.page.password2"/>
					</td>
					<td>
						<logic:present name="registerFormBean">
							<html:text property="password2" name="registerFormBean"/>
						</logic:present>
						<logic:notPresent name="registerFormBean">
							<input type="password" name="password2" id="password2" />
						</logic:notPresent>
						<html:errors property="password2"/>
					</td>
				</tr>
				<tr>
					<td>
						<bean:message key="register.page.email"/>
					</td>
					<td>
						<logic:present name="registerFormBean">
							<html:text property="email" name="registerFormBean"/>
						</logic:present>
						<logic:notPresent name="registerFormBean">
							<input type="text" name="email" id="email" />
						</logic:notPresent>
						<html:errors property="email"/>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="<bean:message key="register.page.register"/>" 
						onclick="" />
					</td>
					<td>
						<a href="index.do"><bean:message key="register.page.back"/></a>
					</td>
				</tr>
				<tr>
					<td colspan="2"><html:errors property="org.apache.struts.action.GLOBAL_MESSAGE"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>
