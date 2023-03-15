//package com.restapi.serviceImpl;
//
//import java.util.Collection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.stereotype.Service;
//
//import com.restapi.entity.TblUserMaster;
//import com.restapi.entity.UserMaster;
//import com.restapi.repository.TblUserMasterRepo;
//import com.restapi.service.CustomUserDetailsService;
//
//@Service
//public class CustomUserDetailsServiceImpl implements CustomUserDetailsService{
//	
//	@Autowired
//	private TblUserMasterRepo tblUserRepo;
//	
//	@Autowired
//	private RoleService roleService;
//	
//	@Override
//	public UserMaster loadUserByUsername(String input) {
//		TblUserMaster user = tblUserRepo.findByEmail(input);
//		
//		UserMaster addUser = new UserMaster();
//		addUser.setRoleService(roleService);
//	    addUser.setUserId(user.getUserId());
//	    addUser.setLoginName(user.getLoginName());
//	    addUser.setFirstName(user.getFirstName());
//	    addUser.setMiddleName(user.getMiddleName());
//	    addUser.setLastName(user.getLastName());
//	    addUser.setDomain(user.getDomain());
//	    addUser.setDoj(user.getDoj());
//	    addUser.setModifiedBy(user.getModifiedBy());
//	    addUser.setCreatedBy(user.getCreatedBy());
//	    addUser.setEmpId(user.getEmpId());
//	    addUser.setDisabed(user.isDisabled());
//	    
//	   System.out.println("User Authoriese |"+addUser.getAuthorities());
//	   
//	   if(user==null) {
//		   throw new BadCredentialsException("Bad credentials");
//		   //new AccountStatusUserDetailsChecker().check(user);
//	   }
//		return addUser;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public UserMaster loadUserByUserName(String input) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
