package com.rhwayfun.ssh.bean;

import com.rhwayfun.ssh.dao.DBAccess;

public class UserBean {

	//登录验证
	public boolean valid(String usr,String pwd){
		boolean isValid = false;
		//创建数据库连接
		DBAccess db = new DBAccess();
		if(db.createCon()){
			//根据传入的用户名和密码编写sql语句
			String sql = "select * from user where name='" +usr + "'" + " and password = '" + pwd + "'"; 
			db.query(sql);
			if(db.next()){
				isValid = true;
			}
			
			//关闭连接
			db.closeRs();
			db.closeStatement();
			db.closeCon();
		}
		return isValid;
	}
	
	//注册时判断用户是否存在
	public boolean isExist(String usr){
		boolean isExist = false;
		DBAccess db = new DBAccess();
		if(db.createCon()){
			String sql = "select * from user where name='" + usr +"'";
			db.query(sql);
			if(db.next()){
				isExist = true;
			}
			
			//关闭连接
			db.closeRs();
			db.closeStatement();
			db.closeCon();
		}
		return isExist;
	}
	
	//注册用户
	public void register(String usr,String pwd,String email){
		DBAccess db = new DBAccess();
		if(db.createCon()){
			String sql = "insert into user(name,password,email) values('" 
				+ usr + "','" + pwd + "','" + email + "')";
			db.update(sql);
			
			//关闭连接
			db.closeStatement();
			db.closeCon();
		}
	}
	
	
}
