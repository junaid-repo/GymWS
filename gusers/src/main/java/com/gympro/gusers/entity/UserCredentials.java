package com.gympro.gusers.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserCredentials {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;

	@NotBlank
	String name;

	@NotBlank
	String phoneNumber;

	@NotNull
	String password;

	String role;

	LocalDateTime createdDate = LocalDateTime.now();
	
	String username;

}
