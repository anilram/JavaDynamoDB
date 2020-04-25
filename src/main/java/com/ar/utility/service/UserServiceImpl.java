package com.ar.utility.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.utility.dao.UserDao;
import com.ar.utility.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}

}
