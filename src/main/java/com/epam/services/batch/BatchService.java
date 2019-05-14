/**
 * 
 */
package com.epam.services.batch;

import java.sql.SQLException;

import com.epam.dao.batch.BatchInfoDAOImpl;

/**
 * @author Vijayabhaskar_Reddy
 *
 */
public class BatchService {
	
	/**
	 * @param startDate
	 * @return
	 */
	static BatchInfoDAOImpl batchInfoDAOImpl;
	
	public static String generateBatchId(String startDate) {
		batchInfoDAOImpl=new BatchInfoDAOImpl();
		String batchId=batchInfoDAOImpl.generateBatchId(startDate);
		return batchId;
	}
	
	public static String saveBatchInfo(int batchNumber,String batchId,int year,String quarter,String startDate,String endDate,String status)throws SQLException {
		 
		batchInfoDAOImpl=new BatchInfoDAOImpl();
		String result= batchInfoDAOImpl.saveBatchInfo(batchNumber,batchId,year,quarter,startDate,endDate,status);
		return result;
	}
	

}
