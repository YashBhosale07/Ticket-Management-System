package com.ticketmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketmanagement.dao.TouristRepo;
import com.ticketmanagement.exception.TouristNotFoundException;
import com.ticketmanagement.model.Tourist;

@Service
public class TouristServiceImpl implements IToursit {

	@Autowired
	private TouristRepo repo;
	
	@Override
	public String registerUser(Tourist t) {
		// TODO Auto-generated method stub
		Long id=repo.save(t).getId();
		return "Toursit registerd having the ticket id:: "+id;
	}

	@Override
	public List<Tourist> fetchAllTourist() {
		List<Tourist> list=repo.findAll();
//		list.sort(Comparator.comparingLong(t1->t1.getId()));
		list.sort((t1,t2)->t1.getId().compareTo(t2.getId()));
		return list;
	}

	@Override
	public Optional<Tourist> findById(Long id) {
		return repo.findById(id);
	}

	@Override
	public Tourist findByName(String name) {
		return repo.findByName(name)
				.orElseThrow(()->new TouristNotFoundException("Toursit not found with name: "+name));
	}

	

}
