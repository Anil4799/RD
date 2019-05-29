package com.epam.services.admin;

import java.sql.Connection;
import java.util.List;

import com.epam.dao.admin.Batch;

public interface AdminBatchInfoService {
	
	public List<Batch> getAllBatchsList(Connection con);
	public List<Batch> getAllBatchListWithInDateRange(Connection connection,String startDate,String endDate);
	public int updateStartProgressStatus(Connection con, String comment, String batchId);
	public int updateCompleteStatus(Connection con, String comment, String batchId);

}
