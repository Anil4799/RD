package com.epam.servlets;
import java.sql.*;
public class BatchIdGeneratorDAO {
	CallableStatement cst;

public String  executeBatchIdGeneratorProcedure(Connection connection, String startDate)throws SQLException {
	
	cst=connection.prepareCall("{call batch_id_proc(?,?)}");
	java.sql.Date stDate = java.sql.Date.valueOf(startDate);
	cst.setDate(1,stDate);
	cst.registerOutParameter(2, Types.VARCHAR);
	cst.execute();
	return cst.getString(2);
}

public String executeSaveBatchInfoProcedure(Connection connection,int batchNumber,String batchId,int year,String quarter, String startDate,String endDate,String status)throws SQLException {
	cst=connection.prepareCall("{call insert_procedure(?,?,?,?,?,?,?)}");
	cst.setInt(1, batchNumber);
	cst.setString(2, batchId);
	cst.setInt(3,year);
	cst.setString(4,quarter);
	java.sql.Date stDate = java.sql.Date.valueOf(startDate);
	java.sql.Date edDate = java.sql.Date.valueOf(endDate);
	cst.setDate(5,stDate);
	cst.setDate(6,edDate);
	cst.setString(7,status);
	boolean b=cst.execute();
	if(b==false)
		return "Batch Saved successfully";
	else
		return "Unsuccessful insertion";
	
}
}
