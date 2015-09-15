package com.rhwayfun.ssh.service.impl;

import java.util.List;

import com.rhwayfun.ssh.pojo.Employee;
import com.rhwayfun.ssh.service.EmployeeService;
import com.rhwayfun.ssh.service.base.AbstractBaseService;

/**
 * 
 * <p>Title:EmplyeeServiceImpl</p>
 * <p>Description:</p>
 * @author rhwayfun
 * @date Sep 8, 2015 11:04:24 AM
 * @version 1.0
 */

public class EmplyeeServiceImpl extends AbstractBaseService implements EmployeeService {

	@SuppressWarnings("unchecked")
	//Hibernate.initialize(Department.class);
	public Employee isExist(Employee e) {
		String hql = "from Employee where id=? and password=?";
		Object[] parameters = {e.getId(),e.getPassword()};
		List list = this.executeQuery(hql, parameters);
		if(list.size() == 1){
			return (Employee) list.get(0);
		}
		return null;
	}

	//显示所有雇员
	@SuppressWarnings("unchecked")
	public List<Employee> showEmps(int pageSize,int pageNow) {
		String hql = "from Employee order by id";
		return this.executeQueryByPage(hql, null, pageSize, pageNow);
	}

	public int getPageCount(int pageSize) {
		String hql = "select count(id) from Employee";
		return this.queryPageCount(hql, null, pageSize);
	}

}
