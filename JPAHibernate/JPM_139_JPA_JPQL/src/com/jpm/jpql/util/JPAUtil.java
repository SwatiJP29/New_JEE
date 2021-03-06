package com.jpm.jpql.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;
	
	static { //static block to initialize only static variable and invoked before object creation ie. before constructor
		factory = Persistence.createEntityManagerFactory("JPA-PU");
		
	}
	public static EntityManager geEntityManager(){
		if(entityManager==null || !entityManager.isOpen()){
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	
	public static void closeEntityManagerFactory(){
		if(factory!=null || factory.isOpen()){
			factory.close();
		}
	}
	
	public static void closeEntityManager(){
		if(entityManager!=null || entityManager.isOpen()){
			entityManager.close();
		}
	}
	
	
}
