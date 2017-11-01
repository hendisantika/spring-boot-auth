package com.hendisantika.samples.authapi.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hendisantika.samples.authapi.user.ApplicationUser;
import com.hendisantika.samples.authapi.user.ApplicationUserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.hendisantika.samples.authapi.security.SecurityConstants.*;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-auth
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/10/17
 * Time: 05.34
 * To change this template use File | Settings | File Templates.
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private AuthenticationManager authenticationManager;
	private ApplicationUserRepository applicationUserRepository;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, ApplicationUserRepository applicationUserRepository) {

		this.authenticationManager = authenticationManager;
		this.applicationUserRepository = applicationUserRepository;

	}

	@Override

	public Authentication attemptAuthentication(HttpServletRequest req,

												HttpServletResponse res) throws AuthenticationException {

		try {

			ApplicationUser creds = new ObjectMapper()

					.readValue(req.getInputStream(), ApplicationUser.class);

			return authenticationManager.authenticate(

					new UsernamePasswordAuthenticationToken(

							creds.getUsername(),

							creds.getPassword(),

							new ArrayList<>())

			);

		} catch (IOException e) {

			throw new RuntimeException(e);

		}

	}

	@Override

	protected void successfulAuthentication(HttpServletRequest req,

											HttpServletResponse res,

											FilterChain chain,

											Authentication auth) throws IOException, ServletException {

		String token = Jwts.builder()

				.setSubject(((User) auth.getPrincipal()).getUsername())

				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))

				.signWith(SignatureAlgorithm.HS512, SECRET)

				.compact();

		res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);

	}
}
