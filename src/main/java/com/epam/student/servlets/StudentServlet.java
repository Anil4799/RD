package com.epam.student.servlets;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.epam.student.beans.StudentBean;
import com.epam.student.services.StudentService;
import com.epam.student.services.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final StudentService studentService = new StudentServiceImpl();
	private boolean result;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Date dateOfBirth = null, dateOfJoining = null;
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String date1 = request.getParameter("dateOfBirth");	
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try{
			dateOfBirth = format.parse(date1);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		long contactNumber =Long.parseLong(request.getParameter("contactNumber"));
		String personalLocation = request.getParameter("personalLocation");
		String collegeNameAndLocation = request.getParameter("collegeName");
		String collegeName = collegeNameAndLocation.substring(0,collegeNameAndLocation.indexOf("$"));
		System.out.println("collegeName==========\n\n"+collegeName+"\n\n");
		String collegeLocation = request.getParameter("collegeLocation");
		String graduation = request.getParameter("graduation");
		String graduationSpeciality = request.getParameter("graduationSpeciality");
		int yearOfPassedOut = Integer.parseInt(request.getParameter("yearOfPassedOut"));
		int graduationMarks =Integer.parseInt(request.getParameter("graduationMarks"));
		int twelveth =Integer.parseInt(request.getParameter("twelveth"));
		int tenth =Integer.parseInt(request.getParameter("tenth"));
		String batchId = request.getParameter("batchId");
		String employeeType = request.getParameter("employeeType");
		String coreSkill = request.getParameter("coreSkill");
		String preferredStudentStream = request.getParameter("preferredStudentStream");
		String assignedStream = request.getParameter("assignedStream");
		date1 = request.getParameter("dateOfJoining");
		
		
		try{
			dateOfJoining = format.parse(date1);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String mentorName = request.getParameter("mentorName");
		String assignedLocation = request.getParameter("assignedLocation");
		String relocation = request.getParameter("relocation");
		String status = request.getParameter("status");
		
		StudentBean studentBean = new StudentBean(firstName, lastName, dateOfBirth, email, gender, contactNumber,
				personalLocation, collegeName, collegeLocation, graduation,
				graduationSpeciality, yearOfPassedOut, graduationMarks, twelveth, tenth,
				batchId, employeeType, coreSkill, preferredStudentStream, assignedStream,
				dateOfJoining, mentorName, assignedLocation, relocation, status);
		
		result = studentService.addStudentDetails(studentBean);
		System.out.println(result);
		
		if(result)
		{
			request.setAttribute("Result", true);
			 RequestDispatcher rd=request.getRequestDispatcher("AddStudentInfo.jsp");  
		        rd.forward(request, response);	
		}
		else{  
	       
	        RequestDispatcher rd=request.getRequestDispatcher("RegFailure.jsp");  
	        rd.include(request, response);
		
	}

	}
}
