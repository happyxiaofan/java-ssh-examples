package com.rhwayfun.ssh.hibernate.service;

import com.rhwayfun.ssh.hibernate.beans.User;
import com.rhwayfun.ssh.hibernate.dao.UserDAO;

public class UserService {
	
	public boolean valid(String username, String password) {
		UserDAO test = new UserDAO();
		User user = test.getUser("rhwayfun");
		if(user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		UserService service = new UserService();
		boolean login = service.valid("rhwayfun", "1209");
		System.out.println("验证结果："+login);
	}
}
