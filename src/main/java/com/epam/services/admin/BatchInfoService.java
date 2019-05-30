package com.epam.services.admin;

import java.sql.SQLException;

public interface BatchInfoService {
	 String generateBatchId(String startDate);

	 String saveBatchInfo(String[] tokens, String batchId, String startDate,
			String endDate, String status,int codeToInsertOrUpdate) throws SQLException;
}
