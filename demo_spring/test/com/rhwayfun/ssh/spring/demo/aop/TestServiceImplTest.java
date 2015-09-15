package com.rhwayfun.ssh.spring.demo.aop;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestServiceImplTest {

	private TestService testService;
	private TestService2 testService2;
	@Before
	public void setUp() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/rhwayfun/ssh/spring/demo/aop/beans.xml");
		testService = (TestService) applicationContext.getBean("proxyFactoryBean");
		testService2 = (TestService2) testService;
		//testService = (TestService) applicationContext.getBean("testService");
	}

	@Test
	public void testSayHello() {
		testService.sayHello();
		System.out.println("***************");
		testService2.sayBye();
	}

}
