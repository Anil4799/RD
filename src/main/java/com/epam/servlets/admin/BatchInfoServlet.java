package com.epam.servlets.admin;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.epam.services.batch.BatchInfoServiceImpl;

import java.io.*;

@WebServlet("/BatchInfoServlet")
public class BatchInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		BatchInfoServiceImpl batchInfoServiceImpl=new BatchInfoServiceImpl();
		
		response.setContentType("text/html");
		String startDate=request.getParameter("batch_start_date");
		PrintWriter printWriter;
		
		try {
			printWriter=response.getWriter();
		
		String batchId = batchInfoServiceImpl.generateBatchId(startDate);
		printWriter=response.getWriter();
		printWriter.write(batchId);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
