package com.rhwayfun.ssh.struts.forms;

import org.apache.struts.action.ActionForm;

public class TestForm extends ActionForm {

	//页面映射的表单组件有多少个表单参数，就有多少个属性
	protected String str1 = null;
	protected String str2 = null;
	
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
	
	
}
