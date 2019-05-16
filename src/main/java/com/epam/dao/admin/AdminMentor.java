package com.epam.dao.admin;

public class AdminMentor {

	String emailid;
	String mentorname;
	String mentorshipstartdate;
	String 	mentorshipenddate;
	String maxnoofmentees;
	String technologystream;
	String status;
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getMentorshipStartDate() {
		return mentorshipstartdate;

	}
	public void setMentorshipStartDate(String mentorshipstartdate) {
		this.mentorshipstartdate = mentorshipstartdate;
	}
	public String getMentorShipEnddate() {
		return mentorshipenddate;
	}
	public void setMentorShipEndDate(String mentorshipenddate) {
		this.mentorshipenddate = mentorshipenddate;
	}
	public String getMaxnoOfMentees() {
		return maxnoofmentees;
	}
	public void setMaxnoOfMentees(String maxnoofmentees) {
		this.maxnoofmentees = maxnoofmentees;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getMentorName() {
		return mentorname;
	}
	public void setMentorName(String mentorname) {
		this.mentorname = mentorname;
	}
	public String getTechnologyStream() {
		return technologystream;
	}
	public void setTechnologyStream(String technologystream) {
		this.technologystream = technologystream;
	}

}

