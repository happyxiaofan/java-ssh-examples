<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="inc.jsp" %>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	if(username == null || password == null){
		response.sendRedirect("login.jsp");
	}
	
	boolean loginSuccess = false;
	try{
		//加载驱动程序
		Class.forName(drv).newInstance();
		//获取数据库连接
		Connection conn = DriverManager.getConnection(url, usr, pwd);
		//创建statement对象
		Statement statement = conn.createStatement();
		//定义要查询的sql语句
		String sql = "select * from user where name='" + username + "' and password='" + password +"'";
		//执行查询
		ResultSet rs = statement.executeQuery(sql);
		//获取查询结果，如果查询结果不为空则跳转到成功页面，否则返回登录页面
		if(rs.next()){
			loginSuccess = true;
		}
		//关闭数据库连接
		rs.close();
		statement.close();
		conn.close();
	}catch(Exception e){
		e.printStackTrace();
		out.print(e);
	}
	
	//如果验证成功跳转到成功页面
	if(loginSuccess){
		session.setAttribute("username",username);
		response.sendRedirect("welcome.jsp");
	}else{
		response.sendRedirect("login.jsp");
	}
	
%>