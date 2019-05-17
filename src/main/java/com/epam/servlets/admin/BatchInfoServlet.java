package com.epam.servlets.admin;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.log4j.Logger;

import com.epam.services.batch.BatchInfoServiceImpl;

import java.io.*;

@WebServlet("/BatchInfoServlet")
public class BatchInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(BatchInfoServlet.class);
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		PrintWriter printWriter;
		BatchInfoServiceImpl batchInfoServiceImpl=new BatchInfoServiceImpl();
		
		response.setContentType("text/html");
		String startDate=request.getParameter("batch_start_date");
		
		
		try {
				printWriter=response.getWriter();
				String batchId = batchInfoServiceImpl.generateBatchId(startDate);
				printWriter.write(batchId);
		
		}catch(Exception exception) {
			LOGGER.error(exception.getMessage());
		}
		
	}
	

}
