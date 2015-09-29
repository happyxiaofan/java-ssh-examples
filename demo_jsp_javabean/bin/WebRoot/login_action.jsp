<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.rhwayfun.ssh.bean.*" %>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	UserBean userBean = new UserBean();
	boolean isValid = userBean.valid(username,password);
	if(isValid){
		session.setAttribute("username",username);	
		response.sendRedirect("welcome.jsp");
	}else{
		response.sendRedirect("login.jsp");
	}
	
%>