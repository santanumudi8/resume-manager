package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Person;
import com.example.model.PersonDetailsResponse;
import com.example.model.ResumeModel;
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

	@Override
	public PersonDetailsResponse getPersonDetails(Long personId) {
		
		PersonDetailsResponse personDetailsResponse = new PersonDetailsResponse();
//		Optional<Person> person = personRepository.findById(personId);
		
		List<Object[]> personDetails = personRepository.getPersonDetails(personId);
		
		List<ResumeModel> resumeModels = new ArrayList<ResumeModel>();
		
		personDetails.stream().forEach(person->{
			ResumeModel resumeModel = new ResumeModel();
			resumeModel.setResumeId(((Long)person[2]).longValue());
			resumeModel.setCompanyName(String.valueOf(person[3]));
			resumeModel.setResumeDoc((byte[])person[4]);
			resumeModels.add(resumeModel);
		});
		
		
		personDetailsResponse.setId(personId);
		personDetailsResponse.setName(String.valueOf(personDetails.get(0)[1]));
		personDetailsResponse.setResumeList(resumeModels);
		
		return personDetailsResponse;
	}

}
