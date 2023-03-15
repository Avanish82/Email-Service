//package com.test.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ApiCloudConfig {
//	
//	@Bean
//	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//		return builder.routes()
//				//restApi only write class level endPoin here
//				.route(r -> r.path("/customer/**")
//				//Pre and Post Filters provided by Spring Cloud Gateway
//						.filters(f -> f.addRequestHeader("first-request", "first-request-header")
//								.addResponseHeader("first-response", "first-response-header"))
//						.uri("http://localhost:8081/")
//						.id("customer-service")))
////Second service
//				.route(r -> r.path("/product/**")
//				//Pre and Post Filters provided by Spring Cloud Gateway
//						.filters(f -> f.addRequestHeader("second-request", "second-request-header")
//								.addResponseHeader("second-response", "second-response-header"))
//						.uri("product-service"))
//						//.id("consumerModule"))
////Third Service				
//				.route(r -> r.path("/rest/**")
//				//Pre and Post Filters provided by Spring Cloud Gateway
//						.filters(f -> f.addRequestHeader("second-request", "second-request-header")
//								.addResponseHeader("second-response", "second-response-header"))
//						.uri("restApi"))
//						//.id("consumerModule"))
//				.build();
//	}
// 
//
//}
