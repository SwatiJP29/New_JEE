package com.jp.hr.beans;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/*The implementation of Initializing Bean interface
 * * The name of implementing method can not be customizable
 * The exception being thrown can not be changed
 * The initializing code can not be grouped as per category in different methods.
 * The interface tightly bound the code to Spring framework API
 * 
 * The ApplicationContextAware is an interface to inject SpringContext reference within bean
 * Such a reference can be used to achieve dependency relationship
 * 
 * Lifecycle:
 * 		1. Object created and constructor  invoked (This will be done by JVM. Spring will only intimate JVM that objects needs to be created.
 * 		2. All setter methods - (value and reference initialization)
 * 		3. All Aware methods
 * 		4. Init methods (@PostConstruct and @AfterPropertySet marked methods)
 * 
 */
@Component("service")
public class ServiceBean implements InitializingBean, ApplicationContextAware {
	private int x;
	private ApplicationContext ctx;
	
	public ServiceBean() {
		
		System.out.println("In Constructor");
	}
	
	
	@Autowired //This is to suggest spring which constructor to call
	public ServiceBean(@Value("10")int x) {
		this.x = x;
		System.out.println("In contructor 2");
	}
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.ctx = arg0;
		System.out.println("Invoking application context");
		
	}
	
	@Value("20") //This value is printed as it is overriding the constructor
	public void setValueX(int x){
		this.x = x;
		System.out.println("In setter");
	}
	
	//The best practice is to validate every value coming from user/context.xml file
	@PostConstruct
	public void validateConfig(){
		System.out.println("In validateConfig()");
		if (x>100){
			System.out.println("Wrong input");
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("In after properties");
		
	}

	@Override
	public String toString() {
		return "ServiceBean [x=" + x + "]";
	}

	public void myServices(){
		ctx.getBean("service");
	}
	
	
	

}
