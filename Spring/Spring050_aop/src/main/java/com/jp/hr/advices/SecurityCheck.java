package com.jp.hr.advices;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

//This is the class for creating advice in AOP. It implements a particular interface
@Aspect
public class SecurityCheck {
	
	@Around("execution(* com.jp.hr.services.MyServices.*(..))")
	public Object checkAuthorization(ProceedingJoinPoint doCall) throws Throwable{
		System.out.println("Check for Authorization");
		Object obj = doCall.proceed();
		System.out.println("Logging");
		return obj;
	}

}
