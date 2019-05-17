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
import com.epam.dao.admin.MenuAction;
import com.epam.servlets.admin.AdminBatchInfoListServlet;
import com.epam.utils.DBManager;

public class AdminBatchInfoServiceImpl implements AdminBatchInfoService {
	
	private static final Logger LOGGER = Logger.getLogger(AdminBatchInfoServiceImpl.class);


	@Override
	public List<AdminBatch> getAllBatchsList(Connection con) {
		String sql="call batch();";
		List<AdminBatch> batchList = new ArrayList<AdminBatch>();


		try(CallableStatement cs=con.prepareCall(sql);ResultSet rs=cs.executeQuery();)
		{

			while(rs.next())
			{
				AdminBatch batch=new AdminBatch();
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
