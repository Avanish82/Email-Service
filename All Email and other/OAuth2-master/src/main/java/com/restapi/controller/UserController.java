package com.restapi.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entity.UserEntity;
import com.restapi.service.UserService;

@RestController
//@RequestMapping("/rest")
public class UserController {

	@Autowired
	UserService userSer;
	
	@GetMapping("/public")
	  public String welcomePublic() {
	    return "welcome public/guest user";
	  }

	  @RolesAllowed({"ROLE_ADMIN"})
	//  @GetMapping("/admin")
	  public String welcomeAdmin() {
	    return "welcome admin";
	  }

	  @RolesAllowed({"ROLE_USER"})
	  @GetMapping("/user")
	  public String welcomeUser() {
	    return "welcome user";
	  }
	
	@RolesAllowed({"ROLE_ADMIN"})
	@PostMapping("/add")
	public UserEntity addUser(@RequestBody UserEntity userEntity) {
		System.out.println("hey i am working properly");
		return userSer.addUser(userEntity);
	}
	
//	 @RolesAllowed({"ROLE_ADMIN"})
//		@GetMapping("/show")
//		public List<UserEntity> getUser(){
//			System.out.println("hi i am working.."+userSer.getUser());
//		return userSer.getUser();
//		}
	/**
	 *   @PostMapping("/addUser")
    public User userAdd(@RequestBody User user){
        return userService.userAdd(user);
    }
    
	 * @return
	 */
	/** @GetMapping("/getMapping")
	    public ResponseEntity<List<UserEntity>> getUser() {
	        List<UserEntity> users = userSer.getUser();
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    }
	 * 
	 * @return
	 */
	 
	
//	@RolesAllowed({"ROLE_ADMIN"})
//	@GetMapping("/show/{id}")
//    public Optional<UserEntity> getUserById(@PathVariable Long id){
//		System.out.println("values by id"+userSer.getUserById(id));
//        return userSer.getUserById(id);
//    }
//	
	@RolesAllowed({"ROLE_ADMIN"})
	@PutMapping("/update")
	public UserEntity updateUser(@RequestBody UserEntity userEntity) {
		return userSer.updateUser(userEntity);
	}
	
	@RolesAllowed({"ROLE_ADMIN"})
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		System.out.println("hi i am working");
		userSer.deleteById(id);
	}
	
}
