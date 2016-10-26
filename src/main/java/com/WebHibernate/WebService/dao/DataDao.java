package com.WebHibernate.WebService.dao;

import java.util.List;

import org.springframework.context.annotation.Bean;

import com.WebHibernate.WebService.model.Employee;

public interface DataDao {
	
	
	public boolean addEntity(Employee employee) throws Exception;
	
	public Employee getEnityById(long id) throws Exception;
	
	public List getEntityList() throws Exception;
	
	public boolean deleteEntity(long id) throws Exception;
	

}
