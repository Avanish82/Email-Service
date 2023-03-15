package com.restapi.config;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.annotation.Bean; 
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.restapi.repository.UserRepository;

////working
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserRepository userRepo;
	
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;
    
//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean(name = "authenticationManager")
     

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
   // @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }
    
//    @Bean
//    public AuthTokenFilter authenticationJwtTokenFilter() {
//      return new AuthTokenFilter();
//    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
         
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
     
        return authProvider;
    }
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
    
    
//working fine 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 //working fine      
//        auth.inMemoryAuthentication().withUser("user").password(passwordEncoder.encode("secret")).roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("admin")).roles("ADMIN");
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
     
    private PasswordEncoder bCryptPasswordEncoder() {
	// TODO Auto-generated method stub
    	return new BCryptPasswordEncoder();
}
//	
//    @Bean
//    PasswordEncoder getEncoder() {
//        return new BCryptPasswordEncoder();
//     
//    }
       
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//      http.authorizeRequests()
//          .antMatchers("/").hasAnyAuthority("USER", "CREATOR", "EDITOR", "ADMIN")
//          .antMatchers("/new").hasAnyAuthority("ADMIN", "CREATOR")
//          .antMatchers("/edit/**").hasAnyAuthority("ADMIN", "EDITOR")
//          .antMatchers("/delete/**").hasAuthority("ADMIN")
//          .antMatchers("/restApi/service/**").permitAll()
//          .and()
//          .authorizeRequests()
//          .antMatchers("/product/**").permitAll()
//          .and()
//          .authorizeRequests()
//          .antMatchers("/customer/services/**").permitAll()
//        //RestApi service
//          .and()
//          .authorizeRequests()
//          .antMatchers("/restApi/service/**").permitAll()
//         // .authorizeRequests()
//          .antMatchers("/api/auth/**").permitAll()
//          .antMatchers("/api/test/**").permitAll()
//          .anyRequest().authenticated()
//          .and()
//          .formLogin().permitAll()
//          .and()
//          .logout().permitAll()
//          .and()
//          .exceptionHandling().accessDeniedPage("/403")
//          ;
//  }
//}

    
   // @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http.cors().and().csrf().disable()
          .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
          .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
          //apiGetway
          .authorizeRequests().antMatchers("/api/auth/**").permitAll()
          .antMatchers("/api/test/**").permitAll()
          .antMatchers("/restApi/**").permitAll()
          //product service
          .antMatchers("/product/**").permitAll()
          
        //RestApi service
   //       .and()
//          .authorizeRequests()
//          .antMatchers("/restApi/service/**").permitAll()
      //Customer service
          .and()
         .authorizeRequests()
         .antMatchers("/customer/services/**").permitAll()
         .anyRequest().authenticated();
      
      http.authenticationProvider(authenticationProvider());

    //  http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
      
      return http.build();
    }
}

 
 