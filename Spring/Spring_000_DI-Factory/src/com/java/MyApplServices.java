package com.java;

public class MyApplServices {
private MyApplDao dao;
	
	public MyApplServices() {
		
		//dao is reference and new MyApplDao is object created
		//This code owns a responsibility of creating an object and holding a reference
		dao = new MyApplDao();
		System.out.println("OBject of class MyApplSErvice is created");
	}
	
	// Dependency Injection using Constructor - Constructor will not create the object
	public MyApplServices(MyApplDao dao){
		this.dao = dao;
		System.out.println("OBject of class MyApplSErvice(dao) is created");
	}
	

}
