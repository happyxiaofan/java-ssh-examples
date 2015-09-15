package com.rhwayfun.ssh.spring.demo;

public class Employee {

	private String ename;
	
	private int age;

	public Employee(){
		
	}
	
	public Employee(String ename,int age){
		this.ename = ename;
		this.age = age;
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
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
