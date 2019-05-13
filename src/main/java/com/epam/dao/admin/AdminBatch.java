package com.epam.dao.admin;

public class AdminBatch {
	
	private int batch_num;
	private String batch_id;
	private int year_num;
	private String quarter_num;
	private String start_date;
	private String end_date;
	private String status;
	
	public int getBatch_num() {
		return batch_num;
	}
	public void setBatch_num(int batch_num) {
		this.batch_num = batch_num;
	}
	public String getBatch_id() {
		return batch_id;
	}
	public void setBatch_id(String batch_id) {
		this.batch_id = batch_id;
	}
	public int getYear_num() {
		return year_num;
	}
	public void setYear_num(int year_num) {
		this.year_num = year_num;
	}
	public String getQuarter_num() {
		return quarter_num;
	}
	public void setQuarter_num(String quarter_num) {
		this.quarter_num = quarter_num;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
