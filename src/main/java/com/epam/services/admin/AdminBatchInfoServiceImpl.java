package com.epam.services.admin;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.dao.admin.Batch;
import com.epam.utils.DBManager;


public class AdminBatchInfoServiceImpl implements AdminBatchInfoService {
	private static final Logger LOGGER = Logger.getLogger(AdminBatchInfoServiceImpl.class);
	@Override
	public List<Batch> getAllBatchsList(Connection con) {
		String sql="call batch();";
		List<Batch> batchList = new ArrayList<>();


		try(CallableStatement cs=con.prepareCall(sql);ResultSet rs=cs.executeQuery();)
		{

			while(rs.next())
			{
				Batch batch=new Batch();
				batch.setBatchid(rs.getString("batch_id"));
				batch.setBatchnum(rs.getInt("batch_num"));
				batch.setEnddate(rs.getString("end_date"));
				batch.setQuarternum(rs.getString("quarter_num"));
				batch.setStartdate(rs.getString("start_date"));
				batch.setStatus(rs.getString("status"));
				batch.setYearnum(rs.getInt("year_num"));
				
				batchList.add(batch);
			}
			
						
		}
		catch(Exception e)
		{
			batchList=null;
		
		}
		
		return batchList;
	}
	
	
	
	
	
	public List<Batch> getAllBatchListWithInDateRange(Connection connection,String startDate,String endDate){
		
		//int count=0;
		List<Batch> batchList = new ArrayList<>();
		
		try {
			//connection = DBManager.getConnection();
			CallableStatement statement = connection.prepareCall("{call batchListWithInDateRange(?,?)}");
			
			java.sql.Date stDate = java.sql.Date.valueOf(startDate);
			java.sql.Date enDate = java.sql.Date.valueOf(endDate);
			
			statement.setDate("Start_Date", stDate);
			statement.setDate("End_Date", enDate);
			ResultSet rs=statement.executeQuery();
			
			while(rs.next())
			{
				Batch batch=new Batch();
				batch.setBatchid(rs.getString("batch_id"));
				batch.setBatchnum(rs.getInt("batch_num"));
				batch.setEnddate(rs.getString("end_date"));
				batch.setQuarternum(rs.getString("quarter_num"));
				batch.setStartdate(rs.getString("start_date"));
				batch.setStatus(rs.getString("status"));
				batch.setYearnum(rs.getInt("year_num"));
				
				batchList.add(batch);
				//count++;
			}
			
			
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
		} finally {
			DBManager.closeConnection(connection);
		}
		

		return batchList;
		
	}
}
