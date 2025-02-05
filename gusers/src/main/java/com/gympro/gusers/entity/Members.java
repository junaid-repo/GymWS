package com.gympro.gusers.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="members")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Members {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	private String username;
	private String gender;
	private String email;
	private String phoneNumber;
	private String dob;
	private String addresss;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="memPlanId", referencedColumnName = "memberPlanId")
	private MemberPlan memberPlan;

}
