package com.restapi;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
 
 
@SpringBootApplication
@EnableEurekaClient
public class RestApi {

	public static void main(String[] args) {
		SpringApplication.run(RestApi.class, args);

	}
	
	 

}
