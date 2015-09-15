<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="inc.jsp"%>
<%
	String sql = "select * from user";
	try {
		//加载驱动程序
		Class.forName(drv).newInstance();
		//获取的数据库连接对象
		Connection conn = DriverManager.getConnection(url, usr, pwd);
		//创建Statement语句
		Statement statement = conn.createStatement();
		//执行查询
		ResultSet rs = statement.executeQuery(sql);

		//获取查询结果的相关信息
		ResultSetMetaData metaData = rs.getMetaData();
		//得到user表中列数
		int count = metaData.getColumnCount();
		while (rs.next()) {
			for (int i = 1; i <= count; i++) {
				String field = (String)metaData.getColumnName(i);
				String value = (String)rs.getString(i);
				out.print("filed[" + i + "]:" + field + "<br>value["
						+ i + "]:" + value);
			}
		}
		
		//关闭数据库连接
		rs.close();
		statement.close();
		conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	} 
	/*
		finally {
		try{
			if(rs!=null){
				rs.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			if(statement!=null){
				statement.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			if(conn!=null){
				conn.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	*/
%>