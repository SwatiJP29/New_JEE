package com.jpm.banking.daos;

import javax.persistence.EntityManager;

import com.jpm.banking.entities.Account;
import com.jpm.banking.exceptions.AccountException;
import com.jpm.banking.util.JPAUtil;

public class AccountDaoImpl implements IAccountDao{
	
	private EntityManager entityManager;
	
	public AccountDaoImpl() {
		entityManager = JPAUtil.geEntityManager();
	}

	@Override
	public Long createAcount(Account account) throws AccountException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double withdraw(Double ammount) throws AccountException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double checkBalance(Account account) throws AccountException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void commitTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beginTransaction() {
		// TODO Auto-generated method stub
		
	}

}
