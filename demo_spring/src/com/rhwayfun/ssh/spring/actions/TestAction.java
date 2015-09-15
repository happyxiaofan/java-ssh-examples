package com.rhwayfun.ssh.spring.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.rhwayfun.ssh.spring.forms.TestForm;

public class TestAction extends SimpleFormController{

	protected ModelAndView onSubmit(HttpServletRequest request,HttpServletResponse response,
			Object command,BindException error) throws Exception{
		TestForm testForm = (TestForm) command;
		if(testForm.getUsername().equals("admin") && testForm.getPassword().equals("admin")){
			request.getSession().setAttribute("username", testForm.getUsername());
			request.getSession().setAttribute("password", testForm.getPassword());
			return new ModelAndView(getSuccessView());
		}else{
			Map modle = error.getModel();
			modle.put("testForm", testForm);
			return new ModelAndView(getFormView(),modle);
		}
	}
}
