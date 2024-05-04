package com.iheb.sport.service;

import java.util.List;

import com.iheb.sport.repo.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.iheb.sport.entities.Genre;
import com.iheb.sport.entities.sport;
import com.iheb.sport.repo.SportRepository;

@Service
public class SportServiceImpl implements SportService {
	
	@Autowired
	SportRepository sportRepository;

	@Autowired
	GenreRepository genreRepository;

	@Override
	public sport saveSport(sport p) {
		return sportRepository.save(p);
	}

	@Override
	public sport updateSport(sport p) {
		return sportRepository.save(p);
	}

	@Override
	public void deleteSport(sport p) {
		sportRepository.delete(p);
	}

	@Override
	public void deleteSportById(Long id) {
		sportRepository.deleteById(id);
	}

	@Override
	public sport getSport(Long id) {
		return sportRepository.findById(id).get();
	}

	@Override
	public List<sport> getAllSports() {
		return sportRepository.findAll();
	}
	
	@Override 
	public Page<sport> getAllSportsParPage(int page, int size) { 
	return sportRepository.findAll(PageRequest.of(page, size)); 
	} 
	
	
	@Override
	public List<sport> findByNomSport(String nom) {
	    return sportRepository.findByNomSport(nom);
	}

	@Override
	public List<sport> findByNomSportContains(String nom) {
	    return sportRepository.findByNomSportContains(nom);
	}

	@Override
	public List<sport> findByNomDateFondation(String nom, int annee) {
	    return sportRepository.findByNomAndYear(nom, annee);
	}

	@Override
	public List<sport> findByGenre(Genre genre) {
	    return sportRepository.findByGenre(genre);
	}

	@Override
	public List<sport> findByGenreIdGen(Long id) {
	    return sportRepository.findByGenreIdGen(id);
	}

	@Override
	public List<sport> findByOrderByNomSportAsc() {
	    return sportRepository.findByOrderByNomSportAsc();
	}

	@Override
	public List<sport> trierSportsNomsDate() {
	    return sportRepository.trierSportsNomsDateFondation();
	}

	@Override
	public List<Genre> getAllGenres() {
		return genreRepository.findAll();
	}

}