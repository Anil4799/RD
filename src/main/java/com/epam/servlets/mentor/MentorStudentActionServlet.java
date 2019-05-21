package com.epam.servlets.mentor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MentorStudentActionServlet
 */
@WebServlet("/MentorStudentActionServlet")
public class MentorStudentActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionView=request.getParameter("actionView");
		String emailId=request.getParameter("email_id");
		
		if(actionView.equalsIgnoreCase("View"))
		{
			//MentorStudentViewService mentorStudentViewService=new MentorStudentViewServiceImpl();
			request.setAttribute("student", "Demo");
			request.getRequestDispatcher("/mentor/Mentor_ViewStudentDetail.jsp").forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
