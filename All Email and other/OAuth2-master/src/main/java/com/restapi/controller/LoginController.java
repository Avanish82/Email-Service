package com.restapi.controller;

 
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 
import com.restapi.config.AuthorizationServerConfiguration; 
import com.restapi.entity.ERole; 
import com.restapi.entity.LoginRequest;
import com.restapi.entity.MessageResponse;
import com.restapi.entity.Role;
import com.restapi.entity.SignupRequest;
import com.restapi.entity.User;
import com.restapi.entity.UserInfoResponse; 
import com.restapi.repository.RoleRepository;
import com.restapi.repository.UserRepository;
import com.restapi.service.UserDetailsImpl;
 

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class LoginController {
	 
	  @Autowired
	  AuthenticationManager authenticationManager;

	  @Autowired
	  UserRepository userRepository;

	  @Autowired
	  RoleRepository roleRepository;
 
	  @Autowired
	  BCryptPasswordEncoder bCryptPasswordEncoder;
//	  @Autowired
//	  JwtUtils jwtUtils;

	  @Autowired
	  private UserDetailsService UserDetailsService;
	  
	  @Autowired
	  AuthorizationServerConfiguration authServConfig;
	  
	  @Autowired
	  PasswordEncoder encoder;
	  
	  @Autowired
	  com.restapi.config.JwtUtils jwtUtils;
	 // JwtUtils jwtUtils;
 
	  //Static type login EndPoint working properly
	  @PostMapping("/LoginByUser")
	    public ResponseEntity<String> LoginUser(@RequestBody LoginRequest loginRequest){
	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	        		loginRequest.getUsername(), loginRequest.getPassword()));

	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
	    }
	  
//Registration properly it's working fine
	  @PostMapping("/signup")
	  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
	    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
	      return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
	    }

	    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
	      return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
	    }

	    // Create new user's account
	    User user = new User(signUpRequest.getUsername(),
	                         signUpRequest.getEmail(),
	                         encoder.encode(signUpRequest.getPassword()));

	    Set<String> strRoles = signUpRequest.getRole();
	    Set<Role> roles = new HashSet<>();

	    if (strRoles == null) {
	      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
	          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	      roles.add(userRole);
	    } 
	    else {
	      strRoles.forEach(role -> {
	        switch (role) {
	        case "admin":
	          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(adminRole);

	          break;
	        case "mod":
	          Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(modRole);

	          break;
	        default:
	          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(userRole);
	        }
	      });
	    }

	    user.setRoles(roles);
	    userRepository.save(user);

	    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	  }
	  
//	  @PostMapping("/signout")
//	  public ResponseEntity<?> logoutUser() {
//	   // ResponseCookie cookie = UserDetailsService.getCleanJwtCookie();
//	  //  Authentication authentication;
//	  //  UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//		  UserDetailsImpl userDetails = (UserDetailsImpl) AuthenticatedVoter.getPrincipal();
//	    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,userDetails.toString())
//	        .body(new MessageResponse("You've been signed out!"));
//	  }
 

	  //working properly as your requerement
	  @PostMapping("/signin")
	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		  //userRepository
	    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

	    SecurityContextHolder.getContext().setAuthentication(authentication);

	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

	    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

	    List<String> roles = userDetails.getAuthorities().stream()
	        .map(item -> item.getAuthority())
	        .collect(Collectors.toList());

	    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
	        .body(new UserInfoResponse(userDetails.getId(),
	                                   userDetails.getUsername(),
	                                   userDetails.getEmail(),
	                                   roles));
	    //token return
	   // return ResponseEntity.ok(jwtCookie);
	  }
//	  @RequestMapping(value = "/Login", method = RequestMethod.POST)
//			public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest)throws Exception {
//				try {
//					//authenticationManager.authenticate(new UsernamePasswordAuthenticationToken())
//					authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//				} catch (DisabledException e) {
//					throw new Exception("USER_DISABLED", e);
//				}
//				catch (BadCredentialsException e) {
//					throw new Exception("INVALID_CREDENTIALS", e);
//				}
//				
//				UserDetails userdetails = UserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//				//String token = clients.WebSecurityConfiguration(userdetails);
//				//return ResponseEntity.ok(new AuthenticationResponse(token));
//				return ResponseEntity.ok(new AuthorizationServerConfiguration());
//			}
 
}
