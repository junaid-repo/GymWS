package com.gympro.gusers.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gympro.gusers.entity.MemberPlan;

public interface MemberPlanSaveRepository extends JpaRepository<MemberPlan, Integer>{
	
	@Query(value="SELECT SUM(due_amount) AS due_amount FROM memberPlan", nativeQuery=true)
	Long getDueAmount();
	
	@Query(value="SELECT SUM(paid_amount) AS paid_amount FROM memberPlan", nativeQuery=true)
	Long getTotalCollection();

}
