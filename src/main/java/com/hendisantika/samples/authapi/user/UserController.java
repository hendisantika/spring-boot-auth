package com.hendisantika.samples.authapi.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-auth
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/10/17
 * Time: 05.31
 * To change this template use File | Settings | File Templates.
 */

@RestController
@RequestMapping("/users")
public class UserController {
	private ApplicationUserRepository applicationUserRepository;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserController(ApplicationUserRepository applicationUserRepository,

						  BCryptPasswordEncoder bCryptPasswordEncoder) {

		this.applicationUserRepository = applicationUserRepository;

		this.bCryptPasswordEncoder = bCryptPasswordEncoder;

	}

	@PostMapping("/sign-up")

	public void signUp(@RequestBody ApplicationUser user) {

		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		applicationUserRepository.save(user);

	}
}
