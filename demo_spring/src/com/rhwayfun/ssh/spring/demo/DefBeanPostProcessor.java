package com.rhwayfun.ssh.spring.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 
 * <p>Title:DefBeanPostProcessor</p>
 * <p>Description:后置处理器：在spring容器中配置后会自动执行下面的两个方法</p>
 * @author rhwayfun
 * @date Sep 6, 2015 6:03:45 PM
 * @version 1.0
 */
public class DefBeanPostProcessor implements BeanPostProcessor {

	/**
	 * 这里的after方法只有只有通过before方法后并调用定制的初始化方法才会执行after方法
	 */
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out.println("postProcessAfter" + arg0);
		return arg0;
	}

	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out.println("postProcessBefore" + arg0);
		return arg0;
	}

}
