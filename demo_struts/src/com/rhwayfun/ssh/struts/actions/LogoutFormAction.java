package com.rhwayfun.ssh.struts.actions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
 * <p>Title:LogoutFormAction</p>
 * <p>Description:表单登出action</p>
 * @author rhwayfun
 * @date Aug 25, 2015 1:19:11 PM
 * @version 1.0
 */
public class LogoutFormAction extends DispatchAction {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * ActionMapping：请求映射对象，负责查找对应的action
	 * actionForm：请求表达对象
	 */
	public ActionForward execute(ActionMapping actionMapping,ActionForm actionForm,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		//请求转发对象
		ActionForward actionForward = new ActionForward();
		
		try {
			//获取session
			HttpSession session = request.getSession(false);
			logger.info("User " + "["+ DateFormatUtil.format(new Date()) + "]" + session.getAttribute("username") + " logout");
			//判断session对象是否为空，如果为空则清空session信息，重新获取session对象
			if(session!=null){
				session.invalidate();
			}
			
			actionForward = actionMapping.findForward(Constants.LOGOUT_KEY);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actionForward;
	}
}
