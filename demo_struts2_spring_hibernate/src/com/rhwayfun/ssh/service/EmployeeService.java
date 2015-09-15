package com.rhwayfun.ssh.service;

import java.util.List;
import java.util.Set;

import com.rhwayfun.ssh.pojo.Employee;
import com.rhwayfun.ssh.service.base.BaseService;

/**
 * 
 * <p>Title:EmployeeService</p>
 * <p>Description:雇员接口</p>
 * @author rhwayfun
 * @date Sep 8, 2015 10:50:56 AM
 * @version 1.0
 */
public interface EmployeeService extends BaseService{

	
	//验证用户是否存在
	Employee isExist(Employee e);
	
	//显示所有雇员
	List<Employee> showEmps(int pageSize,int pageNow);
	
	//获取总的记录数
	int getPageCount(int pageSize);
	
}
