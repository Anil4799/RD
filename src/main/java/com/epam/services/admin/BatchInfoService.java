package com.epam.services.admin;

import java.sql.SQLException;

public interface BatchInfoService {
	 String generateBatchId(String startDate);

	 String saveBatchInfo(int batchNumber, String batchId, int year, String quarter, String startDate,
			String endDate, String status,int codeToInsertOrUpdate) throws SQLException;
}
