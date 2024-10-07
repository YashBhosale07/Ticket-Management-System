package com.ticketmanagement.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketmanagement.model.Tourist;

@Repository
public interface TouristRepo extends JpaRepository<Tourist, Long> {
	
	Optional<Tourist>findByName(String name);

}
