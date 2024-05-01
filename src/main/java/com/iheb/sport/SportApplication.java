package com.iheb.sport;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.iheb.sport.entities.sport;
import com.iheb.sport.service.SportService;

@SpringBootApplication
public class SportApplication implements CommandLineRunner {
	
	@Autowired
	SportService sportservice;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(SportApplication.class, args);
	}
	
	/*@Override 
	public void run(String... args) throws Exception { 
		sportservice.saveSport(new sport("Description44", "sp10",new Date() )); 
		sportservice.saveSport(new sport("Description 55", "sp20",new Date() )); 
		sportservice.saveSport(new sport("Description 66 ", "sp30",new Date())); 
	} 
*/
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(sport.class);
	}

}
