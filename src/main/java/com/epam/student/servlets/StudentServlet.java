package com.epam.student.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.student.beans.StudentBean;
import com.epam.student.services.StudentService;
import com.epam.student.services.StudentServiceImpl;

import org.apache.log4j.Logger;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final StudentService studentService = new StudentServiceImpl();
	private static final Logger LOGGER = Logger.getLogger(StudentServlet.class);

       
       public StudentServlet() {
        super();
    }

       @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   System.out.println("Entered into StudentServlet Class...............");
    	LOGGER.debug("Entered into StudentServlet Class...............");
		boolean result = false;
		
		Date dateOfBirth = null;
		Date dateOfJoining = null;
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String date1 = request.getParameter("dateOfBirth");	
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try{
			dateOfBirth = format.parse(date1);
		}
		catch(Exception e){
			LOGGER.debug(e.getMessage());
		}
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		long contactNumber = 0;
		String mobileNumber = request.getParameter("contactNumber");
		if(!mobileNumber.equals(""))
		{
			try {
				contactNumber =Long.parseLong(mobileNumber);
			}
			catch (NumberFormatException e) {
				LOGGER.debug(e.getMessage());
			}
		 
		}
		else
		{
			contactNumber = 0;
		}
		String personalLocation = request.getParameter("personalLocation");
		String collegeNameAndLocation = request.getParameter("collegeName");
		String collegeName = "";
		if(!collegeNameAndLocation.contains("$"))
		{
			collegeName = collegeNameAndLocation;
		}
		else if(!collegeNameAndLocation.equals(""))
		{
			collegeName = collegeNameAndLocation.substring(0,collegeNameAndLocation.indexOf('$'));
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
			try
			{
				yearOfPassedOut1 = Integer.parseInt(yearOfPassedOut);
			}
			catch (NumberFormatException e) {
				LOGGER.debug(e.getMessage());
			}
			
		}
		String graduationMarks = request.getParameter("graduationMarks");
		int graduationMarks1 =0 ;
		if(!graduationMarks.equals(""))
		{
			try
			{
				graduationMarks1 = Integer.parseInt(graduationMarks);
			}
			catch (NumberFormatException e) {
				LOGGER.debug(e.getMessage());
			}
			
		}
		
		
		String twelveth = request.getParameter("twelveth");
		int twelvethMarks =0 ;
		if(!twelveth.equals(""))
		{
			try
			{
				twelvethMarks = Integer.parseInt(twelveth);
			}
			catch (NumberFormatException e) {
				LOGGER.debug(e.getMessage());
			}
			
		}
		
	
		String tenth = request.getParameter("tenth");
		int tenthMarks =0 ;
		if(!tenth.equals(""))
		{
			try
			{
				tenthMarks = Integer.parseInt(tenth);
			}
			catch (NumberFormatException e) {
				LOGGER.debug(e.getMessage());
			}
			
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
			LOGGER.debug(e.getMessage());
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
		
		try {
			  result = studentService.addStudentDetails(studentBean);
			  
			  if(result) {
					request.getRequestDispatcher("admin/student_added_successfully.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("RegFailure.jsp").include(request, response);  
				}
		}
		catch( IOException | ServletException  e)
		{
			 request.getRequestDispatcher("RegFailure.jsp").include(request, response);
			 LOGGER.debug(e.getMessage());
		      
		}
		LOGGER.debug("Exit from StudentServlet Class...............");
		
	}
	
}
