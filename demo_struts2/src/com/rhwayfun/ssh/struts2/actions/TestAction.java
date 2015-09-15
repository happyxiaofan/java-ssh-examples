package com.rhwayfun.ssh.struts2.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private String str1;
	private String str2;
	
	/**
	 * @return the str1
	 */
	public String getStr1() {
		return str1;
	}
	/**
	 * @param str1 the str1 to set
	 */
	public void setStr1(String str1) {
		this.str1 = str1;
	}
	/**
	 * @return the str2
	 */
	public String getStr2() {
		return str2;
	}
	/**
	 * @param str2 the str2 to set
	 */
	public void setStr2(String str2) {
		this.str2 = str2;
	}
	
	public String execute(){
		if(!str1.equals("") && !str2.equals("")){
			ActionContext.getContext().getSession().put("str1", str1);
			ActionContext.getContext().getSession().put("str2", str2);
			return Action.SUCCESS;
		}else{
			return Action.INPUT;
		}
	}
}
