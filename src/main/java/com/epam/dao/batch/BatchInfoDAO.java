package com.epam.dao.batch;

import java.sql.SQLException;

public interface BatchInfoDAO {
	public String generateBatchId(String startDate);
	public String saveBatchInfo(int batchNumber, String batchId, int year, String quarter,
			String startDate, String endDate, String status) throws SQLException;
}
