package com.rhwayfun.ssh.pojo;

import java.util.Set;

public class Department {

	//部门id
	private Integer id;
	
	//部门名称
	private String dname;
	
	//部门员工列表
	private Set<Employee> emps;

	public Department(){
		
	}
	
	public Department(String dname) {
		this.dname = dname;
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
	 * @return the emps
	 */
	public Set<Employee> getEmps() {
		return emps;
	}

	/**
	 * @param emps the emps to set
	 */
	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}

	/**
	 * @return the dname
	 */
	public String getDname() {
		return dname;
	}

	/**
	 * @param dname the dname to set
	 */
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	
}
