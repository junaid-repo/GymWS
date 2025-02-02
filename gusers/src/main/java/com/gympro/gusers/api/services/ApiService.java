package com.gympro.gusers.api.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.gympro.gusers.dto.AuthRequest;

import reactor.core.publisher.Mono;



@Service
public class ApiService {
	
	 @Autowired
	    private WebClient.Builder webClientBuilder;
	 
	 @Value("${spring.api.username}")
	 private String username;
	 
	 @Value("${spring.api.pass}")
	 private String password;
	 
	 
	 public CompletableFuture<String> getApiResponse(String url) {
	
		 String token=generateToken();
		 System.out.println(token);
	         String response=webClientBuilder.build()
	                .get()
	                .uri(url)
	                .header("Authorization", "Bearer " + token)
	                .retrieve()
	                .bodyToMono(String.class)
	                .block();
	         
	         return CompletableFuture.completedFuture(response);
	    }
	 private String generateToken() {
		// String username="king02102";
		// String password="aa";
		 
		 var request =AuthRequest.builder().username(username).password(password).build();
		 
		 return webClientBuilder.build()
	                .post()
	                .uri("http://localhost:9900/gymbook/auth/generateToken")
	                .body(Mono.just(request), AuthRequest.class)
	                .retrieve()
	                .bodyToMono(String.class)
	                .block();
		 
	 }
	

}
