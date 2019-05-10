package com.epam.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.epam.dao.Mentor;

import com.epam.services.MentorInfoService;
import com.epam.services.MentorInfoServiceImpl;
import com.epam.utils.ConstantsUtility;
import com.epam.utils.DBManager;


/**
 * Servlet implementation class AllMentorListServlet
 */
@WebServlet("/mentorList")
public class AllMentorListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger( AllMentorListServlet.class);
	private  MentorInfoService allmentorlistservlet=new MentorInfoServiceImpl();
	
	 private MentorInfoService mentorInfoService = new MentorInfoServiceImpl();
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("Enter into servlet......");
		List<Mentor> mentorList =null;
		String pageUrl=null;
		try
		{
			
			
			Connection con=DBManager.getConnection();
			mentorList=mentorInfoService.getAllMentorDetails(con);
			pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_MENTOR_INFO);
			request.setAttribute("mentors", mentorList);			
		}
		catch(Exception e)
		{
			pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
			request.setAttribute("errorMsg", e.getMessage());
			LOGGER.error("Exception occured in MentorInfo = {}", e);
			
		}
		
		
		request.getRequestDispatcher("admin/student_info_landing_page.jsp").forward(request, response);
		LOGGER.debug("Exit from servlet");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
