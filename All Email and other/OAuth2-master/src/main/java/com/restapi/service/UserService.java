package com.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.restapi.entity.User;
import com.restapi.entity.UserEntity;
import com.restapi.repository.UserRepository;

 
/**
 * public class UserService implements UserDetailsService {
 */

@Service	
public class UserService{
	
	@Autowired
	UserRepository userRepo;
	
	public UserEntity addUser(UserEntity userEntity) {
		return userRepo.save(userEntity);
	}
	/**
	 *  public User userAdd(User user){
        return repository.save(user);
    }
	 * @return
	 */
	
//	public List<UserEntity> getUser(){
//		return (List<UserEntity>)userRepo.findAll();
//	}
//	public List<UserEntity> getUser(){
//		return userRepo.findAll();
//	}
//	
//	public Optional<UserEntity> getUserById(Long id){
//        return userRepo.findById(id);    
//    }
//	
	public UserEntity updateUser(UserEntity userEntity) {
		return userRepo.save(userEntity);
	}
	
	public void deleteById(Long id) {
		 userRepo.deleteById(id);

	}
}
