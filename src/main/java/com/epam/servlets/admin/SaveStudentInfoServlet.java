package com.epam.servlets.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.dao.admin.CollegeBean;
import com.epam.services.admin.StudentService;
import com.epam.services.admin.StudentServiceImpl;

/**
 * Servlet implementation class SaveStudentInfoServlet
 */
@WebServlet("/SaveStudentInfoServlet")
public class SaveStudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveStudentInfoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentService studentService = new StudentServiceImpl();
		
		List<CollegeBean> collegeNames = studentService.getCollegNames();
		request.setAttribute("collegeNames", collegeNames);
		
		List<String> batchIDList = studentService.getBatchID();
		request.setAttribute("batchIDList", batchIDList);
		
		List<String> employeeTypeList = studentService.getEmployeeType();
		request.setAttribute("employeeTypeList", employeeTypeList);
		
		List<String> coreSkills = studentService.getcoreSkill();
		request.setAttribute("coreSkills", coreSkills);
		
		List<String> preferredStreams = studentService.getPreferredStream();
		request.setAttribute("preferredStreams", preferredStreams);
		
		List<String> assignedStreams = studentService.getAssignedStream();
		request.setAttribute("assignedStreams", assignedStreams);
		
		List<String> mentorList = studentService.getMentor();
		request.setAttribute("mentorList", mentorList);
		
		List<String> statusList = studentService.getStatus();
		request.setAttribute("statusList", statusList);
		
		List<String> assignedLocationList = studentService.getAssignedLocation();
		request.setAttribute("assignedLocationList", assignedLocationList);
		
		
		
		try {
			request.getRequestDispatcher("admin/AddStudentInfo.jsp").forward(request, response);
		} catch (Exception e) {
			//Ecxeption 
		}
		
	}
    
    

}
