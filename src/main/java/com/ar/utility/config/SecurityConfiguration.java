package com.ar.utility.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService UserDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * // In memory Authentication
		 * auth.inMemoryAuthentication().withUser("user").password("user").roles("USER")
		 * .and().withUser("admin").password("admin").roles("ADMIN");
		 */
		auth.userDetailsService(new UserDetailsServiceImpl());
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors();
		/*
		 * http.httpBasic().and().authorizeRequests().antMatchers("/v1/**").hasRole(
		 * "ADMIN").antMatchers("/user") .hasAnyRole("USER", "ADMIN").antMatchers("/",
		 * "/about").permitAll().and().csrf()
		 * .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		 */
		http.httpBasic().and().authorizeRequests().antMatchers("/**", "/about").permitAll().and().csrf()
		.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

	}
}
