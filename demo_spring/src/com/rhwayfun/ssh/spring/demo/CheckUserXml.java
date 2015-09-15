package com.rhwayfun.ssh.spring.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CheckUserXml implements ValidateUser, BeanNameAware,
		BeanFactoryAware, ApplicationContextAware,InitializingBean,DisposableBean{

	private String username;

	public CheckUserXml() {
		System.out.println("CheckUserXml对象被创建");
	}

	public void check() {
		System.out.println("通过xml验证成功！" + getUsername());
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		System.out.println("set方法被调用");
		this.username = username;
	}

	public void setBeanName(String arg0) {
		System.out.println("setBeanName" + arg0);
	}

	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("setBeanFactory" + arg0);
	}

	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		System.out.println("setApplicationContext" + arg0);
	}

	//这里实现的是spring容器的初始化方法
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet:在after方法执行前执行");
	}

	//定制的初始化方法
	//这里可以使用注解的方式指定初始化方法
//	@PostConstruct
	public void init(){
		System.out.println("这是自己定制的初始化方法");
	}

	//实现的是定制的销毁方法
	//这里可以使用注解的方式指定销毁方法
	//@PreDestroy
	public void destroy() throws Exception {
		System.out.println("destroy方法");
	}
	
}
