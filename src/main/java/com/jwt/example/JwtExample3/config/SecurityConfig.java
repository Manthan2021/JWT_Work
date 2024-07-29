package com.jwt.example.JwtExample3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jwt.example.JwtExample3.security.JwtAuthenticationEntryPoint;
import com.jwt.example.JwtExample3.security.JwtAuthenticationFilter;

@Configuration

public class SecurityConfig  {

	@Autowired
	private JwtAuthenticationEntryPoint point;
	
	@Autowired
	private JwtAuthenticationFilter filter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		//configuration
		http.csrf(csrf->csrf.disable())
		.cors(cors->cors.disable())
		.authorizeHttpRequests(
				auth->
		auth.requestMatchers("/home/**").authenticated()
		.requestMatchers("/auth/login").permitAll()
		.anyRequest().authenticated())
		.exceptionHandling(ex->ex.authenticationEntryPoint(point))
		.sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		// http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);		
		
	http.addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class);	
		
		
		return http.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception{
		return configuration.getAuthenticationManager();
		
	}
	
	
}
