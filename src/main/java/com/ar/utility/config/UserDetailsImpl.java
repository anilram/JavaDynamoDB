package com.ar.utility.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails{
	
	private static final long serialVersionUID = 4828550662354243922L;
	private List<String> roles;
	private String password;
	private String userName;
	private boolean enable; 
	
	public UserDetailsImpl(List<String> roles,String password, String userName, boolean enable) {
		this.roles = roles;
		this.password = password;
		this.userName = userName;
		this.enable = enable;
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		for(String role: roles) {
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
			authorities.add(authority);
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enable;
	}

}
