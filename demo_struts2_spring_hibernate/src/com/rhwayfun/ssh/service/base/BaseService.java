package com.rhwayfun.ssh.service.base;

import java.util.List;

import com.rhwayfun.ssh.pojo.Employee;

public interface BaseService {

	//根据Id查询雇员信息
	Object findById(Class clazz,java.io.Serializable id);
	
	//添加雇员
	void add(Object obj);
	
	//查询雇员
	List executeQuery(String hql,Object[] parameters);
	
	//查询雇员带分页
	List executeQueryByPage(String hql,Object[] parameters,int pageSize,int pageNow);
	
	//根据id更新雇员信息
	void executeUpdate(String hql,Object[] parameters);
	
	//通过对象修改
	void executeUpdate(Object obj);
	
	//唯一性查询
	Object uniqueQuery(String hql,Object[] parameters);
	
	//获取记录数
	Integer queryPageCount(String hql,Object[] parameters,int pageSize);
	
	//根据id删除对象
	void deleteById(Class clazz,java.io.Serializable id);
}
