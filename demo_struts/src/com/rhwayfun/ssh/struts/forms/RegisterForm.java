package com.rhwayfun.ssh.struts.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class RegisterForm extends ActionForm {

	//页面映射的表单组件有多少个表单参数，就有多少个属性
	protected String username = null;
	protected String password1 = null;
	protected String password2 = null;
	protected String email = null;
	
	/**
	 * @return the password1
	 */
	public String getPassword1() {
		return password1;
	}
	/**
	 * @param password1 the password1 to set
	 */
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	/**
	 * @return the password2
	 */
	public String getPassword2() {
		return password2;
	}
	/**
	 * @param password2 the password2 to set
	 */
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	
	//添加注册时的表单验证
	public ActionErrors validate(ActionMapping actionMapping,HttpServletRequest request){
		//创建ActionErrors对象，用于保存出错时的提示信息
		ActionErrors errors = new ActionErrors();
		
		String queryMethod = request.getQueryString();
		if(queryMethod.equalsIgnoreCase("method=register")){
			//判断用户名
			if(username == null || username.equals("")){
				errors.add("username", new ActionMessage("register.error.username"));
			}
			//判断密码1
			if(password1 == null || password1.equals("")){
				errors.add("password1", new ActionMessage("register.error.password1"));
			}
			//判断确认密码
			if(password2 == null || password2.equals("")){
				errors.add("password2", new ActionMessage("register.error.password2"));
			}
		}
		request.setAttribute("registerFormBean", this);
		return errors;
	}
}
