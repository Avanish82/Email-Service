//package com.jwt.security.jwt;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
////    @Autowired
////    private TokenStore tokenStore;
////    @Autowired
////    private UserDetailsService UserDetailsService;
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
//    @Value("${avanish.app.jwtSecret}")
//    private String jwtSecret;
//
//    @Value("${avanish.app.jwtExpirationMs}")
//    private int jwtExpirationMs;
//
//    @Value("${avanish.app.jwtCookieName}")
//    private String jwtCookie;
//    
//    @Value("${avanish.app.jwtId}")
//    private String client;
//    
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//    	 clients.inMemory()
//         .withClient("client")
//         .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
//         .scopes("read", "write", "true")
//         .autoApprove(true)
//         .secret(passwordEncoder.encode("jwtSecret"));
//        
////        clients.inMemory()
////                .withClient("client")
////                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
////                .scopes("read", "write", "true")
////                .autoApprove(true)
////                .secret(passwordEncoder.encode("password"));
//    }
//
////working code
////    @Override
////    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
////        endpoints
////                .authenticationManager(authenticationManager)
////                .tokenStore(tokenStore());
////     
////    }
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
//    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//		oauthServer.checkTokenAccess("isAuthenticated()");
//    }
// 
//    
////	public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal) {
////    String jwt = generateTokenFromUsername(userPrincipal.getUsername());
////    ResponseCookie cookie = ResponseCookie.from(jwtCookie, jwt).path("/api").maxAge(24 * 60 * 60).httpOnly(true).build();
////    return cookie;
////  }
////	
////	 public String generateTokenFromUsername(String username) {   
////		    return Jwts.builder()
////		        .setSubject(username)
////		        .setIssuedAt(new Date())
////		        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
////		        .signWith(SignatureAlgorithm.HS512, jwtSecret)
////		        .compact();
////		  }
//    
////    @RequestMapping(value = "/Login", method = RequestMethod.POST)
////  	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest)
////  			throws Exception {
////  		try {
////  			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
////  					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
////  		} catch (DisabledException e) {
////  			throw new Exception("USER_DISABLED", e);
////  		}
////  		catch (BadCredentialsException e) {
////  			throw new Exception("INVALID_CREDENTIALS", e);
////  		}
////  		
////  		UserDetails userdetails = UserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
////  		//String token = clients.WebSecurityConfiguration(userdetails);
////  		//return ResponseEntity.ok(new AuthenticationResponse(token));
////  		return ResponseEntity.ok(new AuthorizationServerConfiguration());
////  	}
////  	
//}
//
////====================new code=====================
//
