package com.jp.hr.soap;

import javax.xml.ws.Endpoint;

import com.jp.hr.exceptions.HrException;
import com.jp.hr.viewinterfaces.EmpSoapServices;

//http://localhost:9898/hr?wsdl
public class PublishEmpServices {

	public static void main(String[] args) {
		try {
			EmpSoapServices soapServices = new EmpSoapServicesImpl(); //Created the reference of service layer here
			Endpoint.publish("http://localhost:9898/hr", soapServices); //Publishing the Soap serivces methods
			System.out.println("Services Started");
		} catch (HrException e) {
			e.printStackTrace();
		}

	}

}
