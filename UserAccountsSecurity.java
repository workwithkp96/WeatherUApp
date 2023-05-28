package com.weatherapp.WeatherUapp.Security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//All the employee details are present in the database and the credential and role details can be obtained from the 
//members and roles table.
@Configuration
public class UserAccountsSecurity {
	
	@Bean
	public UserDetailsManager userDetailsManager(DataSource datasource)
	{
		JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(datasource);
		
		jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?");
		
		return jdbcUserDetailsManager;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests(configurer -> configurer
				.requestMatchers(HttpMethod.GET,"/api/useraccount").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET,"/api/useraccount/*").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.PUT,"/api/useraccount/*").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE,"/api/useraccount/*").hasRole("ADMIN")
				.requestMatchers(HttpMethod.POST,"/api/useraccount").hasRole("ADMIN")
				.requestMatchers(HttpMethod.POST,"/api/locations/*").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE,"/api/locations/*").hasRole("ADMIN")
				);
		
		http.httpBasic();
		
		http.csrf().disable();
		
		return http.build();
	}
}
