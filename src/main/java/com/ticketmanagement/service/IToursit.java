package com.ticketmanagement.service;

import java.util.List;
import java.util.Optional;

import com.ticketmanagement.model.Tourist;

public interface IToursit {
	
	public String registerUser(Tourist t);
	public List<Tourist>fetchAllTourist();
	public Optional<Tourist> findById(Long id);
	public Tourist findByName(String name);
	public String updateTouristByDetails(Tourist t);

}
