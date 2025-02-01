package com.gympro.gplans.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gympro.gplans.entities.GPlanEntity;

public interface GPlanRepository extends JpaRepository<GPlanEntity, Integer> {

	GPlanEntity findByName(String name);

}
