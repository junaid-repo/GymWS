package com.gympro.gusers.serice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gympro.gusers.api.services.ApiService;
import com.gympro.gusers.dto.AddMemberDTO;
import com.gympro.gusers.dto.AuthRequest;
import com.gympro.gusers.dto.MemSummry;
import com.gympro.gusers.dto.PlanDetails;
import com.gympro.gusers.dto.RegisterResponse;
import com.gympro.gusers.entity.MemberPlan;
import com.gympro.gusers.entity.Members;
import com.gympro.gusers.entity.UserCredentials;
import com.gympro.gusers.repos.MemberPlanSaveRepository;
import com.gympro.gusers.repos.MemberSaveRepository;
import com.gympro.gusers.repos.UserSaveRepositor;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	PasswordEncoder psdEncoder;
	
	@Autowired
	UserSaveRepositor userRegRepo;
	
	@Autowired
	MemberSaveRepository memRepo;
	
	@Autowired
	MemberPlanSaveRepository memPlanRepo;
	
	@Autowired
	ApiService apiService;
	
	@Autowired
	JwtService jwtService;

	@Override
	public RegisterResponse registerUser(UserCredentials user) {
		user.setPassword(psdEncoder.encode(user.getPassword()));
		UserCredentials out = new UserCredentials();
		RegisterResponse response = new RegisterResponse();
		String username = "";

		out = userRegRepo.save(user);

		if (out.getId() > 0) {
			username = user.getName().replaceAll("\\s", "").toLowerCase() + String.valueOf(out.getId());
		}

		out.setUsername(username);

		out = userRegRepo.save(out);

		response.setReturnCode("201");
		response.setReturnMsg("User Created");
		response.setUsername(username);
		// TODO Auto-generated method stub
		return response;
	}

	@Override
	public String generateToken(AuthRequest creds) {
		// TODO Auto-generated method stub
		return jwtService.generateToken(creds.getUsername());
	}

	@Override
	public String addMember(AddMemberDTO request) {
		
		var member = Members.builder().name(request.getName()).gender(request.getGender()).email(request.getEmail())
				.phoneNumber(request.getPhone())
				.dob(request.getDob()).addresss(request.getAddress())
				.memberPlan(MemberPlan.builder().joiningDate(request.getPlanDetails().getJoiningDate())
						.paidAmount(request.getPlanDetails().getPaidAmount())
						.planId(String.valueOf(request.getPlanDetails().getPlanId()))
						.dueAmount(request.getPlanDetails().getDueAmount()).build())
				.build();
		
		Members mem=memRepo.save(member);
		
		if(mem!=null) {
			mem.setUsername("MEM000"+ String.valueOf(mem.getId()));
			
			mem=memRepo.save(mem);
			
			return "Member added with username  "+mem.getUsername();
		}
		
		return null;
	}

	@Override
	@Cacheable("username")
	public AddMemberDTO viewMemberDetails(String username) {
		
		Members members=memRepo.findByUsername(username);
		MemberPlan memPlan = null;
		AddMemberDTO response = null;

		try {
			CompletableFuture<String> planDetails = apiService
					.getApiResponse("http://localhost:8090/gymbook/plans/view/AI");
			System.out.println(planDetails.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (members != null) {
			memPlan = memPlanRepo.findById(members.getMemberPlan().getId()).get();
			response = AddMemberDTO.builder().name(members.getName()).gender(members.getGender())
					.email(members.getEmail()).phone(members.getPhoneNumber()).dob(members.getDob())
					.address(members.getAddresss())
					.planDetails(PlanDetails.builder().planId(String.valueOf(memPlan.getPlanId()))
							.joiningDate(memPlan.getJoiningDate()).paidAmount(memPlan.getPaidAmount())
							.dueAmount(memPlan.getDueAmount()).build())
					.build();

			return response;

		}

		return response;
	}
	@Override
	@Cacheable("id")
	public List<MemSummry> viewAllMembers(){
		
		List<Members> memList=memRepo.findAll();
		
		List<MemSummry> response= new ArrayList<>();
		
		memList.stream().forEach(obj->{
			if(obj.getMemberPlan()!=null) {
				response.add(MemSummry.builder()
						.name(obj.getName())
						.memberId(String.valueOf(obj.getId()))
						.phoneNumber(obj.getPhoneNumber())
						.planExpiry(obj.getMemberPlan().getJoiningDate().plusMonths(1))
						.dueAmount(obj.getMemberPlan().getDueAmount())
						.build());
			}
		});
		return response;
	}

}
