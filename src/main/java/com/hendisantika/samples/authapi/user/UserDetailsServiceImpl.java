package com.hendisantika.samples.authapi.user;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-auth
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/10/17
 * Time: 05.40
 * To change this template use File | Settings | File Templates.
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private ApplicationUserRepository applicationUserRepository;

	public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {

		this.applicationUserRepository = applicationUserRepository;

	}

	@Override

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);

		if (applicationUser == null) {

			throw new UsernameNotFoundException(username);

		}

		return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());

	}
}
