package com.epam.mentor.bean;

import java.util.Date;

public class MentorBean {

	private String Name;
	private String Email;
	private Date mentorStartDate;
	private Date mentorEndDate;
	private int maxNoOfMentees;
	private String technologyStream;
	private String Status;

	
	public String getName() {
		
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Date getMentorStartDate() {
		return mentorStartDate;
	}
	public void setMentorStartDate(Date mentorStartDate) {
		this.mentorStartDate = mentorStartDate;
	}
	public Date getMentorEndDate() {
		return mentorEndDate;
	}
	public void setMentorEndDate(Date mentorEndDate) {
		this.mentorEndDate = mentorEndDate;
	}
	public int getMaxNoOfMentees() {
		return maxNoOfMentees;
	}
	public void setMaxNoOfMentees(int maxNoOfMentees) {
		this.maxNoOfMentees = maxNoOfMentees;
	}
	public String getTechnologyStream() {
		
		return technologyStream;
	}
	public void setTechnologyStream(String technologyStream) {
		this.technologyStream = technologyStream;
	}
	public String getStatus() {
		
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
}
