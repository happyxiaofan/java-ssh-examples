package com.rhwayfun.ssh.pojo;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rhwayfun.ssh.service.EmployeeService;

public class EmployeeTest {

	private SessionFactory sessionFactory;
	private EmployeeService employeeService;
	@Before
	public void setUp() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
//		sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
		employeeService = (EmployeeService) applicationContext.getBean("employeeService");
	}
	
	@Test
	public void test(){
		Session session = sessionFactory.openSession();
//		Employee employee = new Employee("xiaofan", "1234@126.com", new Date(), 1500f,"123",1);
		
		Transaction transaction =  session.beginTransaction();
//		session.save(employee);
		transaction.commit();
		session.close();
	}

	@Test
	public void test2(){
		
	}
}
