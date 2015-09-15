package com.rhwayfun.ssh.spring.demo;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DbUtilsTest {

	DbUtils dbUtils;
	@Before
	public void setUp() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/rhwayfun/ssh/spring/demo/beans.xml");
		dbUtils = (DbUtils) applicationContext.getBean("dbUtils2");
	}

	
	@Test
	public void test(){
		System.out.println(dbUtils.getDrv());
	}
}
