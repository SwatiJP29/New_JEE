package com.jpm.employee.assignment.services;

import java.util.ArrayList;

import com.jpm.employee.assignment.entities.Product;
import com.jpm.employee.assignment.exceptions.HrException;

public interface ServiceProduct {
public ArrayList<Product> getEmplist() throws HrException;
	
	public Product getProductDetails(int productId) throws HrException;
	
	public boolean addNewProduct(Product product) throws HrException;

	public ArrayList<Product> getProductList() throws HrException;
	
	public boolean updateProduct(Product product)throws HrException;
	
	public boolean deleteProduct(int productId)throws HrException;

}
