package com.webvidhi.eureka.Demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class DemoAppApplication {
	
	@Autowired
    private EurekaClient eurekaClient;

	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);
	}
    
	
	@Value("${spring.application.name}")
	private String appName;
	 
	@GetMapping("/test")
	public String getClient(){
		
		
		return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
		
	}
}

