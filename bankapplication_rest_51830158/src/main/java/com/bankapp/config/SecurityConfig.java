package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bankapp.model.service.SpringUserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SpringUserDetailsService userDetailService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailService);
	}
	
	@Bean
	public BCryptPasswordEncoder encryptor(){
		return new BCryptPasswordEncoder();
	}
	
//	we can use this also as it is interface
//	@Bean
//	public PasswordEncoder encryptoranother(){
//		return new BCryptPasswordEncoder();
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().
		sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.authorizeRequests().antMatchers("/api/user/**").hasRole("ADMIN").and()
		.authorizeRequests().antMatchers("/api/customer/**").hasRole("ADMIN").and()
		.authorizeRequests().antMatchers("/api/transactionLog/**").hasRole("ADMIN").and()
		.authorizeRequests().antMatchers("/api/account/**").hasAnyRole("ADMIN","MGR").and()
		.authorizeRequests().antMatchers("/api/transaction/**").hasAnyRole("ADMIN","MGR","CLERK").and()
		.httpBasic();
	}

}
