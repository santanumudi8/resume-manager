package com.example.service.impl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Person;
import com.example.entity.Resume;
import com.example.model.AddResumeModel;
import com.example.repository.PersonRepository;
import com.example.repository.ResumeRepository;
import com.example.service.ResumeService;

@Service
public class ResumeServiceImpl implements ResumeService{
	
	@Autowired
	private ResumeRepository resumeRepository;
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public String addResume(Long personId, String companyName, MultipartFile resumeFile) throws IOException {
		Resume resume = new Resume();
		Optional<Person> personDetails = personRepository.findById(personId);
		resume.setCompanyName(companyName);
		resume.setPerson(personDetails.get());
		resume.setResumeDoc(resumeFile.getBytes());
		resumeRepository.save(resume);
		String response = "Resume Details Added Successfully!!";
		return response;
	}

}
