package com.iheb.sport.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iheb.sport.entities.sport;
import com.iheb.sport.service.SportService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SportRESTController {
	@Autowired
	SportService sportService;

	@RequestMapping(method = RequestMethod.GET)
	public List<sport> getAllSports() {
		return sportService.getAllSports();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public sport getSportById(@PathVariable("id") Long id) {
		return sportService.getSport(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public sport createSport(@RequestBody sport sp) {
		return sportService.saveSport(sp);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public sport updateSport(@RequestBody sport sp) {
		return sportService.updateSport(sp);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id) {
		sportService.deleteSportById(id);
	}

	@RequestMapping(value = "/sportsgen/{idGen}", method = RequestMethod.GET)
	public List<sport> getProduitsByCatId(@PathVariable("idGen") Long idGen) {
		return sportService.findByGenreIdGen(idGen);
	}

}
