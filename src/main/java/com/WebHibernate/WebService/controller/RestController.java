package com.WebHibernate.WebService.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.WebHibernate.WebService.model.Employee;
import com.WebHibernate.WebService.model.Status;
import com.WebHibernate.WebService.services.DataServices;

@Controller
@RequestMapping("/employee")
@ComponentScan("com.WebHibernate.WebService.*")
public class RestController {

	
	@Autowired
	DataServices dataServices;
	
	static final Logger logger=Logger.getLogger(RestController.class);
	
	 /* Submit form in Spring Restful Services */
	@RequestMapping(value="/create",method=RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
	
	 
		@ResponseBody
	 public Status addEmployee(@RequestBody Employee employee) {
		  try {
		   dataServices.addEntity(employee);
		   return new Status(1, "Employee added Successfully !");
		  } catch (Exception e) {
		   // e.printStackTrace();
		   return new Status(0, e.toString());
		  }
	}

	/* Get a single objct in Json form in Spring Rest Services */

	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	
	 @ResponseBody
	public Employee getEmployee(@PathVariable("id") long id)
	{
		Employee employee=null;
		
		try {
			employee=dataServices.getEntityById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
		
		
	}
	
	/* Getting List of objects in Json format in Spring Restful Services */

	@RequestMapping(value="/list",method=RequestMethod.GET)
	
	 @ResponseBody
	public List getEmployee()
	{
		List employeeList=null;
		
		try {
			employeeList=dataServices.getEntityList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
	}
	
	
	 
	/* Delete an object from DB in Spring Restful Services */
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	  @ResponseBody
	  public Status deleteEmployee(@PathVariable("id") long id) {

	  try {
	   dataServices.deleteEntity(id);
	   return new Status(1, "Employee deleted Successfully !");
	  } catch (Exception e) {
	   return new Status(0, e.toString());
	  }
	
	
}
}
