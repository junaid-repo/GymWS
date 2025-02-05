package com.gympro.gusers.contoller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gympro.gusers.dto.AddMemberDTO;
import com.gympro.gusers.dto.AuthRequest;
import com.gympro.gusers.dto.MemSummry;
import com.gympro.gusers.dto.RegisterResponse;
import com.gympro.gusers.entity.UserCredentials;
import com.gympro.gusers.serice.UserService;

@RestController
@RequestMapping("/gymbook")
@CrossOrigin(origins = "http://localhost:9900")
public class GController {

	@Autowired
	UserService serv;

	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("/auth/register")
	ResponseEntity<RegisterResponse> registerUser(@RequestBody UserCredentials creds) {

		RegisterResponse response = new RegisterResponse();

		response = serv.registerUser(creds);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping("/auth/generateToken")
	ResponseEntity<String> generateToken(@RequestBody AuthRequest creds) {

		Authentication authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(creds.getUsername(), creds.getPassword()));
		String token = "";
		if (authenticate.isAuthenticated()) {
			token = serv.generateToken(creds);
		}

		else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Credentials");
		}

		return ResponseEntity.status(HttpStatus.FOUND).body(token);
	}

	@GetMapping("/user/welcome")
	ResponseEntity<String> welcome() {

		return ResponseEntity.status(HttpStatus.OK).body("Welcome to the System");
	}

	@PostMapping("/user/member/add")
	ResponseEntity<String> addMember(@RequestBody AddMemberDTO request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(serv.addMember(request));
	}

	@GetMapping("/user/member/view/{username}")
	ResponseEntity<AddMemberDTO> viewMember(@PathVariable String username) {

		return ResponseEntity.status(HttpStatus.FOUND).body(serv.viewMemberDetails(username));

	}
	
	

	@GetMapping("/user/member/view/all")
	ResponseEntity<List<MemSummry>> viewAllMember() {

		return ResponseEntity.status(HttpStatus.FOUND).body(serv.viewAllMembers());

	}
	
	@GetMapping("/user/member/search")
	ResponseEntity<Map<String, Object>> searchMembers(@RequestBody Map<String, Object> request){
		
		Map<String, Object> response=serv.searchMembers(request);
		
		return ResponseEntity.status(HttpStatus.FOUND).body(response);
	}

}
