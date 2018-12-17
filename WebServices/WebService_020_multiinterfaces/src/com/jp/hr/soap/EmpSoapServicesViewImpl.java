package com.jp.hr.soap;

import java.util.ArrayList;

import javax.jws.WebService;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.services.ServiceEmployee;
import com.jp.hr.utilities.ServiceFactory;
import com.jp.hr.viewinterfaces.EmpSoapServicesView;

@WebService(endpointInterface="com.jp.hr.viewinterfaces.EmpSoapServicesView")
public class EmpSoapServicesViewImpl implements EmpSoapServicesView {

	private ServiceEmployee services;
	public EmpSoapServicesViewImpl() throws HrException {
		ServiceFactory.getService();
	}
	
	

	@Override
	public Employee getEmpDetails(int empID) throws HrException {
		Employee emp = services.getEmpDetails(empID);
		return emp;
	}

	@Override
	public ArrayList<Employee> getEmpList() throws HrException {
		ArrayList<Employee> empList = services.getEmpList();
		return empList;
	}

	

}
