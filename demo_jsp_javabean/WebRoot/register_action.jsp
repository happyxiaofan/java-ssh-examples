<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.rhwayfun.ssh.bean.*" %>
<%
	//获取注册信息
	String username = request.getParameter("username");
	String password1 = request.getParameter("password1");
	String password2 = request.getParameter("password2");
	String email = request.getParameter("email");
	
	UserBean userBean = new UserBean();
	boolean isExist = userBean.isExist(username);
	if(!isExist){
		userBean.register(username,password1,email);
		request.getRequestDispatcher("login.jsp").forward(request,response);
	}else{
		response.sendRedirect("register.jsp");
	}
	
 %>
