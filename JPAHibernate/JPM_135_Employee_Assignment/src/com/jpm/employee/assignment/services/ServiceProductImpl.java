package com.jpm.employee.assignment.services;

import java.util.ArrayList;

import com.jpm.employee.assignment.daos.DaoProduct;
import com.jpm.employee.assignment.daos.DaoProductImpl;
import com.jpm.employee.assignment.entities.Product;
import com.jpm.employee.assignment.exceptions.HrException;

public class ServiceProductImpl implements ServiceProduct{
	
	private DaoProduct daoProduct;
	
	

	public ServiceProductImpl() {
		daoProduct= new DaoProductImpl();
	}

	@Override
	public ArrayList<Product> getProductList() throws HrException {
		return daoProduct.getProductList();
	}

	@Override
	public Product getProductDetails(int productId) throws HrException {
		return daoProduct.getProductDetails(productId);
	}

	@Override
	public boolean addNewProduct(Product product) throws HrException {
		return daoProduct.insertNewRecord(product);
	}

	@Override
	public ArrayList<Product> getEmplist() throws HrException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean updateProduct(Product product)throws HrException{
		return daoProduct.updateRecord(product);
	}

	@Override
	public boolean deleteProduct(int productId) throws HrException {
		return daoProduct.deleteRecord(productId);
	}

}
