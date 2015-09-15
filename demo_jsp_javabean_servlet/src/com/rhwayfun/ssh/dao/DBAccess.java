package com.rhwayfun.ssh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAccess {

	//数据库连接对象
	private Connection conn;
	//驱动管理对象
	private String drv = "com.mysql.jdbc.Driver";
	//url
	private String url = "jdbc:mysql://localhost:3306/test";
	//statement对象
	private Statement statement;
	//结果集对象
	private ResultSet rs;
	//用户名
	private String usr = "root";
	//密码
	private String pwd = "1209";
	
	/**
	 * @return the conn
	 */
	public Connection getConn() {
		return conn;
	}
	/**
	 * @param conn the conn to set
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	/**
	 * @return the drv
	 */
	public String getDrv() {
		return drv;
	}
	/**
	 * @param drv the drv to set
	 */
	public void setDrv(String drv) {
		this.drv = drv;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the statement
	 */
	public Statement getStatement() {
		return statement;
	}
	/**
	 * @param statement the statement to set
	 */
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	/**
	 * @return the rs
	 */
	public ResultSet getRs() {
		return rs;
	}
	/**
	 * @param rs the rs to set
	 */
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	/**
	 * @return the usr
	 */
	public String getUsr() {
		return usr;
	}
	/**
	 * @param usr the usr to set
	 */
	public void setUsr(String usr) {
		this.usr = usr;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	//创建数据连接
	public boolean createCon(){
		boolean isCon = false;
		try {
			//加载驱动程序
			Class.forName(drv).newInstance();
			conn = DriverManager.getConnection(url,usr,pwd);
			isCon = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isCon;
	}
	
	//更新sql
	public boolean update(String sql){
		boolean isUpdate = false;
		try {
			statement = conn.createStatement();
			statement.executeUpdate(sql);
			isUpdate = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdate;
	}
	
	//查询sql
	public void query(String sql){
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//next函数
	public boolean next(){
		boolean next = false;
		try {
			if(rs.next()){
				next = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return next;
	}
	
	//获取字段的值
	public String getValue(String field){
		String value =  null;
		try {
			if(rs != null){
				value = rs.getString(field);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	//关闭rs
	public void closeRs(){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//关闭statement
	public void closeStatement(){
		try {
			if(statement != null){
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//关闭conn
	public void closeCon(){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
