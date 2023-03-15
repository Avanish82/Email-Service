package com.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entity.LoginRequest;
import com.restapi.entity.User;
import com.restapi.repository.UserRepository;
import com.restapi.service.UserLoginService;

@RestController
public class UserLoginController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	private UserLoginService userLoginService;
	
	@PostMapping("/login")
	public String loginHomePage(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
		User u=null;
		try {
			userRepo.findByUsername(username);
		}catch(Exception e) {
			System.out.println("User not found!");
		}if(u!=null) {
			model.addAttribute("username", username);
//			return "login";
		}
		
		return "login";
		
	}
}
////	@PostMapping("/login")
////	//public ResponseEntity<LoginRequest> UserLogin(@RequestBody LoginRequest UserName, LoginRequest userPassword){
////	return UserLoginService.save();	
////	}
//
//}
