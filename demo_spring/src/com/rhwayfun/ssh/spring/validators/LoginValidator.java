package com.rhwayfun.ssh.spring.validators;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rhwayfun.ssh.spring.forms.LoginForm;

public class LoginValidator implements Validator{

	public boolean supports(Class<?> arg0) {
		return LoginForm.class.isAssignableFrom(arg0);
	}

	public void validate(Object obj, Errors errors) {
		LoginForm loginForm = (LoginForm) obj;
		if(loginForm.getUsername().equals("")){
			errors.rejectValue("username", "login.error.username", null,"用户名不能为空");
		}
		if(loginForm.getPassword().equals("")){
			errors.rejectValue("password", "login.error.password", null, "密码不能为空");
		}
	}

}
