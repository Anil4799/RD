package com.epam.servlets;

import java.io.IOException;
import java.sql.Connection;

import java.util.List;

//import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.epam.dao.Student;
import com.epam.services.StudentInfoService;
import com.epam.services.StudentInfoServiceImpl;
import com.epam.utils.ConstantsUtility;
import com.epam.utils.DBManager;

/**
 * Servlet implementation class AllStudentListServlet
 */
@WebServlet("/studentList")
public class AllStudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 //@Resource(name = "jdbc/abc")
	// DataSource ds;
	 private StudentInfoService studentInfoService = new StudentInfoServiceImpl();
	 private static final Logger LOGGER = Logger.getLogger( AllStudentListServlet.class);
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> studentList =null;
		LOGGER.debug("Enter into servlet......");
		String pageUrl=null;
		try
		{
			
			
			Connection con=DBManager.getConnection();
			studentList=studentInfoService.getAllStudentDetails(con);
			pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_STUDENT_INFO);
			request.setAttribute("students", studentList);
						
		}
		catch(Exception e)
		{
			pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
			request.setAttribute("errorMsg", e.getMessage());
			LOGGER.error("Exception occured in MentorStudentInfo = {}", e);
		}
		
	
		request.getRequestDispatcher("admin/student_info_landing_page.jsp").forward(request, response);
		LOGGER.debug("Exit from servlet");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
