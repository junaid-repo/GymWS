package com.gympro.gusers.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gympro.gusers.entity.UserCredentials;

public interface UserSaveRepositor extends JpaRepository<UserCredentials, Integer>{
	
	public Optional<UserCredentials> findByUsername(String username);

}
