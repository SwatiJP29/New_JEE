package com.java;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*1. Creation of an application context 
 * 2. The ClassPathXMLApplicationContext referes to config file which is relative to a path on ClassPath.
 * 3. Beans are being created eagerly means at the beginning only by default.
 * 4. Beans are being created as Singleton. by default
 * To create objects lazily use 'lazy-init' attribute in context.xml
 * To create stateful objects use scope as 'prototype'
 * 5. Prototypes are always on demand. Nothing like eager creation.
 * 6. By default spring will call default constructor. If does not exists throws exception.
 * 7. The <constructor-arg> tag decides which constructor to be invoked by creating a bean.
 * 8. The <value> is for defining initial value. <ref> is for constructor injection.
 * 9. Order of the beans creation is not customizable. Spring decides it.
 * 
 */

public class TestSpringFactory {

	public static void main(String[] args) {
		
		//Create Spring Context. Here the objects of the classes mentioned in the context.xml is created
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/context.xml"); //This is the path of the configuration file
		
		
		System.out.println("Context Created");
		MyApplDao dao1 = (MyApplDao) ctx.getBean("dao");
		System.out.println("dao 1 hashcode" +dao1.hashCode());
		
		
		MyApplDao dao2 = (MyApplDao) ctx.getBean("dao");
		System.out.println("dao2 hashcode" +dao2.hashCode());
		
		MyApplServices service1 = (MyApplServices) ctx.getBean("service");
		System.out.println("service 1 hashcode" +service1.hashCode());
		
		MyApplServices service2 = (MyApplServices) ctx.getBean("service");
		System.out.println("service 2 hashcode" +service2.hashCode());
		
		CommonAttributes common = (CommonAttributes) ctx.getBean("commondata");
		System.out.println("common hashcode" +common);
	}

}
