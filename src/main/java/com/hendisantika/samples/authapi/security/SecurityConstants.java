package com.hendisantika.samples.authapi.user;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-auth
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/10/17
 * Time: 05.36
 * To change this template use File | Settings | File Templates.
 */
public class SecurityConstants {
	public static final String SECRET = "SecretKeyToGenJWTs";

	public static final long EXPIRATION_TIME = 864_000_000; // 10 days

	public static final String TOKEN_PREFIX = "Bearer ";

	public static final String HEADER_STRING = "Authorization";

	public static final String SIGN_UP_URL = "/users/sign-up";
}
