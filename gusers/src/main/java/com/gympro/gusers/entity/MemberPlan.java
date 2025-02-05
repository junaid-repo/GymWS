package com.gympro.gusers.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "memberplan")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MemberPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="memberPlanId")
	private Integer id;
	private String planId;
	private LocalDate joiningDate;
	private Long paidAmount;
	private Long dueAmount;
}
