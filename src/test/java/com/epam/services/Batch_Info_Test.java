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
		int batch_num=0;
	 	String batch_id=null;
		 int year_num=0;
		 String quarter_num=null;
		 String start_date=null;
		 String end_date=null;
		 String status=null;
		 batch_id=b.getBatch_id();
		 batch_num=b.getBatch_num();
		 year_num=b.getYear_num();
		 quarter_num=b.getQuarter_num();
		 start_date=b.getStart_date();
		 end_date=b.getEnd_date();
		 status=b.getStatus();
		 assertNotNull(batch_id);
		 assertNotNull(quarter_num);
		 assertNotNull(start_date);
		 assertNotNull(end_date);
		 assertNotNull(status);
		 assertNotEquals(0, batch_num);
		 assertNotEquals(0, year_num);
	
	}

}
