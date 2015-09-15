package com.rhwayfun.ssh.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.rhwayfun.ssh.form.LoginForm;
import com.rhwayfun.ssh.pojo.Employee;
import com.rhwayfun.ssh.service.EmployeeService;

public class LoginAction extends DispatchAction {

	private EmployeeService employeeService;
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse resp) throws Exception {
		
		ActionForward actionForward = new ActionForward();
		LoginForm loginForm = (LoginForm) form;
		
		System.out.println("EmployeeService实例被加载............");
		/*//2、获取spring容器实例,并获取EmployeeService实例
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServlet().getServletContext());
		EmployeeService employeeService = (EmployeeService) webApplicationContext.getBean("employeeService");*/
		
		// 获取session
		HttpSession session = request.getSession(false);
		// 判断session对象是否为空，如果为空则清空session信息，重新获取session对象
		if (session != null) {
			session.invalidate();
		}
		// 创建一个新的session
		session = request.getSession(true);
		
		//到数据库中验证
		Employee e = new Employee();
		e.setId(loginForm.getId());
		e.setPassword(loginForm.getPassword());
		Employee e2 = employeeService.isExist(e);
		if(e2 != null){
			session.setAttribute("loginuser", e2);
			actionForward = mapping.findForward("success");
		}else{
			actionForward = mapping.findForward("failure");
		}
		
		//1、原始验证登录
		/*String pwd = loginForm.getPassword();
		if(pwd.equals("123")){
			session.setAttribute("pwd", pwd);
			actionForward = mapping.findForward("success");
		}else{
			actionForward = mapping.findForward("failure");
		}*/
		return actionForward;
	}
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
}
