package com.gympro.gusers.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@Configuration
public class AsyncConfig {
	
	@Bean(name="taskExecutor")
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor exe = new ThreadPoolTaskExecutor();
		
		exe.setCorePoolSize(20);
		exe.setQueueCapacity(200);
		exe.setThreadNamePrefix("Async01-");
		exe.initialize();
		
		return exe;
	}

}
