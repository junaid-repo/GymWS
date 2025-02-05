package com.gympro.gusers.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gympro.gusers.entity.Members;

public interface MemberSaveRepository extends JpaRepository<Members, Integer>{

	Members findByUsername(String username);

	
	@Query(value="select * from members m, memberplan mp where m.mem_plan_id=mp.member_plan_id and mp.joining_date<?1", nativeQuery=true)
	List<Members> getExpiredMembers(LocalDate expirationDate);
	
	@Query(value="select * from members m, memberplan mp where m.mem_plan_id=mp.member_plan_id and mp.joining_date>=?1", nativeQuery=true)
	List<Members> getActiveMembers(LocalDate expirationDate);
	

}
