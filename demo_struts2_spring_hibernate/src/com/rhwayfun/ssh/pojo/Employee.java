package com.rhwayfun.ssh.pojo;

import java.util.Date;

public class Employee {

	//员工id
	private Integer id;
	
	//雇员姓名
	private String ename;
	
	//邮箱
	private String email;
	
	//受雇日期
	private Date hiredate;
	
	//薪水
	private Float salary;
	
	//密码
	private String password;
	
	//级别
	private Integer grade;
	
	//雇员所属的部门名称
	private Department department;
	
	public Employee(){
		
	}
	
	public Employee(String ename, String email, Date hiredate, Float salary,String password,Integer grade,Department department) {
		this.ename = ename;
		this.email = email;
		this.hiredate = hiredate;
		this.salary = salary;
		this.password = password;
		this.grade = grade;
		this.department = department;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @return the ename
	 */
	public String getEname() {
		return ename;
	}
	/**
	 * @param ename the ename to set
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the hiredate
	 */
	public Date getHiredate() {
		return hiredate;
	}

	/**
	 * @param hiredate the hiredate to set
	 */
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	/**
	 * @return the salary
	 */
	public Float getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Float salary) {
		this.salary = salary;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the grade
	 */
	public Integer getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

}
