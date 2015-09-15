package com.rhwayfun.ssh.struts.actions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.actions.DispatchAction;

import com.rhwayfun.ssh.struts.forms.RegisterForm;
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
public class RegisterFormAction extends DispatchAction {

	private Logger logger = Logger.getLogger(this.getClass());

	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = mapping.findForward(Constants.FAILURE_KEY);
		return (forward);
	}

	/**
	 * ActionMapping：请求映射对象，负责查找对应的action actionForm：请求表达对象
	 */
	public ActionForward register(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 错误保存对象
		ActionErrors actionErrors = new ActionErrors();
		// 请求转发对象
		ActionForward actionForward = new ActionForward();
		// 请求表单对象
		RegisterForm registerForm = (RegisterForm) actionForm;
		try {
			// 判断用户名是否存在
			boolean isExist = isExist(request, registerForm);
			// 如果用户名不存在，这里暂时不进行用户的注册，因为现在还没有配置数据源
			// 这里仅仅是添加一条错误消息
			if (!isExist) {
				insert(request, registerForm);
				logger.info("User " + "[" + DateFormatUtil.format(new Date())
						+ "]" + registerForm.getUsername() + " register");
			} else {
				actionErrors.add(ActionErrors.GLOBAL_MESSAGE,
						new ActionMessage("register.message.failed"));
			}
		} catch (Exception e) {
			actionErrors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
					"register.message.failed"));
		}
		// 判断是否有错误信息，有则保存错误信息，并跳转到错误页面，没有则跳转到成功页面
		if (!actionErrors.isEmpty()) {
			saveErrors(request, actionErrors);
			request.setAttribute("registerFormBean", registerForm);
			actionForward = actionMapping.findForward(Constants.FAILURE_KEY);
		} else {
			actionForward = actionMapping.findForward(Constants.SUCCESS_KEY);
		}
		return actionForward;
	}

	/**
	 * @Description: 判断用户是否存在
	 * @param @param request
	 * @param @param registerForm
	 * @param @return
	 * @return boolean
	 * @author rhwayfun
	 * @date Aug 25, 2015
	 */
	public boolean isExist(HttpServletRequest request, RegisterForm registerForm) {
		boolean isExist = false;
		// 创建数据源
		DataSource dataSource = null;
		Connection conn = null;
		Statement st = null;

		try {
			dataSource = getDataSource(request);
			conn = dataSource.getConnection();
			st = conn.createStatement();
			String sql = "select * from user where name='"
					+ registerForm.getUsername() + "'";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				isExist = true;
			}
			// 关闭连接
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isExist;
	}

	/**
	 * @Description: 注册用户
	 * @param @param request
	 * @param @param registerForm
	 * @return void
	 * @author rhwayfun
	 * @date Aug 25, 2015
	 */
	public void insert(HttpServletRequest request, RegisterForm registerForm) {
		// 创建数据源
		DataSource dataSource = null;
		Connection conn = null;
		Statement st = null;
		try {
			dataSource = getDataSource(request);
			conn = dataSource.getConnection();
			st = conn.createStatement();
			String sql = "insert into user(name,password,email) values('"
					+ registerForm.getUsername() + "','"
					+ registerForm.getPassword1() + "','"
					+ registerForm.getEmail() + "')";
			st.executeUpdate(sql);

			// 提交修改
			conn.commit();
			// 关闭连接
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
