package com.example.service;

import org.springframework.stereotype.Service;

import com.example.entity.Person;
import com.example.model.PersonDetailsResponse;

public interface PersonService {

	String addPerson(Person person);

	PersonDetailsResponse getPersonDetails(Long personId);

}
