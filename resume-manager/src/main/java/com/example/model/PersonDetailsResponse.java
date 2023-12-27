package com.example.model;

import java.util.List;

import com.example.entity.Resume;

public class PersonDetailsResponse {

	private Long id;
	
	private String name;
	
	private List<ResumeModel> resumeList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ResumeModel> getResumeList() {
		return resumeList;
	}

	public void setResumeList(List<ResumeModel> resumeList) {
		this.resumeList = resumeList;
	}
	
	
}
