package com.epam.services.admin;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.dao.admin.AdminBatch;
import com.epam.dao.admin.BatchAction;
import com.epam.servlets.admin.AdminBatchInfoListServlet;
import com.epam.utils.DBManager;

public class AdminBatchInfoServiceImpl implements AdminBatchInfoService {
	
	private static final Logger LOGGER = Logger.getLogger(AdminBatchInfoServiceImpl.class);


	@Override
	public List<AdminBatch> getAllBatchsList(Connection con) {
		
		List<AdminBatch> batchList = new ArrayList<AdminBatch>();
		CallableStatement cs=null;
		try
		{

			String sql = "call batch();";
			cs=con.prepareCall(sql);
			ResultSet rs=cs.executeQuery();

			
			while(rs.next())
			{
				AdminBatch batch=new AdminBatch();
				batch.setBatch_id(rs.getString("batch_id"));
				batch.setBatch_num(rs.getInt("batch_num"));
				batch.setEnd_date(rs.getString("end_date"));
				batch.setQuarter_num(rs.getString("quarter_num"));
				batch.setStart_date(rs.getString("start_date"));
				batch.setStatus(rs.getString("status"));
				batch.setYear_num(rs.getInt("year_num"));
				
				batchList.add(batch);
			}
			
						
		}
		catch(Exception e)
		{
			batchList=null;
		}
		finally {
			try {
				cs.close();
			} catch (SQLException e) {
				
			}
		}
		
		return batchList;
	}
	
	
	
	
//	public static void main(String args[])
//	{
//		try
//		{
//			Connection con = DBManager.getConnection();
//			List<BatchAction> lb=getBatchActionList(con, 1);
//			for (BatchAction batchAction : lb) {
//				System.out.println(batchAction.getStatus());
//			}
//		}
//		catch(Exception e)
//		{
//			
//		}
//	}

}
