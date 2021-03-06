package com.jpm.lifecycle.client;

import javax.persistence.EntityManager;

import com.jpm.lifecycle.entities.Greet;
import com.jpm.lifecycle.util.JPAUtil;

public class ClientObjectLifeCycle {
	
	public static void main(String[] args) {
		
		
		//step 2 : Obtain EntityManager object
		EntityManager em = JPAUtil.geEntityManager();
		
		//step3 : begin Transaction
		em.getTransaction().begin();
		
		//step 4 create the bean object and persist it on the DB
		Greet greet = new Greet();//Transient/New
		
		greet.setMessage("Welcome to JPA Session");
		//step 5 : persist bean object in DB
		
		em.persist(greet);//Managed state. it will store the values of the object into the DB
		
		
		
		System.out.println("Adding Greet object on to the DB");
		
		//step 6 : commit the tx
		em.getTransaction().commit();
		
		//step 7 : close EntityManager
		em.close();
		
		//System.out.println("Updated Greet object on to the DB with unique message" +em.find(Greet.class, greet.getMessageId()));
		//The above statement will not work since the connection is closed.
		
	}

}
