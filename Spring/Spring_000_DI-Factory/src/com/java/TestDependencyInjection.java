package com.java;

public class TestDependencyInjection {

	public static void main(String[] args) {
		
		ObjectFactory factory = new ObjectFactory();
		//constructor Injection
		//MyApplDao dao = factory.getDao();
		//MyApplServices services = factory.getServices();
		MyApplDao dao = (MyApplDao) factory.getBean("dao");
		
		MyApplServices services = (MyApplServices) factory.getBean("services");
	}

}
