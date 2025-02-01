package com.gympro.gplans.servies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.gympro.gplans.entities.GPlanEntity;
import com.gympro.gplans.repos.GPlanRepository;

import jakarta.validation.Valid;

@Service
public class PlanServices {

	@Autowired
	GPlanRepository gprepo;

	public String saveGPlan(@Valid GPlanEntity plan) {

		gprepo.save(plan);

		return "success";
	}

	@Cacheable("name")
	public GPlanEntity getPlans(String name) {
		// TODO Auto-generated method stub
		return gprepo.findByName(name);
	}

}
