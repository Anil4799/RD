package com.epam.services.admin;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.epam.dao.admin.AdminBatch;

public class AdminBatchInfoServiceImpl implements AdminBatchInfoService {

	@Override
	public List<AdminBatch> getAllBatchsList(Connection con) {
		String sql="call batch();";
		List<AdminBatch> batchList = new ArrayList<AdminBatch>();
		try(CallableStatement cs=con.prepareCall(sql);ResultSet rs=cs.executeQuery();)
		{
			if(rs!=null)
			{
			while(rs.next())
			{
				AdminBatch batch=new AdminBatch();
				batch.setBatchId(rs.getString("batch_id"));
				batch.setBatchNum(rs.getInt("batch_num"));
				batch.setEnd_date(rs.getString("end_date"));
				batch.setQuarterNum(rs.getString("quarter_num"));
				batch.setStartDate(rs.getString("start_date"));
				batch.setStatus(rs.getString("status"));
				batch.setYearNum(rs.getInt("year_num"));
				
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
