package com.epam.dao.mentor;

public class MentorStudent {
	String mentorStudentName;
	String mentorStudentBatch;
	String mentorStudentCoreSkill;
	String mentorStudentStatus;
	String mentorStudentEmailId;
	
	public String getName() {
		return  mentorStudentName;
	}
	public void setName(String  mentorStudentName) {
		this.mentorStudentName =  mentorStudentName;
	}
	public String getBatch() {
		return mentorStudentBatch;
	}
	public void setBatch(String mentorStudentBatch) {
		this.mentorStudentBatch = mentorStudentBatch;
	}
	public String getCoreSkill() {
		return mentorStudentCoreSkill;
	}
	public void setCoreSkill(String mentorStudentCoreSkill) {
		this.mentorStudentCoreSkill = mentorStudentCoreSkill;
	}
	
	public String getStatus() {
		return mentorStudentStatus;
	}
	public void setStatus(String mentorStudentStatus) {
		this.mentorStudentStatus = mentorStudentStatus;
	}
	public String getEmail() {
		return mentorStudentEmailId;
	}
	public void setEmail(String mentorStudentEmailId) {
		this.mentorStudentEmailId = mentorStudentEmailId;
	}
	
	
}
