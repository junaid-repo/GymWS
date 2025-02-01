package com.gympro.gusers.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanDetails {
	
	@NotBlank(message="planId cannot be blank")
	private String planId;
	@NotBlank(message="planId cannot be blank")
	private LocalDate joiningDate;
	private Long paidAmount;
	private Long dueAmount;

}
