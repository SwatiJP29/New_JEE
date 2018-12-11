package com.jp.hr.services;

public class MyServices {
	
	//All the below methods are the join points in the AOP.
	
	public void abcMethod1(){
		System.out.println("\t In Method 1");
	}
	
	public void abcMethod2(int x){
		System.out.println("\t In Method 2 (int x)");
	}
	
	public void abcMethod3(int x, int y){
		System.out.println("\t In Method 3 (int x, int y)");
	}

}
