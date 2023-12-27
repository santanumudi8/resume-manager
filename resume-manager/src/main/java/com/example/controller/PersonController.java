package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Person;
import com.example.model.PersonDetailsResponse;
import com.example.service.PersonService;

@RestController
@RequestMapping("v1/api/")
public class PersonController {
	
	public static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private PersonService personService;

	@PostMapping(path = "/add/personDetails")
	ResponseEntity<String> addPerson(@RequestBody Person person){
		long startTime = System.currentTimeMillis();
		String response = personService.addPerson(person);
		long endTime = System.currentTimeMillis();
		logger.info("Person added completed in {} ms", endTime - startTime);
		return new ResponseEntity<String>(response, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/get/person-details/{personId}")
	ResponseEntity<PersonDetailsResponse> getPersonDetails(@PathVariable(name = "personId") Long personId){
		
		PersonDetailsResponse personDetails = personService.getPersonDetails(personId);
		
		return new ResponseEntity<PersonDetailsResponse>(personDetails, HttpStatus.OK);
	}
}
