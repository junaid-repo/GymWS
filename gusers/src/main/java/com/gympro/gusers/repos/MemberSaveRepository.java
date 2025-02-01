package com.gympro.gusers.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gympro.gusers.entity.Members;

public interface MemberSaveRepository extends JpaRepository<Members, Integer>{

	Members findByUsername(String username);

}
