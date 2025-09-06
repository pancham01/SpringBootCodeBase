package com.chandan.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.chandan.springboot.entity.User;

public interface UserService {

	public ResponseEntity<User> saveUser(User user);

	public Optional<User> getUserById(Long userId);

	public ResponseEntity<List<User>> getAllUser();

	public ResponseEntity<String> deleteUserById(Long userId);

	public ResponseEntity<User> updateUserById(User user, Long userId);
}
