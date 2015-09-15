package com.rhwayfun.ssh.spring.demo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {

	private HelloWorld helloWorld;

	@Before
	public void setUp() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		helloWorld = (HelloWorld) applicationContext.getBean("HelloWorld");
	}

	@Test
	public void testExecute() {
		System.out.println(helloWorld.execute("rhwayfun"));
	}

}
