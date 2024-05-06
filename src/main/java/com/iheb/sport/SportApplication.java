package com.iheb.sport;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.iheb.sport.entities.Role;
import com.iheb.sport.entities.User;
import com.iheb.sport.entities.sport;
import com.iheb.sport.service.SportService;
import com.iheb.sport.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SportApplication implements CommandLineRunner {

	@Autowired
	SportService sportservice;

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SportApplication.class, args);
	}

	/*
	 * @Override public void run(String... args) throws Exception {
	 * sportservice.saveSport(new sport("Description44", "sp10",new Date() ));
	 * sportservice.saveSport(new sport("Description 55", "sp20",new Date() ));
	 * sportservice.saveSport(new sport("Description 66 ", "sp30",new Date())); }
	 */
	

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(sport.class);
		 System.out.println("Password Encoded BCRYPT :******************** ");
		 System.out.println(passwordEncoder.encode("123"));
	}
	
	/*@PostConstruct
	void init_users() {
	//ajouter les rôles
	userService.addRole(new Role(null,"ADMIN"));
	userService.addRole(new Role(null,"AGENT"));
	userService.addRole(new Role(null,"USER"));
	//ajouter les users
	userService.saveUser(new User(null,"admin","123",true,null));
	userService.saveUser(new User(null,"iheb","123",true,null));
	userService.saveUser(new User(null,"user1","123",true,null));
	//ajouter les rôles aux users
	userService.addRoleToUser("admin", "ADMIN");
	userService.addRoleToUser("iheb", "USER");
	userService.addRoleToUser("iheb", "AGENT");
	userService.addRoleToUser("user1", "USER");
	}*/

}
