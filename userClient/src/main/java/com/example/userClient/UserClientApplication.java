package com.example.userClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class UserClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserClientApplication.class, args);
	}
}

@RestController
class getUserService{
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	
	@RequestMapping("/")
	public String getInstances(){
		
		List<ServiceInstance> instances=  discoveryClient.getInstances("user-service");
		for(ServiceInstance s:instances){
			System.out.println("Service "+s.getUri());
			
		}
		return "found services Successfully";	
	}

	@RequestMapping("/hello")
	public String greetings(){
		List<ServiceInstance> instances=  discoveryClient.getInstances("user-service");
	RestTemplate restTemplate=new RestTemplate();	
	ResponseEntity<String> response= restTemplate.getForEntity(instances.get(0).getUri().toString()+"/", String.class);
		
		return "User Service "+response.getBody();
	}
	
	
	
}