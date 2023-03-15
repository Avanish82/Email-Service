//package com.restapi.service;
//
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.restapi.entity.User;
//import com.restapi.repository.UserRepository;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private UserRepository userRepository;
//
//    public CustomUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
//          User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
////                 .orElseThrow(() -> 
////                 new UsernameNotFoundException("User not found with username or email: "+ usernameOrEmail));
//         
//        Set<GrantedAuthority> authorities = user
//                .getRoles()
//                .stream()
//                .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
//
//        return new org.springframework.security.core.userdetails.User(user.getEmail(),
//                user.getPassword(),
//                authorities);
//    }
//}

//
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.restapi.entity.UserMaster;
//
//public interface CustomUserDetailsService extends UserDetails {
//	
//	public UserMaster loadUserByUserName(String input);
//
//	UserMaster loadUserByUsername(String input);
//	
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////
////import java.util.Set;
////import java.util.stream.Collectors;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.security.core.GrantedAuthority;
////import org.springframework.security.core.authority.SimpleGrantedAuthority;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.core.userdetails.UsernameNotFoundException;
////import org.springframework.stereotype.Service;
////
////import com.restapi.entity.User;
////import com.restapi.repository.UserRepository;
////
////@Service
////public class CustomUserDetailsService implements UserDetailsService {
////
////    private UserRepository userRepository;
////
////    public CustomUserDetailsService(UserRepository userRepository) {
////        this.userRepository = userRepository;
////    }
////
////    @Override
////    public UserDetails loadUserByUsername(String usernameOrpassword) throws UsernameNotFoundException {
////          User user = userRepository.findByUsernameOrPassword(usernameOrpassword, usernameOrpassword)
////                 .orElseThrow(() ->
////                         new UsernameNotFoundException("User not found with username or email: "+ usernameOrpassword));
////
////        Set<GrantedAuthority> authorities = user
////                .getRoles()
////                .stream()
////                .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
////
////        return new org.springframework.security.core.userdetails.User(user.getEmail(),
////                user.getPassword(),
////                authorities);
////    }
////}
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
//////import com.restapi.entity.CustomUser;
//////import com.restapi.entity.OAuthDao;
//////import com.restapi.entity.UserEntity;
//////
//////@Service
//////public class CustomDetailsService implements UserDetailsService {
//////   
//////   @Autowired
//////   OAuthDao oauthDao;
//////
//////   @Override
//////   public CustomUser loadUserByUsername(final String username) throws UsernameNotFoundException {
//////      UserEntity userEntity = null;
//////      try {
//////         userEntity = oauthDao.getUserDetails(username);
//////         CustomUser customUser = new CustomUser(userEntity);
//////         return customUser;
//////      } catch (Exception e) {
//////         e.printStackTrace();
//////         throw new UsernameNotFoundException("User " + username + " was not found in the database");
//////      }
//////   }
//////} 
