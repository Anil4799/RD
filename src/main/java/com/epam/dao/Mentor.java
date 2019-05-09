package com.epam.dao;

public class Mentor {
	String email_id;
	
	String mentor_name;
	String mentorship_start_date;
	String 	mentorship_end_date;
	String max_no_of_mentees;
	String technology_stream;
	String status;
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getMentorship_start_date() {
		return mentorship_start_date;
	}
	public void setMentorship_start_date(String mentorship_start_date) {
		this.mentorship_start_date = mentorship_start_date;
	}
	public String getMentorship_end_date() {
		return mentorship_end_date;
	}
	public void setMentorship_end_date(String mentorship_end_date) {
		this.mentorship_end_date = mentorship_end_date;
	}
	public String getMax_no_of_mentees() {
		return max_no_of_mentees;
	}
	public void setMax_no_of_mentees(String max_no_of_mentees) {
		this.max_no_of_mentees = max_no_of_mentees;
	}
	
	public String getMentor_name() {
		return mentor_name;
	}
	public void setMentor_name(String mentor_name) {
		this.mentor_name = mentor_name;
	}
	public String getTechnology_stream() {
		return technology_stream;
	}
	public void setTechnology_stream(String technology_stream) {
		this.technology_stream = technology_stream;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}

