package com.hendisantika.samples.authapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-auth
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 02/11/17
 * Time: 05.45
 * To change this template use File | Settings | File Templates.
 */

@RestController
public class HelloWorldController {
	@RequestMapping("/")
	public Message index() {
		return new Message("Greetings from Spring Boot!");
	}
}
