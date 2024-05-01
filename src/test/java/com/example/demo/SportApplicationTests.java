package com.example.demo;

import com.iheb.sport.SportApplication;
import com.iheb.sport.entities.Genre;
import com.iheb.sport.entities.sport;
import com.iheb.sport.repo.SportRepository;
import com.iheb.sport.service.SportService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

@SpringBootTest(classes = SportApplication.class)
public class SportApplicationTests {

	@Autowired
	private SportRepository sportRepository;

	@Autowired
	private SportService sportService;

	/*
	 * @Test public void testCreateProduit() { sport prod = new sport("football",
	 * "sport collectif", new Date()); sportRepository.save(prod); }
	 * 
	 * @Test public void testFindProduit() { sport p =
	 * sportRepository.findById(2L).get(); System.out.println(p); }
	 * 
	 * @Test public void testUpdateProduit() { sport p =
	 * sportRepository.findById(2L).get();
	 * p.setDescription("sport joeur en equipe"); sportRepository.save(p); }
	 * 
	 * 
	 * 
	 * @Test public void testListerTousProduits() { List<sport> prods =
	 * sportRepository.findAll(); for (sport p : prods) { System.out.println(p); } }
	 */

	/*
	 * @Test public void testFindByNomProduitContains() { Page<sport> prods =
	 * sportService.getAllSportsParPage(0, 2); System.out.println(prods.getSize());
	 * System.out.println(prods.getTotalElements());
	 * System.out.println(prods.getTotalPages());
	 * 
	 * prods.getContent().forEach(p -> {System.out.println(p.toString()); }); }
	 */

	/*
	 * @Test public void testFindByNomSport() { List<sport> prods =
	 * sportRepository.findByNomSport("Cyclisme"); for (sport p : prods) {
	 * System.out.println(p); } }
	 * 
	 * @Test public void testFindByNomSportContains () { List<sport>
	 * prods=sportRepository.findByNomSportContains("ll"); for (sport p : prods) {
	 * System.out.println(p); } }
	 * 
	 * @Test public void testFindByNomAndYear() { List<sport> sports =
	 * sportRepository.findByNomAndYearAfter("ugby", 1800);
	 * 
	 * for (sport p : sports) { System.out.println(p); } }
	 
	@Test
	public void testfindByCategorie() {
		Genre gen = new Genre();
		gen.setIdGen(2L);
		List<sport> sports = sportRepository.findByGenre(gen);
		for (sport p : sports) {
			System.out.println(p);
		}
	}

	@Test
	public void findByGenreIdGen() {
		List<sport> sports = sportRepository.findByGenreIdGen(1L);
		for (sport p : sports) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testfindByOrderByNomSportAsc() {
		List<sport> sports = sportRepository.findByOrderByNomSportAsc();
		for (sport p : sports) {
			System.out.println(p);
		}
	}
	*/
	@Test
	public void testTrierProduitsNomsDate() {
		List<sport> sports = sportRepository.trierSportsNomsDateFondation();
		for (sport p : sports) {
			System.out.println(p);
		}
	}


}