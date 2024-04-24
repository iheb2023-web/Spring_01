package com.iheb.sport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.iheb.sport.entities.sport;
import com.iheb.sport.repo.SportRepository;

@Service
public class SportServiceImpl implements SportService {
	
	@Autowired
	SportRepository sportRepository;

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
}