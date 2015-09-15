<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>显示雇员</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <form action="">
    <a href="javascript:history.go(-1)">返回上一页</a>
    	<table>
    		<tr>
    			<td>id</td>
    			<td>ename</td>
    			<td>email</td>
    			<td>hiredate</td>
    			<td>salary</td>
    			<td>password</td>
    			<td>grade</td>
    			<td>department_id</td>
    			<td>action</td>
    		</tr>
    		<c:forEach items="${employeeList}" var="employee">
    		<tr>
    			<td>${employee.id }</td>
    			<td>${employee.ename }</td>
    			<td>${employee.email }</td>
    			<td><fmt:formatDate value="${employee.hiredate}" pattern="yyyy-MM-dd"/></td>
    			<td>${employee.salary }</td>
    			<td>${employee.password }</td>
    			<td>${employee.grade }</td>
    			<td>${employee.department.id }</td>
    			<td>
    			<a href="${pageContext.request.contextPath }/emp.do?action=modifyEmpUI&empId=${employee.id}" class="modify">修改</a>
    			<a href="${pageContext.request.contextPath }/emp.do?action=deleteEmp&empId=${employee.id}" class="delete">删除</a>
    			</td>
    		</tr>
    		</c:forEach>
    	</table>
    	<c:forEach begin="1" end="${pageCount}" var="i">
    		<a href="${pageContext.request.contextPath }/emp.do?action=showEmps&pageNow=${i}">${i}</a>
    	</c:forEach>
    </form>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/do.js"></script>
  </body>
</html>
