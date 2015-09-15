package com.rhwayfun.ssh.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rhwayfun.ssh.pojo.Department;
import com.rhwayfun.ssh.pojo.Employee;

public class DepartmentServiceTest {

	private DepartmentService service;
	private EmployeeService employeeService;
	@Before
	public void setUp() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		service = (DepartmentService) applicationContext.getBean("departmentService");
		employeeService = (EmployeeService) applicationContext.getBean("employeeService");
	}

	@Test
	public void testAddDepartment() {
	
		Department department = new Department("研发部");
		//添加的雇员
		Employee employee = new Employee("张小凡", "1314@126.com", new Date(), 1900f,"456",2,department);
		Employee employee2 = new Employee("陆雪琪", "1314@qq.com", new Date(), 400f,"123",3,department);
		//添加的部门
//		employeeService.addEmployee(employee);
//		employeeService.addEmployee(employee2);
		
		/*Set<Employee> emps = new HashSet<Employee>();
		emps.add(employee);
		emps.add(employee2);*/
		
//		department.setEmps(emps);
		service.add(department);
	}

}
