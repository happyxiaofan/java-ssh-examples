package com.rhwayfun.ssh.spring.demo.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 
 * <p>Title:TestMethodBefore</p>
 * <p>Description:前置通知：在函数之前调用——记录日志</p>
 * @author rhwayfun
 * @date Sep 7, 2015 11:11:27 PM
 * @version 1.0
 */
public class TestMethodBefore implements MethodBeforeAdvice{

	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		//被代理对象的连接点执行前执行
		System.out.println("开始记录日志..." + arg0.getName());
	}

}
