package com.rhwayfun.ssh.struts.actions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.rhwayfun.ssh.struts.forms.LoginForm;
import com.rhwayfun.ssh.struts.util.Constants;
import com.rhwayfun.ssh.struts.util.DateFormatUtil;

/**
 * 
 * <p>Title:LoginFormAction</p>
 * <p>Description:表单登录action</p>
 * @author rhwayfun
 * @date Aug 25, 2015 1:19:26 PM
 * @version 1.0
 */
public class LoginFormAction extends DispatchAction {

	Logger logger = Logger.getLogger(this.getClass());

	/**
	 * ActionMapping：请求映射对象，负责查找对应的action actionForm：请求表达对象
	 */
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 错误保存对象
		ActionErrors actionErrors = new ActionErrors();
		// 请求转发对象
		ActionForward actionForward = new ActionForward();
		// 请求表单对象
		LoginForm loginForm = (LoginForm) actionForm;

		try {
			// 取得表单参数
			String username = loginForm.getUsername();
			String password = loginForm.getPassword();

			// 获取session
			HttpSession session = request.getSession(false);
			// 判断session对象是否为空，如果为空则清空session信息，重新获取session对象
			if (session != null) {
				session.invalidate();
			}

			// 创建一个新的session
			session = request.getSession(true);

			logger.info("User " + "[" + DateFormatUtil.format(new Date()) + "]"
					+ username + " login");
			/*
			 * //验证登录(非数据库连接验证，本地验证) boolean isValid = false;
			 * if(username.equals("admin") && password.equals("admin")){ isValid
			 * = true; }
			 */
			boolean isValid = validate(request, loginForm);
			if (isValid) {
				// 把username属性保存在session中
				session.setAttribute(Constants.USERNAME_KEY, username);
			} else {
				actionErrors.add(ActionMessages.GLOBAL_MESSAGE,
						new ActionMessage("login.message.failed"));
			}
			
		} catch (Exception e) {
			actionErrors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"login.message.failed"));
		}
		// 判断是否有错误信息，有则保存错误信息，并跳转到错误页面，没有则跳转到成功页面
		if (!actionErrors.isEmpty()) {
			saveErrors(request, actionErrors);
			//
			request.setAttribute("loginFormBean", loginForm);
			actionForward = actionMapping.findForward(Constants.FAILURE_KEY);
		} else {
			actionForward = actionMapping.findForward(Constants.SUCCESS_KEY);
		}
		return actionForward;
	}

	/**
	 * 
	 * @Description: 验证登录
	 * @param @param request
	 * @param @param loginForm	
	 * @param @return
	 * @return boolean
	 * @throws
	 * @author rhwayfun
	 * @date Aug 25, 2015
	 */
	public boolean validate(HttpServletRequest request, LoginForm loginForm) {
		boolean isValid = false;
		// 创建数据源对象
		DataSource dataSource = null;
		Connection conn = null;
		Statement st = null;
		try {
			dataSource = getDataSource(request);
			conn = dataSource.getConnection();
			st = conn.createStatement();
			String sql = "select * from user where name='"
					+ loginForm.getUsername() + "' and password='"
					+ loginForm.getPassword() + "'";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				isValid = true;
			}
			// 关闭连接
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValid;
	}
}
