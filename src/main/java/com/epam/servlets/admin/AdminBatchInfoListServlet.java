package com.epam.servlets.admin;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.dao.admin.AdminBatch;
import com.epam.services.admin.AdminBatchInfoService;
import com.epam.services.admin.AdminBatchInfoServiceImpl;
import com.epam.utils.ConstantsUtility;
import com.epam.utils.DBManager;

/**
 * Servlet implementation class BatchInfoListServlet
 */
@WebServlet("/batchInfo")
public class AdminBatchInfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger LOGGER = Logger.getLogger(AdminBatchInfoListServlet.class);
	private AdminBatchInfoService batchInfoListServlet = new AdminBatchInfoServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("Entered into Servlet...............");
		List<AdminBatch> batchList =null;
		String pageUrl = null;
		try
		{
			Connection con=DBManager.getConnection();
			batchList=batchInfoListServlet.getAllBatchsList(con);
			pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_BATCH_INFO);
			request.setAttribute("batchs", batchList);
			request.setAttribute("pageState", "BATCH INFO");

		}
		catch(Exception e)
		{
			pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
			request.setAttribute("errorMsg", e.getMessage());
			LOGGER.error(e.getMessage());
		}
		
		request.getRequestDispatcher(pageUrl).forward(request, response);
		LOGGER.debug("Exit from Servlet...............");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
