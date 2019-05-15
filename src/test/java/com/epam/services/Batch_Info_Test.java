package com.epam.services;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import com.epam.dao.admin.AdminBatch;
import com.epam.services.admin.AdminBatchInfoServiceImpl;
import com.epam.utils.DBManager;

import jdk.nashorn.internal.ir.annotations.Ignore;

class Batch_Info_Test {

	static DBManager db;
	static AdminBatchInfoServiceImpl batch;
	static Connection con=null;
	List<AdminBatch> lsactual=null;
	@BeforeAll
	static void  initializer()
	{
		batch=new AdminBatchInfoServiceImpl();
		db=new DBManager();
	}
	@Ignore
	void test() throws Exception {
		lsactual=batch.getAllBatchsList(DBManager.getConnection());
		AdminBatch b=lsactual.get(1);
		int batchnum=0;
	 	String batchid=null;
		 int yearnum=0;
		 String quarternum=null;
		 String startdate=null;
		 String enddate=null;
		 String status=null;
		 batchid=b.getBatchId();
		 batchnum=b.getBatchNum();
		 yearnum=b.getYearNum();
		 quarternum=b.getQuarterNum();
		 startdate=b.getStartDate();
		 enddate=b.getEndDate();
		 status=b.getStatus();
		 assertNotNull(batchid);
		 assertNotNull(quarternum);
		 assertNotNull(startdate);
		 assertNotNull(enddate);
		 assertNotNull(status);
		 assertNotEquals(0, batchnum);
		 assertNotEquals(0, yearnum);
	
	}

}
