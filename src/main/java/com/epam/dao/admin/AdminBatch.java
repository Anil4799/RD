package com.epam.dao.admin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminBatch {
	
	private int batchnum;
	private String batchid;
	private int yearnum;
	private String quarternum;
	private String startdate;
	private String enddate;
	private String status;
	
	
	
	
	public int getBatchnum() {
		return batchnum;
	}




	public void setBatchnum(int batchnum) {
		this.batchnum = batchnum;
	}




	public String getBatchid() {
		return batchid;
	}




	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}




	public int getYearnum() {
		return yearnum;
	}




	public void setYearnum(int yearnum) {
		this.yearnum = yearnum;
	}




	public String getQuarternum() {
		return quarternum;
	}




	public void setQuarternum(String quarternum) {
		this.quarternum = quarternum;
	}




	public String getStartdate() {
		return startdate;
	}




	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}




	public String getEnddate() {
		return enddate;
	}




	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public  String dateFormat(String dd) {
		String d = "";
		try {
		String date_s =dd;
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dt.parse(date_s);
        SimpleDateFormat dt1 = new SimpleDateFormat("MM-dd-yyyy");
        d= dt1.format(date);
		}
		catch(Exception e)
		{
			
		}
		
		return d;
	}
	
	

}
