package com.iheb.sport.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iheb.sport.entities.sport;



public interface SportRepository extends JpaRepository<sport, Long> {

}

