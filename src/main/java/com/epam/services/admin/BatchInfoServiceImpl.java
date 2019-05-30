package com.epam.services.admin;

import java.sql.SQLException;

import com.epam.dao.admin.BatchInfoDAOImpl;

public class BatchInfoServiceImpl implements BatchInfoService {
 BatchInfoDAOImpl batchInfoDAOImpl;
	
	public String generateBatchId(String startDate) {
		batchInfoDAOImpl=new BatchInfoDAOImpl();
		return batchInfoDAOImpl.generateBatchId(startDate);
	}
	
	public String saveBatchInfo(String[] tokens,String batchId,String startDate,String endDate,String status,int codeToInsertOrUpdate)throws SQLException {
		 
		batchInfoDAOImpl=new BatchInfoDAOImpl();
		return batchInfoDAOImpl.saveBatchInfo(tokens, batchId,startDate,endDate,status,codeToInsertOrUpdate);
	}
	
}
