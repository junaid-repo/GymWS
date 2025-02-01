package com.gympro.gcloud_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GcloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GcloudGatewayApplication.class, args);
	}

}
