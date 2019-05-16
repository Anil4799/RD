package com.epam.dao.batch;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.epam.utils.DBManager;

public class BatchInfoDAOImpl implements BatchInfoDAO {
	CallableStatement statement;
	public String generateBatchId(String startDate) {
		String batchId = null;
		Connection connection = null;
		try {
			connection = DBManager.getConnection();
			statement = connection.prepareCall("{call batch_id_proc(?,?)}");
			java.sql.Date stDate = java.sql.Date.valueOf(startDate);
			statement.setDate("Start_Date", stDate);
			statement.registerOutParameter("Batch_Id", Types.VARCHAR);
			statement.execute();
			batchId = statement.getString("Batch_Id");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.closeConnection(connection);
		}
		return batchId;
		
	}
	
	
	public String saveBatchInfo(int batchNumber, String batchId, int year, String quarter,
			String startDate, String endDate, String status) throws SQLException{
		Connection connection = null;
		java.sql.CallableStatement statement;
		int rowsCount = 0;
		try {
			connection = DBManager.getConnection();
			statement = connection.prepareCall("{call insert_procedure(?,?,?,?,?,?,?)}");
			statement.setInt("Batch_Num", batchNumber);
			statement.setString("Batch_Id", batchId);
			statement.setInt("Year_Num", year);
			statement.setString("Quarter_Num", quarter);
			java.sql.Date stDate = java.sql.Date.valueOf(startDate);
			java.sql.Date edDate = java.sql.Date.valueOf(endDate);
			statement.setDate("Start_Date", stDate);
			statement.setDate("End_Date", edDate);
			statement.setString("Batch_Status", status);
			rowsCount = statement.executeUpdate();
		} catch (Exception e) {

		} finally {
			DBManager.closeConnection(connection);
		}

		if (rowsCount ==0)
			return "Unsuccessful insertion";
		else
			return "Batch Saved successfully";

	}
		
	
}
