package com.rhwayfun.ssh.spring.demo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("deprecation")
public class ValidateUserTest {

	ValidateUser validateUser;
	ValidateUser validateUser2;
	@Before
	public void setUp() throws Exception {
		
		//通过ApplicationContext上下文获取
		//ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("com/rhwayfun/ssh/spring/demo/beans.xml");
		//validateUser = (CheckUserXml) applicationContext2.getBean("checkUserXml");
		//validateUser2 = (CheckUserXml) applicationContext2.getBean("checkUserXml");
		
		//通过Bean工厂的形式加载bean
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("com/rhwayfun/ssh/spring/demo/beans.xml")) ;
		validateUser = (CheckUserXml) beanFactory.getBean("checkUserXml");
		
		/*通过Bean工厂加载bean与ApplicationContext获取bean的区别
		 * 前者在获取bean的时候才会创建对象，而后者则只要调用了那句代码对象就会被创建出来
		*/
	}

	@Test
	public void testCheck() {
		validateUser.check();
		System.out.println(validateUser);
//		System.out.println(validateUser2);
	}
	
	@Test
	public void testCheck2(){
		//validateUser.check();
	}

}
