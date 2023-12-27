package com.example.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.model.AddResumeModel;

public interface ResumeService {

	String addResume(Long personId, String companyName, MultipartFile resumeFile) throws IOException, Exception;

	byte[] getResume(Long resumeId);

}
