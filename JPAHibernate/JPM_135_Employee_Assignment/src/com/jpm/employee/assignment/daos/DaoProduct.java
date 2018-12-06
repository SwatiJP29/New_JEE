package com.jpm.employee.assignment.daos;

import java.util.ArrayList;

import com.jpm.employee.assignment.entities.Product;
import com.jpm.employee.assignment.exceptions.HrException;

public interface DaoProduct {

	public ArrayList<Product> getProductList() throws HrException;
	public Product getProductDetails(int productId) throws HrException;
	
	public boolean insertNewRecord(Product product) throws HrException;
	
	
	
	public boolean deleteRecord(int productId) throws HrException;
	
	boolean updateRecord(Product product) throws HrException;

	

}
