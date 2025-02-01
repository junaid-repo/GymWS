package com.gympro.gusers.serice;

import java.util.List;

import com.gympro.gusers.dto.AddMemberDTO;
import com.gympro.gusers.dto.AuthRequest;
import com.gympro.gusers.dto.MemSummry;
import com.gympro.gusers.dto.RegisterResponse;
import com.gympro.gusers.entity.UserCredentials;

public interface UserService {

	RegisterResponse registerUser(UserCredentials creds);

	String generateToken(AuthRequest creds);

 public	String addMember(AddMemberDTO request);

public AddMemberDTO viewMemberDetails(String username);

List<MemSummry> viewAllMembers();

}
