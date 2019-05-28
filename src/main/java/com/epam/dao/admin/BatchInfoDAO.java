package com.epam.dao.admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BatchInfoDAO {
	public String generateBatchId(String startDate);
	public String saveBatchInfo(int batchNumber, String batchId, int year, String quarter,
			String startDate, String endDate, String status,int codeToInsertOrUpdate) throws SQLException;
	public List<String> getAllBatchID(Connection con);
}
