package com.rhwayfun.ssh.demo;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringTest {

	private TestSpring testSpring;
	@Before
	public void setUp() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		testSpring = (TestSpring) applicationContext.getBean("testSpring");
	}

	@Test
	public void testExecute() throws IOException {
		testSpring.execute();
		/*File directory = new File("");// 参数为空
		String courseFile = directory.getCanonicalPath();
		System.out.println(courseFile);*/
	}

}
