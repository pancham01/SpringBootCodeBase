package com.chandan.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.chandan.springboot.entity.User;
import com.chandan.springboot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;

	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public Optional<User> getUserById(Long userId) {
		Optional<User> userById = userRepo.findById(userId);
		return userById;
	}

	@Override
	public ResponseEntity<List<User>> getAllUser() {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(userRepo.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@Override
	public ResponseEntity<String> deleteUserById(Long userId) {

		Optional<User> user = userRepo.findById(userId);

		if (user.isPresent()) {
			userRepo.deleteById(userId);
			return ResponseEntity.status(HttpStatus.OK).body("User with given id is deleted successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@Override
	public ResponseEntity<User> updateUserById(User userNew, Long userId) {

		Optional<User> getUserById = userRepo.findById(userId);

		if (getUserById.isPresent()) {

			User updateUser = getUserById.get();
			updateUser.setUserFullName(userNew.getUserFullName());
			updateUser.setUserEmail(userNew.getUserEmail());
			updateUser.setUserCity(userNew.getUserCity());
			updateUser.setUserGender(userNew.getUserGender());
			updateUser.setUserMob(userNew.getUserMob());

			return ResponseEntity.status(HttpStatus.OK).body(userRepo.save(updateUser));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
