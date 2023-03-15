package com.restapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.restapi.entity.User;
import com.restapi.entity.UserEntity;

 

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
 
 Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  UserEntity save(UserEntity userEntity);
 

User findByUsernameOrEmail(String usernameOrEmail, String usernameOrEmail2);

//void findByName(String username);

 
 
 
  
}
