package com.WebHibernate.WebService.services;

import java.util.List;

import com.WebHibernate.WebService.model.Employee;

public interface DataServices {
	
	
	public boolean addEntity(Employee employee) throws Exception;
	
	public Employee getEntityById(long id) throws Exception;
	
	 public List getEntityList() throws Exception;
	
	 public boolean deleteEntity(long id) throws Exception;

}
