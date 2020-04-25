package com.ar.utility.service;

import org.springframework.stereotype.Service;

import com.ar.utility.model.User;


public interface UserService {
	public User findUserByUserName(String userName);
}
