package com.java;


//Factory class
public class ObjectFactory {
	private MyApplDao dao;
	private MyApplServices services;
	
	public  ObjectFactory(){
		dao = new MyApplDao();
		services = new MyApplServices(dao);
	}
	
	//Factory method
	public MyApplDao getDao(){
		return dao;
	}
	
	public MyApplServices getServices(){
		return services;
	}
	
	public Object getBean(String beanName){
		
		switch (beanName){
		case "dao":{
			return dao;
			
		}
		case "services":{
			return services;
		}
		default:{
			return null;
		}
		
		}
		
	}

}
