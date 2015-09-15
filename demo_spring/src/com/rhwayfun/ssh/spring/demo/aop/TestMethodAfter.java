package com.rhwayfun.ssh.spring.demo.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * 
 * <p>Title:TestMethodAfter</p>
 * <p>Description:后置通知：完成资源关闭</p>
 * @author rhwayfun
 * @date Sep 7, 2015 11:14:06 PM
 * @version 1.0
 */
public class TestMethodAfter implements AfterReturningAdvice{

	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		System.out.println("关闭资源..." + arg1.getName());
	}

}
