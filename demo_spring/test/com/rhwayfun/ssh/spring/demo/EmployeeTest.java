package com.rhwayfun.ssh.spring.demo;


import java.util.Enumeration;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeTest {

	Department department;
	Employee emp4;
	@Before
	public void setUp() throws Exception {
		//加载beans.xml配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/rhwayfun/ssh/spring/demo/beans.xml");
		department = (Department) applicationContext.getBean("department");
		emp4 = (Employee) applicationContext.getBean("emp4");
	}

	@Test
	public void test1(){
		//部门名称
		String deptName = department.getDeptName();
		System.out.println("部门：" + deptName);
		
		//数组：部门人员
		System.out.println("******数组*******");
		for (String ename : department.getEnames()) {
			System.out.println(ename);
		}
		
		System.out.println("******List*******");
		//List：部门人员
		for (Employee employee : department.getEmployees()) {
			System.out.println(employee.getEname());
		}
		
		System.out.println("******Set*******");
		//Set：部门人员
		for (Employee employee : department.getEmployeeSets()) {
			System.out.println(employee.getEname());
		}
		
		System.out.println("******Map*******");
		for (Entry<String, Employee> entry : department.getEmployeeMaps().entrySet()) {
			System.out.println("key=" + entry.getKey() + "employee=" + entry.getValue().getEname());
		}
		
		System.out.println("******Properties*******");
		//1、通过Entry的方式取出Properties的内容
		for (Entry<Object, Object> entry : department.getProperties().entrySet()) {
			System.out.println("key=" + entry.getKey().toString() + "employee=" + entry.getValue().toString());
		}
		
		//2、通过枚举的方式取出Properties的内容
		System.out.println("******Properties枚举*******");
		Enumeration keys = department.getProperties().keys();
		while(keys.hasMoreElements()){
			String key =  (String) keys.nextElement();
			System.out.println("key=" + key + "employee=" + department.getProperties().getProperty(key));
		}
	}
	
	@Test
	public void test2(){
		System.out.println("姓名：" + emp4.getEname() + ";年龄：" + emp4.getAge());
	}
}
