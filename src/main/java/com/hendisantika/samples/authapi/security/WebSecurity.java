package com.hendisantika.samples.authapi.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.hendisantika.samples.authapi.security.SecurityConstants.SIGN_UP_URL;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-auth
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/10/17
 * Time: 05.39
 * To change this template use File | Settings | File Templates.
 */

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	private UserDetailsService userDetailsService;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecurity(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {

		this.userDetailsService = userDetailsService;

		this.bCryptPasswordEncoder = bCryptPasswordEncoder;

	}

	@Override

	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests()

				.antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()

				.anyRequest().authenticated()

				.and()

				.addFilter(new JWTAuthenticationFilter(authenticationManager()))

				.addFilter(new JWTAuthorizationFilter(authenticationManager()));

	}

	@Override

	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

	}
}
