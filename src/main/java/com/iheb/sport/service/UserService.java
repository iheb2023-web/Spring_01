package com.iheb.sport.service;


import com.iheb.sport.entities.Role;
import com.iheb.sport.entities.User;


public interface UserService {
	
	void deleteAllusers();

	void deleteAllRoles();

	User saveUser(User user);

	User findUserByUsername(String username);

	Role addRole(Role role);

	User addRoleToUser(String username, String rolename);
}
