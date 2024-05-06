package com.iheb.sport.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iheb.sport.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}
