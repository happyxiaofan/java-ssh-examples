package com.rhwayfun.ssh.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.rhwayfun.ssh.struts.forms.TestForm;
import com.rhwayfun.ssh.struts.util.Constants;

/**
 * 
 * <p>Title:TestFormAction</p>
 * <p>Description:测试表单action</p>
 * @author rhwayfun
 * @date Aug 25, 2015 1:19:45 PM
 * @version 1.0
 */
public class TestFormAction extends DispatchAction {

	public ActionForward execute(ActionMapping actionMapping,ActionForm actionForm,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		ActionErrors actionErrors = new ActionErrors();
		ActionForward actionForward = new ActionForward();
		TestForm testForm = (TestForm) actionForm;
		
		try {
			//取得表单参数
			String str1 = testForm.getStr1();
			String str2 = testForm.getStr2();
			
			//获取session对象
			HttpSession session = request.getSession(false);
			if(session!=null){
				//清空session的消息
				session.invalidate();
			}
			//创建一个新的session
			session = request.getSession(true);
			//把input.jsp页面的两个信息返回到success页面中
			session.setAttribute(Constants.STR1_key, str1);
			session.setAttribute(Constants.STR2_key, str2);
			//调用业务逻辑处理
			//...
		} catch (Exception e) {
			e.printStackTrace();
		}
		//判断是否有错误信息，有则保存错误信息，并跳转到错误页面，没有则跳转到成功页面
		if(!actionErrors.isEmpty()){
			saveErrors(request, actionErrors);
			actionForward = actionMapping.findForward("error");
		}else{
			actionForward = actionMapping.findForward("success");
		}
		return actionForward;
	}
}
