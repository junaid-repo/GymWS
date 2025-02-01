package com.gympro.gplans.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class GPlanEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer planId;

	@NotBlank(message="name cannot be blank")
	@Column(unique=true) 
	String name;
	
	@NotBlank(message = "amount cannot be blank")
	private String amount;
	
	@NotBlank(message = "type cannot be blank")
	private String type;
	
	@NotBlank(message = "duration cannot be blank")
	private String duration;

}
