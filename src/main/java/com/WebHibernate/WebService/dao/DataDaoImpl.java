package com.WebHibernate.WebService.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.WebHibernate.WebService.model.Employee;


public class DataDaoImpl implements DataDao {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	Session session=null;
	Transaction tx=null;
	
	 @Bean 
	public boolean addEntity(Employee employee) throws Exception {
		
		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		session.save(employee);
		tx.commit();
		
		return false;
	}

	
	 @Bean
	public Employee getEnityById(long id) throws Exception {
		
		session=sessionFactory.openSession();
		Employee employee=(Employee) session.load(Employee.class, new Long(id));
		tx=session.beginTransaction();
		tx.commit();
		
		return employee;
	}

	
	 @Bean
	public List getEntityList() throws Exception {

		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		List employeeList=session.createCriteria(Employee.class).list();
		tx.commit();
		session.close();
		return employeeList;
	}

	 @Bean
	public boolean deleteEntity(long id) throws Exception {
		session=sessionFactory.openSession();
		Object o=session.load(Employee.class,id);
		tx=session.getTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
