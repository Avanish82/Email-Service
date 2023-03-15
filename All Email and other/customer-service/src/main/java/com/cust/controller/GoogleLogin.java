package com.cust.controller;

import java.security.Principal;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GoogleLogin {

	    @GetMapping
	    public String welcome() {
	        return "Welcome to Google !!";
	    }

	    @GetMapping("/userl")
	    public Principal user(Principal principal) {
	        System.out.println("username : " + principal.getName());
	        return principal;
	    }
}
