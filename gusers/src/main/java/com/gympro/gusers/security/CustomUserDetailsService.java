package com.gympro.gusers.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.gympro.gusers.entity.UserCredentials;
import com.gympro.gusers.repos.UserSaveRepositor;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserSaveRepositor userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserCredentials> users=userRepo.findByUsername(username);
		
		return users.map(CustomUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("user not found with name :" + username));
	}

}
