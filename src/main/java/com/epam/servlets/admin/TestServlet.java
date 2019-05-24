package com.epam.servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.services.admin.StudentService;
import com.epam.services.admin.StudentServiceImpl;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String action=request.getParameter("actionView");
		//String email=request.getParameter("email_id");
		StudentService studentService = new StudentServiceImpl();
		//if(action.equalsIgnoreCase("edit"))
		//{
		request.setAttribute("studentBean", studentService.getDetails());
		request.setAttribute("collegeNames", studentService.getCollegNames());
		request.setAttribute("employeeTypeList", studentService.getEmployeeType());
		request.setAttribute("coreSkills", studentService.getcoreSkill());
		request.setAttribute("preferredStreams", studentService.getPreferredStream());
		request.setAttribute("assignedStreams", studentService.getAssignedStream());
		request.setAttribute("assignedLocationList", studentService.getAssignedLocation());
		request.setAttribute("statusList", studentService.getStatus());
		request.setAttribute("mentorList", studentService.getMentor());

		request.getRequestDispatcher("admin/EditStudentInfo.jsp").forward(request, response);
		//}
	}

}
