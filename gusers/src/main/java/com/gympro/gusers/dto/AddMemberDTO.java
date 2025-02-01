package com.gympro.gusers.dto;

import com.gympro.gusers.dto.PlanDetails;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddMemberDTO {
	
	private String name;
	@Size(min = 10, max = 10, message = "Phone number is not valid")
	private String phone;
    @Pattern(regexp = "M|F", message = "Gender must be either 'M' or 'F'")
    private String gender;
    @Email(message="email must be valid")
    private String email;
    
    private String dob;
    private String address;
    private PlanDetails planDetails;
}
