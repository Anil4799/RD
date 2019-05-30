package com.epam.servlets.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.services.admin.BatchInfoServiceImpl;

/**
 * Servlet implementation class SaveBatchInfoServlet
 */
@WebServlet("/SaveBatchInfoServlet")
public class SaveBatchInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(SaveBatchInfoServlet.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
try {
		String[] tokens;
		PrintWriter printWriter = response.getWriter();
		BatchInfoServiceImpl batchInfoServiceImpl=new BatchInfoServiceImpl();
		String startDate = request.getParameter("batch_start_date");
		String endDate = request.getParameter("batch_end_date");
		int codeToInsertOrUpdate=Integer.parseInt(request.getParameter("codeToInsertOrUpdate"));
		if (endDate.contentEquals(""))
			endDate = "2019-12-31";

		String status = request.getParameter("batch_status");

		String batchId = request.getParameter("batch_id");
		tokens = batchId.split("-");

	//	char ch = tokens[3].charAt(1);
	//	int batchNumber = Character.getNumericValue(ch);
	//	int year = Integer.parseInt(tokens[2]);
	//	String quarter = tokens[1];
		
			//String result = batchInfoServiceImpl.saveBatchInfo(batchNumber, batchId, year, quarter, startDate, endDate, status,codeToInsertOrUpdate);
			String result = batchInfoServiceImpl.saveBatchInfo(tokens, batchId, startDate, endDate, status,codeToInsertOrUpdate);
			printWriter.println(result);
			
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
		}

	}
}
