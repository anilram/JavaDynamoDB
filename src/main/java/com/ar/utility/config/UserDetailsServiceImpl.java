package com.ar.utility.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ar.utility.service.UserService;


public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetailsImpl userDetails = findUserWithUserName(username);
		return userDetails;
	}

	/**
	 * @param username
	 * 
	 */
	private UserDetailsImpl findUserWithUserName(String username) throws UsernameNotFoundException {
		try {
			return new UserDetailsImpl(Arrays.asList("ROLE_ADMIN"), "pass", username, true);
		}catch(Exception e) {
			throw new UsernameNotFoundException(username+" not found", e);
		}
	}
	
}
