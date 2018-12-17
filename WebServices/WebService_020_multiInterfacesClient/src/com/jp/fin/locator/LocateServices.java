package com.jp.fin.locator;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.jp.fin.exceptions.FinException;
import com.jp.hr.viewinterfaces.EmpSoapServicesView;

public class LocateServices {
	public static EmpSoapServicesView getEmpServices() throws FinException{
		try {
			URL url = new URL("http://localhost:9898/hr?wsdl");

			// Qualified name of the service:
			// 1st arg is the service URI
			// 2nd is the service name published in the WSDL
			QName qname = new QName("http://soap.hr.jp.com/",
					"EmpSoapServicesViewImplService");

			// Create, in effect, a factory for the service.
			Service service = Service.create(url, qname);

			// Extract the endpoint interface, the service "port".
			EmpSoapServicesView soapServices = service.getPort(EmpSoapServicesView.class);
			return soapServices;
		} catch (MalformedURLException e) {
			throw new FinException("Soap Service link not established" , e);
		}
	}
}
