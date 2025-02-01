package com.gympro.gplans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gympro.gplans.entities.GPlanEntity;
import com.gympro.gplans.servies.PlanServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/gymbook/plans")
public class PlansController {

	@Autowired
	PlanServices serv;

	@PostMapping("/add")
	ResponseEntity<String> addPlan(@Valid @RequestBody GPlanEntity plan) {

		String response = serv.saveGPlan(plan);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	@GetMapping("/view/{name}")
	ResponseEntity<GPlanEntity> viewPlan(@PathVariable String name){
		
		GPlanEntity response=serv.getPlans(name);
		
		return ResponseEntity.status(HttpStatus.FOUND).body(response);
	}

}
