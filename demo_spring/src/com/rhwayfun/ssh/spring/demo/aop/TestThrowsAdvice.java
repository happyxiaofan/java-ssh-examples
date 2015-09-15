package com.rhwayfun.ssh.spring.demo.aop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
 * 
 * <p>Title:TestThrowsAdvice</p>
 * <p>Description:异常通知，当被代理对象的方法发生异常的时候会自动出发异常通知的调用</p>
 * @author rhwayfun
 * @date Sep 7, 2015 11:55:58 PM
 * @version 1.0
 */
public class TestThrowsAdvice implements ThrowsAdvice {
	

	public void afterThrowing(Method m, Object[] args, Object target, Exception ex) {
       System.out.println("发生异常..." + ex.getMessage());
    }


}
