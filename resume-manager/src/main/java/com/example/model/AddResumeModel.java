package com.example.model;

public class AddResumeModel {

	private Long personId; //Assuming this id is a valid id and it is present in DB
	
	private String companyName;

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
}
