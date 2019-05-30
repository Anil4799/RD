package com.epam.dao.admin;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.utils.DBManager;

public class BatchInfoDAOImpl implements BatchInfoDAO {
	CallableStatement statement;
	Connection connection = null;
	String dbbatchId="Batch_Id";
	private static final Logger LOGGER = Logger.getLogger(BatchInfoDAOImpl.class);
	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	DateFormat sdfOriginal = new SimpleDateFormat("MM-dd-yyyy");
	
	
	public String generateBatchId(String startDate) {
		String batchId = null;
		try {
			connection = DBManager.getConnection();
			statement = connection.prepareCall("{call batch_id_proc(?,?)}");
						
			String formattedDate = sdf.format(sdfOriginal.parse(startDate));
			
			java.sql.Date sqlStartDate = java.sql.Date.valueOf(formattedDate);
			
			
			statement.setDate("Start_Date", sqlStartDate);
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
	
	
	public String saveBatchInfo(String[] tokens,String batchId,
			String startDate, String endDate, String status,int codeToInsertOrUpdate) throws SQLException{
		
		int rowsCount = 0;
		try {
			connection = DBManager.getConnection();
			
			char ch = tokens[3].charAt(1);
			int batchNumber = Character.getNumericValue(ch);
			int year = Integer.parseInt(tokens[2]);
			String quarter = tokens[1];
			
			statement = connection.prepareCall("{call insert_procedure(?,?,?,?,?,?,?,?)}");
			statement.setInt("Batch_Num", batchNumber);
			statement.setString(dbbatchId, batchId);
			statement.setInt("Year_Num", year);
			statement.setString("Quarter_Num", quarter);
			statement.setInt("codeToInsertOrUpdate",codeToInsertOrUpdate);
			
			
			String formattedStartDate = sdf.format(sdfOriginal.parse(startDate));
			java.sql.Date sqlStartDate = java.sql.Date.valueOf(formattedStartDate);
			
			String formattedEndDate = sdf.format(sdfOriginal.parse(endDate));
			java.sql.Date sqlEndDate = java.sql.Date.valueOf(formattedEndDate);
			
			
			
			statement.setDate("Start_Date", sqlStartDate);
			statement.setDate("End_Date", sqlEndDate);
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
			
			if (codeToInsertOrUpdate==-1) 

			{
			return "Batch Saved Successfully";
			}

			else

			{
			return "Batch Updated Successfully";
			}


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
