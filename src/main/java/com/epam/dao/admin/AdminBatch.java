package com.epam.dao.admin;

public class AdminBatch {
	
	private int batchnum;
	private String batchid;
	private int yearnum;
	private String quarternum;
	private String startdate;
	private String enddate;
	private String status;
	
	
	public int getBatchNum() {
		return batchnum;
	}
	public void setBatchNum(int batchnum) {
		this.batchnum = batchnum;
	}
	public String getBatchId() {
		return batchid;
	}
	public void setBatchId(String batchid) {
		this.batchid = batchid;
	}
	public int getYearNum() {
		return yearnum;
	}
	public void setYearNum(int yearnum) {
		this.yearnum = yearnum;
	}
	public String getQuarterNum() {
		return quarternum;
	}
	public void setQuarterNum(String quarternum) {
		this.quarternum = quarternum;
	}
	public String getStartDate() {
		return startdate;
	}
	public void setStartDate(String startdate) {
		this.startdate = startdate;
	}
	public String getEndDate() {
		return enddate;
	}
	public void setEnd_date(String enddate) {
		this.enddate = enddate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
