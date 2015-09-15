<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title><bean:message key="welcome.page.title"/></title>

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
		 <bean:message key="welcome.page.username"/>
		 ${loginuser.ename}，所在部门为${loginuser.department.dname}
		<a href="${pageContext.request.contextPath }/emp.do?action=logout">
		<bean:message key="welcome.page.logout"/></a><br/>
		<table>
			<tr>
				<td><a href="${pageContext.request.contextPath }/emp.do?action=addEmpUI">添加雇员</a></td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath }/emp.do?action=showEmps">显示雇员</a></td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath }/deleteEmp.jsp">删除雇员</a></td>
			</tr>
		</table>
	</body>
</html>
