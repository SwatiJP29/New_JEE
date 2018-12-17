package com.jp.hr.updateInterfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;

@WebService
@SOAPBinding(style=Style.DOCUMENT)
public interface EmpSoapServicesUpdate {
	
	@WebMethod
	public Employee getEmpDetails(int empID) throws HrException;
	
	@WebMethod
	public boolean insertNewRecord(Employee emp) throws HrException;

}