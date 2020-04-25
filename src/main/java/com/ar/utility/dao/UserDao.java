package com.ar.utility.dao;

import com.ar.utility.model.User;

public interface UserDao {

	public User findUserByUserName(String userName);
	
}
