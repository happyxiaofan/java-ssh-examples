package com.rhwayfun.ssh.struts.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends ActionForm {

	//页面映射的表单组件有多少个表单参数，就有多少个属性
	protected String username = null;
	protected String password = null;
	
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
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	//添加登陆时的表单验证
	public ActionErrors validate(ActionMapping actionMapping,HttpServletRequest request){
		//创建ActionErrors对象，用于保存出错时的提示信息
		ActionErrors errors = new ActionErrors();
		
		//判断用户名
		if(username == null || username.equals("")){
			errors.add("username", new ActionMessage("login.error.username"));
		}
		//判断密码
		if(password == null || password.equals("")){
			errors.add("password", new ActionMessage("login.error.password"));
		}
		//	在request中保存一个Bean变量loginFormBean，值就是当前的登录表单对象
		request.setAttribute("loginFormBean", this);
		return errors;
	}
}
