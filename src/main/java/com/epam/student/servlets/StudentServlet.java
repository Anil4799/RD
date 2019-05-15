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
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			 
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
			  long contactNumber;
			  String mobileNumber = request.getParameter("contactNumber");
			  if(!mobileNumber.equals(""))
			  {
			   contactNumber =Long.parseLong(mobileNumber);
			  } else {
			   contactNumber = 0;
			  }
			  String personalLocation = request.getParameter("personalLocation");
			  String collegeNameAndLocation = request.getParameter("collegeName");
			  System.out.println("\n collegeNameAndLocation ="+ collegeNameAndLocation + "\n");
			  String collegeName = "";
			  if(!collegeNameAndLocation.equals(""))
			  {
			   collegeName = collegeNameAndLocation.substring(0,collegeNameAndLocation.indexOf("$"));
			  }
			  String collegeLocation = request.getParameter("collegeLocation");
			  if(collegeLocation.equals(""))
			  {
			   collegeLocation = "";
			  }
			  String graduation = request.getParameter("graduation");
			  if(graduation.equals(""))
			  {
			   graduation = "";
			  }
			  
			  
			  String graduationSpeciality = request.getParameter("graduationSpeciality");
			  if(graduationSpeciality.equals("NULL"))
			  {
			   graduationSpeciality = "";
			  }
			  
			  
			  String yearOfPassedOut = request.getParameter("yearOfPassedOut");
			  int yearOfPassedOut1 = 0;
			  if(!yearOfPassedOut.equals("")) {
			   yearOfPassedOut1 = Integer.parseInt(yearOfPassedOut);
			  }
			  String graduationMarks = request.getParameter("graduationMarks");
			  int graduationMarks1 =0 ;
			  if(!graduationMarks.equals(""))
			  {
			   graduationMarks1 = Integer.parseInt(graduationMarks);
			  }
			  
			  
			  String twelveth = request.getParameter("twelveth");
			  int twelvethMarks =0 ;
			  if(!twelveth.equals(""))
			  {
			   twelvethMarks = Integer.parseInt(twelveth);
			  }
			  
			  String tenth = request.getParameter("tenth");
			  int tenthMarks =0 ;
			  if(!tenth.equals(""))
			  {
			   tenthMarks = Integer.parseInt(tenth);
			  }
			  
			  String batchId = request.getParameter("batchId");
			  String employeeType = request.getParameter("employeeType");
			  String coreSkill = request.getParameter("coreSkill");
			  String preferredStudentStream = request.getParameter("preferredStudentStream");
			  if(preferredStudentStream.equals("NULL"))
			  {
			   preferredStudentStream ="";
			  } 
			  String assignedStream = request.getParameter("assignedStream");
			  if(assignedStream.equals("NULL"))
			  {
			   assignedStream ="";
			  }
			  date1 = request.getParameter("dateOfJoining");
			  
			  
			  try{
			   dateOfJoining = format.parse(date1);
			  }
			  catch(Exception e){
			   e.printStackTrace();
			  }
			  String mentorName = request.getParameter("mentorName");
			  if(mentorName.equals("NULL"))
			  {
			   mentorName ="";
			  }
			  String assignedLocation = request.getParameter("assignedLocation");
			  
			  String relocation = request.getParameter("relocation");
			  String status = request.getParameter("status");
			  
			  StudentBean studentBean = new StudentBean(firstName, lastName, dateOfBirth, email, gender, contactNumber,
			    personalLocation, collegeName, collegeLocation, graduation,
			    graduationSpeciality, yearOfPassedOut1, graduationMarks1, twelvethMarks, tenthMarks,
			    batchId, employeeType, coreSkill, preferredStudentStream, assignedStream,
			    dateOfJoining, mentorName, assignedLocation, relocation, status);
			  
			  result = studentService.addStudentDetails(studentBean);
		}catch(Exception e)
		{
			 request.getRequestDispatcher("RegFailure.jsp").include(request, response);;  
		      
		}
		if(result) {
		request.getRequestDispatcher("admin/student_added_successfully.jsp").forward(request, response);; 
		} else {
			request.getRequestDispatcher("RegFailure.jsp").include(request, response);;  
		}
	}
	
}
