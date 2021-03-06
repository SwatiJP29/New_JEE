package com.jpm.banking.daos;

import com.jpm.banking.entities.Account;
import com.jpm.banking.exceptions.AccountException;

public interface IAccountDao {
	
	public Long createAcount(Account account) throws AccountException;
	public Double withdraw(Double ammount)throws AccountException;
	public Double checkBalance(Account account) throws AccountException;
	public void commitTransaction();
	public void beginTransaction();

}
