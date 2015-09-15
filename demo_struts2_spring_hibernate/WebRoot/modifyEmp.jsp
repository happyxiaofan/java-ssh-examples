<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改雇员信息</title>
    
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
    <form action="${pageContext.request.contextPath }/emp.do?action=modifyEmp&eid=${employee.id }" method="post">
    	<table align="center" style="margin-top: 200px;" bgcolor="#F0E68C">
    		<tr>
    			<td>Id</td>
    			<td><input type="text" value="${employee.id }" disabled="disabled"/></td>
    		</tr>
    		<tr>
    			<td>姓名</td>
    			<td><input type="text" name="ename" value="${employee.ename }"/></td>
    		</tr>
    		<tr>
    			<td>邮箱</td>
    			<td><input type="text" name="email" value="${employee.email }"/></td>
    		</tr>
    		<tr>
    			<td>密码</td>
    			<td><input type="password" name="password" value="${employee.password }"/></td>
    		</tr>
    		<tr>
    			<td>等级</td>
    			<td>
    			<select name="grade">
    				<option value="1">1</option>
    				<option value="2">2</option>
    				<option value="3">3</option>
    				<option value="4">4</option>
    				<option value="5">5</option>
    			</select>
    			</td>
    		</tr>
    		<tr>
    			<td>薪水</td>
    			<td><input type="text" name="salary" value="${employee.salary }"/></td>
    		</tr>
    		<tr>
    			<td>部门</td>
    			<td>
    				<select name="department_id">
    					<option value="1">财务部</option>
	    				<option value="2">技术部</option>
	    				<option value="3">研发部</option>
	    				<option value="4" selected="selected">人力资源部</option>
	    				<option value="5">会计部</option>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="添加"/></td>
    			<td><input type="reset" value="重置"/></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
