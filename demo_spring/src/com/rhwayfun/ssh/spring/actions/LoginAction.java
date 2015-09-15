package com.rhwayfun.ssh.spring.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.rhwayfun.ssh.spring.dao.UserDAO;
import com.rhwayfun.ssh.spring.forms.LoginForm;

public class LoginAction extends SimpleFormController{

	private UserDAO userDAO;
	
	/**
	 * @return the userDAO
	 */
	public UserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	protected ModelAndView onSubmit(HttpServletRequest request,HttpServletResponse response,
			Object command,BindException error) throws Exception{
		LoginForm loginForm = (LoginForm) command;
		/*if(loginForm.getUsername().equals("admin") && loginForm.getPassword().equals("admin")){
			request.getSession().setAttribute("username", loginForm.getUsername());
			request.getSession().setAttribute("password", loginForm.getPassword());
			return new ModelAndView(getSuccessView());
		}else{
			Map modle = error.getModel();
			modle.put("loginForm", loginForm);
			return new ModelAndView(getFormView(),modle);
		}*/
		//采用Jdbc验证用户登录信息的合法性
		if(userDAO.isValid(loginForm.getUsername(), loginForm.getPassword())){
			request.getSession().setAttribute("username", loginForm.getUsername());
			request.getSession().setAttribute("password", loginForm.getPassword());
			return new ModelAndView(getSuccessView());
		}else{
			Map modle = error.getModel();
			modle.put("loginForm", loginForm);
			return new ModelAndView(getFormView(),modle);
		}
	}
}
