package com.jpm.hr.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jpm.hr.daos.MyApplDao;

/*When bean alias (service) is not mentioned, the default is class name in camel case.
 * 
 * @Component has the below subcomponent
 * 	@Service - for declaring service beans
 * 	@Repository - for declaring dao beans.
 * 	@Controller - for Controller in spring MVC
 * 	@RestController - for declaring rest service layer
 * 
 */

//@Component("service")
@Service("service")
@Lazy(true)
@Scope("singleton")
public class MyApplServices {
private MyApplDao dao; // Spring will search the bean with name "MyApplDao" in context.xml and then it will inject the reference in here in this class
	
	public MyApplServices() {
		
		//dao is reference and new MyApplDao is object created
		//This code owns a responsibility of creating an object and holding a reference
		//dao = new MyApplDao();
		System.out.println("OBject of class MyApplSErvice is created");
	}
	
	// Dependency Injection using Constructor - Constructor will not create the object
	//@Autowired //Auto wiring by type/plumbing
	public MyApplServices(MyApplDao dao){
		this.dao = dao;
		System.out.println("OBject of class MyApplSErvice(dao) is created");
	}
	
	//Setter injection. when we resolve the dependency through setter method
	@Autowired
	public void setDao(MyApplDao dao) {
		this.dao = dao;
		System.out.println("In setter for injecting dao");
	}
	
	
	

}
