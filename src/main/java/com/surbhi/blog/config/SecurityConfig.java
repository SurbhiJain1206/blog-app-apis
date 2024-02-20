package com.surbhi.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;

import com.surbhi.blog.security.CustomUserDetailService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(c->c
                        .requestMatchers("/").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();
    }
    
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService) 
//      throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//          .userDetailsService(userDetailsService)
//          .passwordEncoder(bCryptPasswordEncoder)
//          .and()
//          .build();
//    }
    
    
    
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService) 
      throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
          .userDetailsService(userDetailsService)
          .passwordEncoder(bCryptPasswordEncoder)
          .and()
          .build();
    }	
    
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
    	return new InMemoryUserDetailsManager(this.customUserDetailService);
    }
    
    
    
}