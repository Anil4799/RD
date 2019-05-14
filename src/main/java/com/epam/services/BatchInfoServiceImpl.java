package com.epam.services;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.epam.dao.Batch;

public class BatchInfoServiceImpl implements BatchInfoService {

	@Override
	public List<Batch> getAllBatchsList(Connection con) {
		
		List<Batch> batchList = new ArrayList<Batch>();
		try
		{
			/* String sql="SELECT * FROM batch_info ORDER BY\r\n" + 
					" batch_id DESC\r\n" + 
					"LIMIT 10;";*/
			
			String sql = "call batch();";
			CallableStatement cs=con.prepareCall(sql);
			ResultSet rs=cs.executeQuery();
			if(rs!=null)
			{
			while(rs.next())
			{
				Batch batch=new Batch();
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
						
		}
		catch(Exception e)
		{
			batchList=null;
		}
		
		return batchList;
	}

}
