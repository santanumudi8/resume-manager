package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Person;
import com.example.model.PersonModel;
import com.example.repository.PersonRepository;
import com.example.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public String addPerson(Person person) {
		personRepository.save(person);
		String response = "Person Details Added Successfully!!";
		return response;
	}

}
