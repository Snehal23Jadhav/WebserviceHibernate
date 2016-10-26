package com.WebHibernate.WebService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.WebHibernate.WebService.dao.DataDao;
import com.WebHibernate.WebService.model.Employee;

public class DataServicesImpl implements DataServices{

	@Autowired
	DataDao dataDao;

	 @Override
	public  boolean addEntity(Employee employee) throws Exception {
		
		return dataDao.addEntity(employee);
		}

	 @Override
	public Employee getEntityById(long id) throws Exception {
		
		return dataDao.getEnityById(id);
	}

	 @Override
	public List getEntityList() throws Exception {
		
		return dataDao.getEntityList();
	}

	 @Override
	public boolean deleteEntity(long id) throws Exception {
		
		return dataDao.deleteEntity(id);
	}

	
	
	
	
	
}
