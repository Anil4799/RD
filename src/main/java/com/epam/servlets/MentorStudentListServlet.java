package com.epam.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


import com.epam.dao.MentorStudent;
import com.epam.services.MentorStudentInfoService;
import com.epam.services.MentorStudentInfoServiceImpl;
import com.epam.utils.ConstantsUtility;
import com.epam.utils.DBManager;

/**
 * Servlet implementation class AllStudentListServlet
 */
@WebServlet("/mentorstudentList")
public class MentorStudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 //@Resource(name = "jdbc/abc")
	 //DataSource ds;
	 private MentorStudentInfoService studentInfoService = new MentorStudentInfoServiceImpl();
	 private static final Logger LOGGER = Logger.getLogger( MentorStudentListServlet.class); 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("Enter into servlet......");
		List<MentorStudent> studentList =null;
		String pageUrl=null;
		try
		{
			
			
			Connection con=DBManager.getConnection();
			studentList=studentInfoService.MentorStudentDetails(con);
			pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_MENTORSTUDENT_INFO);
			request.setAttribute("students", studentList);
						
		}
		catch(Exception e)
		{
			pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
			request.setAttribute("errorMsg", e.getMessage());
			LOGGER.error("Exception occured in MentorStudentInfo = {}", e);
		}
		
		
		request.getRequestDispatcher("admin/MentorStudentInfoLandingPage.jsp").forward(request, response);
		LOGGER.debug("Exit from servlet");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
