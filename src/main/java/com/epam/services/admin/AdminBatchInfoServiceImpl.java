package com.epam.services.admin;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.epam.dao.admin.Batch;
import com.epam.utils.DBManager;


public class AdminBatchInfoServiceImpl  implements AdminBatchInfoService {
	private static final Logger LOGGER = Logger.getLogger(AdminBatchInfoServiceImpl.class);
	@Override
	public List<Batch> getAllBatchsList(Connection con) {
		String sql="call batch();";
		List<Batch> batchList = new ArrayList<>();


		try(CallableStatement cs=con.prepareCall(sql);ResultSet rs=cs.executeQuery();)
		{

			processResultSet(batchList, rs);
			
						
		}
		catch(Exception e)
		{
			batchList=null;
		
		}
		
		return batchList;
	}
	
	
	
	
	
	public List<Batch> getAllBatchListWithInDateRange(Connection connection,String startDate,String endDate){

		
		List<Batch> batchList = new ArrayList<>();

		try(CallableStatement statement = connection.prepareCall("{call batchListWithInDateRange(?,?)}");) {

			
			java.sql.Date sqlStartDate = formatToSqlDate(startDate);
			java.sql.Date sqlEndDate = formatToSqlDate(endDate);
						
			statement.setDate("startDate", sqlStartDate);
			statement.setDate("endDate", sqlEndDate);
			
						
			ResultSet rs=statement.executeQuery();
			

			processResultSet(batchList, rs);

			
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
		} finally {
			DBManager.closeConnection(connection);
		}
		

		return batchList;
		
	}





	private void processResultSet(List<Batch> batchList, ResultSet rs) throws SQLException {
		while(rs.next())
		{
			Batch batch=new Batch();
			batch.setSerialNo(rs.getInt("Serial_Num"));
			batch.setBatchid(rs.getString("batch_id"));
			batch.setBatchnum(rs.getInt("batch_num"));
			batch.setEnddate(rs.getString("end_date"));
			batch.setQuarternum(rs.getString("quarter_num"));
			batch.setStartdate(rs.getString("start_date"));
			batch.setStatus(rs.getString("status"));
			batch.setYearnum(rs.getInt("year_num"));
			
			batchList.add(batch);
		}
	}





	private java.sql.Date formatToSqlDate(String startDate) throws ParseException {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat sdfOriginal = new SimpleDateFormat("MM-dd-yyyy");
		String formattedDate = sdf.format(sdfOriginal.parse(startDate));
		
		return java.sql.Date.valueOf(formattedDate);
	}
}
