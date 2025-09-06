package com.chandan.springboot.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandan.springboot.entity.User;
import com.chandan.springboot.exception.UserNotFoundException;
import com.chandan.springboot.service.UserService;

@RestController
@RequestMapping(value = "/api")
public class UserRestController {

	private UserService userService = null;

	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/getHome")
	public ResponseEntity<String> getHome() {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Home page called with @GetMapping and @ResponseEntity object");
	}

	@PostMapping(value = "/saveUser")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping(value = "/getUserById/{id}")
	public ResponseEntity getUserById(@PathVariable(value = "id") Long userId) {
		Optional<User> user = userService.getUserById(userId);
		if (user.isEmpty()) {
			throw new UserNotFoundException("This user is not available");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}

	}

	@GetMapping(value = "/getAllUser")
	public ResponseEntity<List<User>> getAllAvailableUser() {
		return userService.getAllUser();
	}

	@PatchMapping(value = "/updateUserById/{id}")
	public ResponseEntity<User> updateUserById(@RequestBody User user, @PathVariable(value = "id") Long userId) {
		return userService.updateUserById(user, userId);
	}

	@DeleteMapping(value = "/deleteUserById/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable(value = "id") Long userId) {
		return userService.deleteUserById(userId);
	}
}
