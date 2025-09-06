package com.chandan.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chandan.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
