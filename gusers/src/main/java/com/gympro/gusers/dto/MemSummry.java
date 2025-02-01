package com.gympro.gusers.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemSummry extends MemSummryAdv{
	
	String name;
	String memberId;
	String phoneNumber;
	LocalDate planExpiry;
	Long dueAmount;
	

}
