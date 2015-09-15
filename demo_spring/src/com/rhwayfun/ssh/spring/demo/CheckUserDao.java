package com.rhwayfun.ssh.spring.demo;

public class CheckUserDao implements ValidateUser {

	private String username;
	
	public CheckUserDao(){
		System.out.println("CheckUserDao对象被创建");
	}
	
	public void check() {
		System.out.println("通过数据库验证成功！" + getUsername());
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}
