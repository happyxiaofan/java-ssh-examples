package com.rhwayfun.ssh.spring.demo;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Department {

	private List<Employee> employees;//雇员列表
	
	private String deptName;//部门名称
	
	private String[] enames;//部门下面的雇员姓名
	
	private Set<Employee> employeeSets;
	
	private Map<String,Employee> employeeMaps;
	
	private Properties properties;
	

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}
	
	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	/**
	 * @return the ename
	 */
	public String[] getEnames() {
		return enames;
	}
	
	/**
	 * @param ename the ename to set
	 */
	public void setEnames(String[] ename) {
		this.enames = ename;
	}
	
	/**
	 * @return the employees
	 */
	public List<Employee> getEmployees() {
		return employees;
	}
	
	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	/**
	 * @return the employeeSets
	 */
	public Set<Employee> getEmployeeSets() {
		return employeeSets;
	}

	/**
	 * @param employeeSets the employeeSets to set
	 */
	public void setEmployeeSets(Set<Employee> employeeSets) {
		this.employeeSets = employeeSets;
	}
	
	/**
	 * @return the employeeMaps
	 */
	public Map<String, Employee> getEmployeeMaps() {
		return employeeMaps;
	}

	/**
	 * @param employeeMaps the employeeMaps to set
	 */
	public void setEmployeeMaps(Map<String, Employee> employeeMaps) {
		this.employeeMaps = employeeMaps;
	}

	/**
	 * @return the properties
	 */
	public Properties getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	
}
