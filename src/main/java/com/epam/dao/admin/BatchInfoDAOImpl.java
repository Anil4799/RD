package com.epam.dao.admin;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.utils.DBManager;

public class BatchInfoDAOImpl implements BatchInfoDAO {
	CallableStatement statement;
	Connection connection = null;
	String dbbatchId="Batch_Id";
	private static final Logger LOGGER = Logger.getLogger(BatchInfoDAOImpl.class);
	public String generateBatchId(String startDate) {
		String batchId = null;
		try {
			connection = DBManager.getConnection();
			statement = connection.prepareCall("{call batch_id_proc(?,?)}");
			java.sql.Date stDate = java.sql.Date.valueOf(startDate);
			statement.setDate("Start_Date", stDate);
			statement.registerOutParameter(dbbatchId, Types.VARCHAR);
			statement.execute();
			batchId = statement.getString(dbbatchId);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
		} finally {
			DBManager.closeConnection(connection);
		}
		return batchId; 
		
	}
	
	
	public String saveBatchInfo(int batchNumber, String batchId, int year, String quarter,
			String startDate, String endDate, String status) throws SQLException{
		
		int rowsCount = 0;
		try {
			connection = DBManager.getConnection();
			statement = connection.prepareCall("{call insert_procedure(?,?,?,?,?,?,?)}");
			statement.setInt("Batch_Num", batchNumber);
			statement.setString(dbbatchId, batchId);
			statement.setInt("Year_Num", year);
			statement.setString("Quarter_Num", quarter);
			java.sql.Date stDate = java.sql.Date.valueOf(startDate);
			java.sql.Date edDate = java.sql.Date.valueOf(endDate);
			statement.setDate("Start_Date", stDate);
			statement.setDate("End_Date", edDate);
			statement.setString("Status", status);
			rowsCount = statement.executeUpdate();
			
		} catch (Exception exception) 
		{
			LOGGER.error(exception.getMessage());
		} 
		finally {
			statement.close();
			DBManager.closeConnection(connection);
		}

		if (rowsCount ==0)
			return "Unsuccessful insertion";
		else
			return "Batch Saved successfully";

	}


	@Override
	public List<String> getAllBatchID(Connection con) {
		List<String> batchIDList = new ArrayList<>();
		String sql="call get_all_batchID();";
		try(CallableStatement cs= con.prepareCall(sql);	ResultSet rs = cs.executeQuery();){
			while(rs.next()){
				batchIDList.add(rs.getString(1));
		
			}
		}catch(Exception e){
			batchIDList=null;
			e.getMessage();
		}
		
		return batchIDList;
	}
}
