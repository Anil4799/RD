package com.epam.dao.admin;

import java.util.Date;

public class MentorBean {

	private String name;
	private String email;
	private Date mentorStartDate;
	private Date mentorEndDate;
	private int maxNoOfMentees;
	private String technologyStream;
	private String status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
}
