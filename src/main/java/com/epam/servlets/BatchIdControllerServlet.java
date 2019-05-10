package com.epam.servlets;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.epam.utils.DBManager;

import java.io.*;
import java.sql.*;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/BatchIdControllerServlet")
public class BatchIdControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		
		
		response.setContentType("text/html");
		String startDate=request.getParameter("batch_start_date");
		Connection connection;
		PrintWriter printWriter;
		
		try {
			printWriter=response.getWriter();
		connection=DBManager.getConnection();
		
		BatchIdGeneratorDAO batchIdGeneratorDAO=new BatchIdGeneratorDAO();
		String batchId=batchIdGeneratorDAO.executeBatchIdGeneratorProcedure(connection,startDate);
		printWriter=response.getWriter();
		printWriter.write(batchId);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
