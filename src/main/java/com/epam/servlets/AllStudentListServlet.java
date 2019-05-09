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

import com.epam.dao.Mentor;
import com.epam.dao.Student;
import com.epam.services.StudentInfoService;
import com.epam.services.StudentInfoServiceImpl;

/**
 * Servlet implementation class AllStudentListServlet
 */
@WebServlet("/studentList")
public class AllStudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 @Resource(name = "jdbc/abc")
	 DataSource ds;
	 private StudentInfoService studentInfoService = new StudentInfoServiceImpl();
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> studentList =null;
		try
		{
			
			
			Connection con=ds.getConnection();
			studentList=studentInfoService.getAllStudentDetails(con);
						
		}
		catch(Exception e)
		{
			response.getWriter().append("Connection failed"+ e.getMessage()).append(request.getContextPath());
		}
		
		request.setAttribute("students", studentList);
		request.getRequestDispatcher("admin/student_info_landing_page.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
