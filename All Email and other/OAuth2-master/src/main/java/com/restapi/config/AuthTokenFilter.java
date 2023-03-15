//package com.restapi.config;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.sql.DataSource;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.restapi.service.UserDetailsServiceImpl;
//
// 
//
//public class AuthTokenFilter extends OncePerRequestFilter {
//  @Autowired
//  private JwtUtils jwtUtils;
//
//  @Autowired
//  private UserDetailsServiceImpl userDetailsService;
//
//  private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);
//
//  @Override
//  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//      throws ServletException, IOException {
//    try {
//      String jwt = parseJwt(request);
//      if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
//        String username = jwtUtils.getUserNameFromJwtToken(jwt);
//
//        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//        
//        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//        
//        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//      }
//    } catch (Exception e) {
//      logger.error("Cannot set user authentication: {}", e);
//    }
//
//    filterChain.doFilter(request, response);
//  }
//
//  private String parseJwt(HttpServletRequest request) {
//    String jwt = jwtUtils.getJwtFromCookies(request);
//    return jwt;
//  }
//  
//  //Add by avanish 
//@Autowired
//private DataSource dataSource;
//
////@Autowired
////JwtUtils jwtUtils;
//
//@Bean
//public TokenStore tokenStore() {
//    return new JdbcTokenStore(dataSource);
//   }
//
//}
