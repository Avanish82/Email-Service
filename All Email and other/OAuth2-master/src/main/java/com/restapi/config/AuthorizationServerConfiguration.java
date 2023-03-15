package com.restapi.config;

 

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; 
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.restapi.entity.LoginRequest;
import com.restapi.service.UserDetailsImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
 
  @Autowired
 // @Qualifier("authenticationManagerBean")
  private AuthenticationManager authenticationManager;
 
  @Autowired
  UserDetailsService userDetailsService;
 
  @Autowired
  private PasswordEncoder passwordEncoder;
  
  @Autowired
  private DataSource dataSource;

 
 
  
  @Override
  public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
    oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
  }
  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

      clients.inMemory()
              .withClient("client")
              .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
              .scopes("read", "write", "true")
              .autoApprove(true)
              .secret(passwordEncoder.encode("password"));
  }
 
  @Override
  public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager).accessTokenConverter(defaultAccessTokenConverter())
      .userDetailsService(userDetailsService);
  }
  @Bean
  public TokenStore tokenStore(){
    return new JwtTokenStore(defaultAccessTokenConverter());
  }
  @Bean
  public JwtAccessTokenConverter defaultAccessTokenConverter() {
    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    converter.setSigningKey("123");
    return converter;
  }
  
  //data store in data
  @Bean
  public TokenStore tokenStore1() {
      return new JdbcTokenStore(dataSource);
  }
}

//Working code 27/2/2023
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
////    @Autowired
////    private TokenStore tokenStore;
//    @Autowired
//    private UserDetailsService UserDetailsService;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private DataSource dataSource;
//
////    @Autowired
////    JwtUtils jwtUtils;
//
//    @Bean
//    public TokenStore tokenStore() {
//        return new JdbcTokenStore(dataSource);
//    }
//
//    private String client_id = "client";
//    private String client_Secret = "secret";
////    private String privateKey = "my-private-key";
////    private String publicKey = "my-public-key";
//    
// 
//    
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//  
//        clients.inMemory()
//                .withClient("client")
//                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
//                .scopes("read", "write", "true")
//                .autoApprove(true)
//                .secret(passwordEncoder.encode("password"));
//    }
//
//    
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints
//                .authenticationManager(authenticationManager)
//                .tokenStore(tokenStore());
//     
//    }
//    
//
////    @Bean
////    public TokenStore tokenStore() {
////        return new InMemoryTokenStore();
////    }
// 
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//    	security.checkTokenAccess("isAuthenticated()");
//    }
// 
//}



