package com.rhwayfun.ssh.spring.demo.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TestMethodInterceptor implements MethodInterceptor{

	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("环绕通知...开始");
		Object obj = arg0.proceed();
		System.out.println("环绕通知...结束");
		return obj;
	}

}
