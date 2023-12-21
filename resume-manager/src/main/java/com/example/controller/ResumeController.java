package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.AddResumeModel;
import com.example.service.ResumeService;

@RestController
@RequestMapping("/v1")
public class ResumeController {
	
	@Autowired
	private ResumeService resumeService;

	@PostMapping(path = "/add/resume")
	ResponseEntity<String> addResume(@RequestParam(name = "personId") Long personId, @RequestParam(name = "companyName") String companyName, @RequestParam(name = "resumeFile") MultipartFile resumeFile){
		String response = "";
		try {
			response = resumeService.addResume(personId, companyName, resumeFile);
		}
		catch(Exception e) {
			e.printStackTrace();
			response = "Error while adding resume";
			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(response, HttpStatus.CREATED);
	}
	
}
