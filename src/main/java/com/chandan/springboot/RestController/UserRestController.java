package com.chandan.springboot.RestController;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.chandan.springboot.entity.User;
import com.chandan.springboot.exception.UserNotFoundException;
import com.chandan.springboot.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class UserRestController {
	@Autowired
	private MessageSource messageSource;
	
	
	public UserRestController()
	{
	}
	public UserRestController(MessageSource messageSource)
	{
		this.messageSource=messageSource;
	}

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
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user, BindingResult result) {
		if (result.hasErrors()) {
			HashMap<String, String> errorsMap = new HashMap<>();
			List<FieldError> fieldErrors = result.getFieldErrors();
			for (FieldError f : fieldErrors) {
				errorsMap.put(f.getField(), f.getDefaultMessage());
			}
			return ResponseEntity.badRequest().body(errorsMap);
		}
		User saveUser = userService.saveUser(user);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getUserId())
				.toUri();
		return ResponseEntity.created(uri).body(saveUser);
	}

	@GetMapping(value = "/getUserById/{id}", produces = { MediaType.APPLICATION_XML_VALUE })
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
	
	@GetMapping
	public String implI18n(Locale locale)
	{
		System.err.println("UserRestController.implI18n()");
		return messageSource.getMessage("greeting", null, locale);
	}
}
