package com.jp.hr.daos;

import com.jp.hr.entities.User;
import com.jp.hr.exceptions.HrException;

public interface DaoUser {
	public User getUserDetails(String userID) throws HrException;
	
}
