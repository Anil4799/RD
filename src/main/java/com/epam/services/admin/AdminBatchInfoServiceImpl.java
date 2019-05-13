package com.epam.services.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.dao.admin.AdminBatch;

public class AdminBatchInfoServiceImpl implements AdminBatchInfoService {

	@Override
	public List<AdminBatch> getAllBatchsList(Connection con) {
		
		List<AdminBatch> batchList = new ArrayList<AdminBatch>();
		try
		{
			String sql="SELECT * FROM batch_info ORDER BY\r\n" + 
					" batch_id DESC\r\n" + 
					"LIMIT 10;";
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			if(rs!=null)
			{
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
						
		}
		catch(Exception e)
		{
			batchList=null;
		}
		
		return batchList;
	}

}
