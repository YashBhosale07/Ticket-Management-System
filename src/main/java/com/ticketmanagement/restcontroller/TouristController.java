package com.ticketmanagement.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketmanagement.exceptionhandling.TouristNotFoundException;
import com.ticketmanagement.model.Tourist;
import com.ticketmanagement.service.IToursit;


@RestController
@RequestMapping("/api/tourist")
public class TouristController {
	
	@Autowired
	private IToursit service;
	
	@PostMapping("/register")
	public ResponseEntity<String>enrollToursit(@RequestBody Tourist tourist){
		try {
			String msg=service.registerUser(tourist);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Problem in tourist enrollment",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<?>fetchAll(){
		try {
			List<Tourist>list=service.fetchAllTourist();
			return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Problem in fetching tourist",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<?>displayTouristById(@PathVariable Long id){
			Tourist tourist=service.findById(id)
					.orElseThrow(()->new TouristNotFoundException("Toursit not found with id: "+id));
				return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
		
	}
	@GetMapping("/findByName/{name}")
	public ResponseEntity<Tourist>findTouristByName(@PathVariable String name){
		Tourist t=service.findByName(name);
		return new ResponseEntity<Tourist>(t,HttpStatus.OK);
	}
	
}
