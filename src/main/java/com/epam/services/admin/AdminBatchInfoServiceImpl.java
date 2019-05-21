package com.epam.services.admin;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.epam.dao.admin.Batch;


public class AdminBatchInfoServiceImpl implements AdminBatchInfoService {
	
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
	
		}
