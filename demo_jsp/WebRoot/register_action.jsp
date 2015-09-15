<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="inc.jsp" %>
<%
	//获取注册信息
	String username = request.getParameter("username");
	String password1 = request.getParameter("password1");
	String password2 = request.getParameter("password2");
	String email = request.getParameter("email");
	
	//验证注册信息
	if(username == null || password1 == null || password2 == null 
		|| !password1.equals(password2)){
		response.sendRedirect("register.jsp");
	}
	
	boolean registerSuccess = false;
	try{
		//加载驱动程序
		Class.forName(drv).newInstance();
		//获取数据库连接
		Connection conn = DriverManager.getConnection(url, usr, pwd);
		//创建statement对象
		Statement statement = conn.createStatement();
		//定义要查询的sql语句
		String sql = "select * from user where name='" + username + "'";
		//执行查询
		ResultSet rs = statement.executeQuery(sql);
		//获取查询结果，如果查询结果不为空则跳转到成功页面，否则返回登录页面
		if(!rs.next()){
			String sql2 = "insert into user(name,password,email) values('" + username + "','" + password1 + "','" + email + "')";
			statement.execute(sql2);
			registerSuccess = true;
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
	if(registerSuccess){
		request.getRequestDispatcher("login.jsp").forward(request,response);
		//response.sendRedirect("login.jsp");
	}else{
		response.sendRedirect("register.jsp");
	}
 %>
