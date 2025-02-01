package com.gympro.gusers.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gympro.gusers.entity.MemberPlan;

public interface MemberPlanSaveRepository extends JpaRepository<MemberPlan, Integer>{

}
