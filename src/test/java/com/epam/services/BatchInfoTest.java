package com.epam.services;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;

import com.epam.dao.admin.Batch;
import com.epam.services.admin.AdminBatchInfoServiceImpl;
import com.epam.utils.DBManager;

import jdk.nashorn.internal.ir.annotations.Ignore;

class BatchInfoTest {

	static DBManager db;
	static AdminBatchInfoServiceImpl batch;
	static Connection con=null;
	List<Batch> lsactual=null;
	@BeforeAll
	static void  initializer()
	{
		batch=new AdminBatchInfoServiceImpl();
		db=new DBManager();
	}
	@Ignore
	void test() throws Exception {
		lsactual=batch.getAllBatchsList(DBManager.getConnection());
		Batch b=lsactual.get(1);
		int batchnum=0;
	 	String batchid=null;
		 int yearnum=0;
		 String quarternum=null;
		 String startdate=null;
		 String enddate=null;
		 String status=null;
		 batchid=b.getBatchid();
		 batchnum=b.getBatchnum();
		 yearnum=b.getYearnum();
		 quarternum=b.getQuarternum();
		 startdate=b.getStartdate();
		 enddate=b.getEnddate();
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
