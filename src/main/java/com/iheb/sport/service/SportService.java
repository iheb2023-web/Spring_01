package com.iheb.sport.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.iheb.sport.entities.Genre;
import com.iheb.sport.entities.sport;


public interface SportService {
	sport saveSport(sport p);
	sport updateSport(sport p);
	void deleteSport(sport p);
	void deleteSportById(Long id);
	sport getSport(Long id);
	List<sport> getAllSports();
	Page<sport> getAllSportsParPage(int page, int size);
	
	List<sport> findByNomSport(String nom);
	List<sport> findByNomSportContains(String nom);
	List<sport> findByNomDateFondation (String nom, int annee);
	List<sport> findByGenre (Genre categorie);
	List<sport> findByGenreIdGen(Long id);
	List<sport> findByOrderByNomSportAsc();
	List<sport> trierSportsNomsDate();

}
