package com.hendisantika.samples.authapi.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-auth
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/10/17
 * Time: 05.29
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class ApplicationUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;

	private String username;

	private String password;

	public long getId() {

		return id;

	}

	public String getUsername() {

		return username;

	}

	public void setUsername(String username) {

		this.username = username;

	}

	public String getPassword() {

		return password;

	}

	public void setPassword(String password) {

		this.password = password;

	}
}
