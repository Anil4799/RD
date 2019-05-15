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

import com.epam.dao.admin.AdminMentor;
import com.epam.services.admin.AdminMentorInfoService;
import com.epam.services.admin.AdminMentorInfoServiceImpl;
import com.epam.utils.ConstantsUtility;
import com.epam.utils.DBManager;


/**
 * Servlet implementation class AllMentorListServlet
 */
@WebServlet("/mentorList")
public class AdminMentorListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger( AdminMentorListServlet.class);
	
	 private final AdminMentorInfoService mentorInfoService = new AdminMentorInfoServiceImpl();
       
     @Override
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("Enter into servlet......");
		List<AdminMentor> mentorList =null;
		String pageUrl=null;
		try
		{
			
			
			Connection con=DBManager.getConnection();
			mentorList=mentorInfoService.getAllMentorDetails(con);
			pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_MENTOR_INFO);
			request.setAttribute("mentors", mentorList);	
			request.setAttribute("pageState", "MENTOR INFO");
		}
		catch(Exception e)
		{
			pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
			request.setAttribute("errorMsg", e.getMessage());
			LOGGER.error("Exception occured in MentorInfo = {}", e);
			
		}
		
		
		request.getRequestDispatcher(pageUrl).forward(request, response);
		LOGGER.debug("Exit from servlet");
	}


}
