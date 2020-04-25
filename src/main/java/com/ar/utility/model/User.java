package com.ar.utility.model;

import java.util.List;

public class User {
	
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public User(List<String> roles, String password, String userName, boolean enable) {
		super();
		this.roles = roles;
		this.password = password;
		this.userName = userName;
		this.enable = enable;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	private List<String> roles;
	private String password;
	private String userName;
	private boolean enable; 
	
}
