package com.restapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/public").permitAll()
                .anyRequest().authenticated();
    }
}

//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
//public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//@Autowired
//UserDetailsServiceImpl userDetailsService;
//
//@Override
//protected void configure(HttpSecurity http) throws Exception {
//  http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) 
//    .and().authorizeRequests().antMatchers("/oauth/token")
//    .permitAll().anyRequest().authenticated();
//}
//
//@Bean
//public DaoAuthenticationProvider authenticationProvider() {
//  DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//  provider.setPasswordEncoder( bCryptPasswordEncoder() );
//  provider.setUserDetailsService(userDetailsService);
//  return provider;
//}
//
//@Bean
//public BCryptPasswordEncoder bCryptPasswordEncoder() {
//  return new BCryptPasswordEncoder();
//}
//
//@Override
//@Bean
//public AuthenticationManager authenticationManagerBean() throws Exception {
//  return super.authenticationManagerBean();
//}
//@Autowired
//public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//  auth.authenticationProvider(authenticationProvider());
//}
//}