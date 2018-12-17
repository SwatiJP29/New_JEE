package com.jp.fin.tests;

import com.jp.fin.exceptions.FinException;
import com.jp.fin.locator.LocateServices;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.viewinterfaces.EmpSoapServicesView;


public class TestFinServices {

	public static void main(String[] args) {
		try {
			EmpSoapServicesView soapServices = LocateServices.getEmpServices();
			System.out.println(soapServices.getEmpDetails(105));
		} catch (FinException e) {
			e.printStackTrace();
		} catch (HrException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
