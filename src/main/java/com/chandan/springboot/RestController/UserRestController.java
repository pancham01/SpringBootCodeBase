package com.chandan.springboot.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chandan.springboot.entity.User;
import com.chandan.springboot.service.UserService;

@RestController
public class UserRestController {

	private UserService userService = null;

	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	
	
	
	@GetMapping("/user/{id}")
	public EntityModel<User> getUser(@PathVariable Long id) {
		User user = userService.getUserById(id).get();
		
		EntityModel<User> entityModel = EntityModel.of(user);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	
	
	
	@GetMapping("all-users")
	public List<User> retrieveAllUsers() {
		return userService.getAllUser();
	}


	
	
	
	
	
	
	
}
