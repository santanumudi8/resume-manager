package com.example.model;

public class ResumeModel {

	private Long resumeId;
	
	private String companyName;
	
	private byte[] resumeDoc;

	public Long getResumeId() {
		return resumeId;
	}

	public void setResumeId(Long resumeId) {
		this.resumeId = resumeId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public byte[] getResumeDoc() {
		return resumeDoc;
	}

	public void setResumeDoc(byte[] resumeDoc) {
		this.resumeDoc = resumeDoc;
	}
	
	
}
