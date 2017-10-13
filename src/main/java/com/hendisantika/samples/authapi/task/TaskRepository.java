package com.hendisantika.samples.authapi.task;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-auth
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/10/17
 * Time: 05.46
 * To change this template use File | Settings | File Templates.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
}
