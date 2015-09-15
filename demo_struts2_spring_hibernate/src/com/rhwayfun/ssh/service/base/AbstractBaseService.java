package com.rhwayfun.ssh.service.base;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.rhwayfun.ssh.pojo.Employee;

@Transactional
public class AbstractBaseService implements BaseService {

	@Resource
	private SessionFactory sessionFactory;
	
	public void add(Object obj) {
		sessionFactory.getCurrentSession().save(obj);
	}

	@SuppressWarnings("unchecked")
	public Object findById(Class clazz,Serializable id) {
		return sessionFactory.getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List executeQuery(String hql, Object[] parameters) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		//注入参数
		if(parameters != null && parameters.length > 0){
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i, parameters[i]);
			}
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List executeQueryByPage(String hql, Object[] parameters,
			int pageSize, int pageNow) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		//注入参数
		if(parameters != null && parameters.length > 0){
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i, parameters[i]);
			}
		}
		return query.setFirstResult((pageNow - 1)*pageSize).setMaxResults(pageSize).list();
	}

	public void executeUpdate(String hql, Object[] parameters) {
		
	}

	public Object uniqueQuery(String hql, Object[] parameters) {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		//注入参数
		if(parameters != null && parameters.length > 0){
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i, parameters[i]);
			}
		}
		
		return query.uniqueResult();
	}

	
	public Integer queryPageCount(String hql, Object[] parameters, int pageSize) {
		int rowCount = Integer.parseInt(this.uniqueQuery(hql, parameters).toString());
		return (rowCount - 1) / pageSize + 1;
	}

	@SuppressWarnings("unchecked")
	public void deleteById(Class clazz,Serializable id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(this.findById(clazz, id));
	}

	public void executeUpdate(Object obj) {
		this.sessionFactory.getCurrentSession().update(obj);
	}
}
