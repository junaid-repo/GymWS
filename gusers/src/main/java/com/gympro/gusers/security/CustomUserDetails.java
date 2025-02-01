package com.gympro.gusers.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gympro.gusers.entity.UserCredentials;


public class CustomUserDetails implements UserDetails{
	
	public String username;
	public String password;
	
	

	public CustomUserDetails(UserCredentials usercreds) {
		super();
		this.username = usercreds.getUsername();
		this.password = usercreds.getPassword();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

}
