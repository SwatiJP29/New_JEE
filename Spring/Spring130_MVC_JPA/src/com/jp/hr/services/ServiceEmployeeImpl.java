package com.jp.hr.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jp.hr.daos.DaoEmployee;
import com.jp.hr.entities.Dept;
import com.jp.hr.entities.Emp;

import com.jp.hr.exceptions.HrException;

/*One layer refers to another layer through interface only
 * Implementation of a business rule should be done here in absence of Business Layer
 * This layer will also ensures only Custom exceptions to come out.
 * 
 * Features: 
 * 			*Only one gateway with preserving privacy of all inner classes.
 * 			* One point for implementing security, transaction management, caching
 * 			* Multiple interfaces per client to give restricted view  of all services.
 * 			* This implementation of one single service layer which to access different layers. This is Facade pattern (GoF pattern)
 * 			* DAO is a JEE pattern
 * 			* Implemented Singleton by creating single object of outermost class. Here when the init method is called then only one object of Servi
 * 				class is created. Also only one object of DAO class is created as when the constructor of Service class is creating an object of DAO class.
 * 			* Delegates and controls Cross Cutting Concerns(of all layers)
 * 
 */

@Service("service")
public class ServiceEmployeeImpl implements ServiceEmployee {
	
	//Here we are mentioning the type as Interface because we dont have alter the types of the object once a new class is introduced.
	private DaoEmployee daoEmp;
	
	//Resolving Dependency. 
	public ServiceEmployeeImpl() throws HrException {
		//daoEmp = new DaoEmployeeImpl();
	}
	
	@Autowired
	
	public ServiceEmployeeImpl(@Qualifier("daoDS")DaoEmployee daoEmp) throws HrException {
		this.daoEmp = daoEmp;
	}

	@Override
	public List<Emp> getEmpList() throws HrException {
		return daoEmp.getEmplist();
		
	}

	@Override
	public List<Dept> getDeptlist() throws HrException {
		
		return daoEmp.getDeptlist();
	}

	@Override
	public Emp getEmpDetails(int empNo) throws HrException {
		
		return daoEmp.getEmpDetails(empNo);
	}

	/*@Override
	public boolean joinNewEmployee(Employee emp) throws HrException {
		return daoEmp.insertNewRecord(emp);
	}*/

	

	

}
