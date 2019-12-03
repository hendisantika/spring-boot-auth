package com.hendisantika.samples.authapi.task;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-auth
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/10/17
 * Time: 05.48
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

	private TaskRepository taskRepository;

	public TaskController(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@PostMapping
	public void addTask(@RequestBody Task task) {
		taskRepository.save(task);
	}

	@GetMapping
	public List<Task> getTasks() {
		return taskRepository.findAll();
	}

	@PutMapping("/{id}")
	public void editTask(@PathVariable long id, @RequestBody Task task) {
		Optional<Task> optionalTask = taskRepository.findById(id);
		Task task1 = optionalTask.get();
		Assert.notNull(optionalTask, "Task not found");
		task1.setDescription(task.getDescription());
		taskRepository.save(task1);
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable long id) {
		taskRepository.deleteById(id);
	}
}
