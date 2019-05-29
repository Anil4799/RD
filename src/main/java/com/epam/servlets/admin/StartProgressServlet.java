package com.epam.servlets.admin;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.services.admin.AdminBatchInfoService;
import com.epam.services.admin.AdminBatchInfoServiceImpl;
import com.epam.utils.DBManager;

/**
 * Servlet implementation class StartProgressServlet
 */
@WebServlet("/StartProgressServlet")
public class StartProgressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(AdminAddBatchServlet.class);
	private final AdminBatchInfoService batchInfoListService = new AdminBatchInfoServiceImpl();
	
	private static final String RESULT="RESULT";


       
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	LOGGER.debug("Entered into Servlet...............");
		String pageUrl = null;
		String batchId=request.getParameter("batchId");
		String comment=request.getParameter("comment");
		String action=request.getParameter("action");
		
		try
		{
			Connection con=DBManager.getConnection();
			
			if(action.equals("Start Progress"))	
			{
				if(batchInfoListService.updateStartProgressStatus(con,comment,batchId)==1)
				{
					request.setAttribute(RESULT,"Successfully updated");
				}
				else
				{
					request.setAttribute(RESULT,"Error in updating");
				}
			}
			
			else if(action.equals("Mark Complete"))
			{
				if(batchInfoListService.updateCompleteStatus(con,comment,batchId)==1)
				{
					request.setAttribute(RESULT,"Successfully updated");
				}	
				else
				{
					request.setAttribute(RESULT,"Error in updating");
				}
			}
			

			pageUrl = "batchInfo";
			goToURL(request, response,pageUrl);
			
		}
		catch(Exception e)
		{
			pageUrl = "batchInfo";
			request.setAttribute("resultMsg","Error in updating");
			LOGGER.error(e.getMessage());
			goToURL(request, response,pageUrl);
		}
		
		
	}
    public void goToURL(HttpServletRequest request, HttpServletResponse response,String pageUrl)
	{
		try {
			request.getRequestDispatcher(pageUrl).forward(request, response);
		} catch (Exception e1) {
			LOGGER.error(e1.getMessage());
		}
	}

}
