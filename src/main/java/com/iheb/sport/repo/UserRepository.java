package com.iheb.sport.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iheb.sport.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}