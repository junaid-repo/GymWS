package com.gympro.gusers.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ApiService {
	
	 @Autowired
	    private WebClient.Builder webClientBuilder;
	 
	 public void getApiResponse(String url) {
	         System.out.println("The plan details are-->"+webClientBuilder.build()
	                .get()
	                .uri(url)
	                .retrieve()
	                .bodyToMono(String.class)
	                .block());
	    }
	

}
