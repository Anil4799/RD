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


import com.epam.dao.MentorStudent;
import com.epam.services.MentorStudentInfoService;
import com.epam.services.MentorStudentInfoServiceImpl;
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
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MentorStudent> studentList =null;
		try
		{
			
			
			Connection con=DBManager.getConnection();
			studentList=studentInfoService.MentorStudentDetails(con);
						
		}
		catch(Exception e)
		{
			response.getWriter().append("Connection failed"+ e.getMessage()).append(request.getContextPath());
		}
		
		request.setAttribute("students", studentList);
		request.getRequestDispatcher("admin/MentorStudentInfoLandingPage.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
