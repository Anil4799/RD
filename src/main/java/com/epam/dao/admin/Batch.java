package com.epam.dao.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;

public class Batch {
	
	private static final Logger LOGGER = Logger.getLogger( Batch.class);
	
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
		this.startdate = dateFormat(startdate);
	}




	public String getEnddate() {
		return enddate;
	}




	public void setEnddate(String enddate) {
		this.enddate = dateFormat(enddate);
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public  String dateFormat(String oldDate) {
		String newDate = "";
		try {

        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dt.parse(oldDate);

        SimpleDateFormat dt1 = new SimpleDateFormat("MM-dd-yyyy");
        newDate= dt1.format(date);
		}
		catch(Exception e)
		{

			LOGGER.error(e.getMessage());

		}
		
		return newDate;
	}
	
	

}
