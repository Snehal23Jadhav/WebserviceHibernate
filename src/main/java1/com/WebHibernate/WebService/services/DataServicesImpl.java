package com.WebHibernate.WebService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.WebHibernate.WebService.dao.DataDao;
import com.WebHibernate.WebService.model.Employee;

public class DataServicesImpl implements DataServices{

	@Autowired
	DataDao dataDao;

	
	public boolean addEntity(Employee employee) throws Exception {
		
		return dataDao.addEntity(employee);
	}

	public Employee getEntityById(long id) throws Exception {
		
		return dataDao.getEnityById(id);
	}

	public List getEntityList() throws Exception {
		
		return dataDao.getEntityList();
	}

	public boolean deleteEntity(long id) throws Exception {
		
		return dataDao.deleteEntity(id);
	}

	
	
	
	
	
}
