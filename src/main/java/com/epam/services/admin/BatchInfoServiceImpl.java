package com.epam.services.admin;

import java.sql.SQLException;

import com.epam.dao.admin.BatchInfoDAOImpl;

public class BatchInfoServiceImpl implements BatchInfoService {
 BatchInfoDAOImpl batchInfoDAOImpl;
	
	public String generateBatchId(String startDate) {
		batchInfoDAOImpl=new BatchInfoDAOImpl();
		return batchInfoDAOImpl.generateBatchId(startDate);
	}
	
	public String saveBatchInfo(int batchNumber,String batchId,int year,String quarter,String startDate,String endDate,String status)throws SQLException {
		 
		batchInfoDAOImpl=new BatchInfoDAOImpl();
		return batchInfoDAOImpl.saveBatchInfo(batchNumber,batchId,year,quarter,startDate,endDate,status);
	}
	
}
