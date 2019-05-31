package com.epam.servlets.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.dao.admin.StudentBean;
import com.epam.services.admin.StudentService;
import com.epam.services.admin.StudentServiceImpl;
import com.epam.services.login.Menu;
import com.epam.services.login.MenuItemsSingleton;
import com.epam.utils.ConstantsUtility;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final StudentService studentService = new StudentServiceImpl();
	private static final Logger LOGGER = Logger.getLogger(StudentServlet.class);
	
	private static final String RESULT = "result";
	 

    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	LOGGER.debug("Entered into StudentServlet Class+++++++++");
		
		StudentBean student = new StudentBean();
		student = setParameters(student,request);
		String collegeNameAndLocation = request.getParameter("collegeName");
		String collegeName = "";
		collegeName = extractCollegeName(collegeNameAndLocation, collegeName);
		student.setCollegeName(extractCollegeName(collegeNameAndLocation, collegeName));
		
		String collegeLocation = request.getParameter("collegeLocation");
		String graduation = request.getParameter("graduation");
		if(collegeLocation.equals(""))
		{
			collegeLocation = "";
		}
		
		if(graduation.equals(""))
		{
			graduation = "";
		}
		
		student.setCollegeLocation(collegeLocation);

		student.setGraduation(graduation);	
		
		List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems();
		request.setAttribute(ConstantsUtility.MENU_LIST, menuList);
		
		request.setAttribute("pageState", "STUDENT INFO");
		
		if((request.getParameter("action")).equals("save"))
		{
			addStudentAndRedirect(request, response, student);
		}
		else if((request.getParameter("action")).equals("edit"))
		{
			editStudentAndRedirect(request, response, student);
		}
		
		
		
		LOGGER.debug("Exit from StudentServlet Class...............");
	}
	private Date formatDate(String dob) {
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		
		Date date = null;
		try{
			date = format.parse(dob);
		}
		catch(Exception e){
			LOGGER.debug(e.getMessage());
		}
		return date;
	}

	private String extractCollegeName(String collegeNameAndLocation, String collegeName) {
		if(!collegeNameAndLocation.contains("$"))
		{
			collegeName = collegeNameAndLocation;
		}
		else if(!collegeNameAndLocation.equals(""))
		{
			collegeName = collegeNameAndLocation.substring(0,collegeNameAndLocation.indexOf('$'));
		}
		return collegeName;
	}


	private String checkNull(String value) {
		if(value.equals("NULL"))
		{
			value ="";
		}
		return value;
	}

	private void addStudentAndRedirect(HttpServletRequest request, HttpServletResponse response,
			StudentBean studentBean) {
		int result;
		try {
			  result = studentService.addStudentDetails(studentBean);
			  
			  if(result == 1) {
				    request.setAttribute(RESULT, "success");
					
				} else  if(result == 0){
					request.setAttribute(RESULT, "fail");
				} 
			  
			  request.getRequestDispatcher("admin/student_added_successfully.jsp").forward(request, response);
				
		}
		catch( Exception e)
		{			 
			 LOGGER.debug(e.getMessage());
		      
		}
	}
	
	private void editStudentAndRedirect(HttpServletRequest request, HttpServletResponse response,
			StudentBean studentBean) {
		int result;
		try {
			  result = studentService.editStudentDetails(studentBean);
			  
			  if(result == 1) {
				    request.setAttribute(RESULT, "success");
					
				} else  if(result == 0){
					request.setAttribute(RESULT, "fail");
				}
			  
			  request.getRequestDispatcher("admin/studentEditedSuccessfully.jsp").forward(request, response);
				
		}
		catch( Exception e)
		{			
			 LOGGER.debug(e.getMessage());
		      
		}
	}

	private long mobileValidation( String mobileNumber) {
		long contactNumber = 0 ;
		if(!mobileNumber.equals(""))
		{
			try {
				contactNumber =Long.parseLong(mobileNumber);
			}
			catch (NumberFormatException e) {
				LOGGER.debug(e.getMessage());
			}
		 
		}
		return contactNumber;
	}

	private int marksValidation(String marks) {
		int totalMarks =0 ;
		if(!marks.equals(""))
		{
			try
			{
				totalMarks = Integer.parseInt(marks);
			}
			catch (NumberFormatException e) {
				LOGGER.debug(e.getMessage());
			}
			
		}
		return totalMarks;
	}
	public StudentBean setParameters(StudentBean student, HttpServletRequest request) {
		student.setFirstName(request.getParameter("firstName"));
		student.setLastName(request.getParameter("lastName"));
		student.setDob(formatDate(request.getParameter("dateOfBirth")));
		student.setEmail(request.getParameter("email"));
		student.setGender(request.getParameter("gender"));
		student.setContactNumber(mobileValidation(request.getParameter("contactNumber")));
		student.setPersonalLocation(request.getParameter("personalLocation"));
		student.setGraduationSpeciality(checkNull(request.getParameter("graduationSpeciality")));
		int yearOfPassedOut1 = marksValidation(request.getParameter("yearOfPassedOut"));
		int graduationMarks1 = marksValidation( request.getParameter("graduationMarks"));	
		int twelvethMarks = marksValidation(request.getParameter("twelveth"));
		int tenthMarks = marksValidation(request.getParameter("tenth"));
		student.setYearOfPassedOut(yearOfPassedOut1);
		student.setGraduationMarks(graduationMarks1);
		student.setTwelveth(twelvethMarks);
		student.setTenth(tenthMarks);
		student.setBatchId(request.getParameter("batchId"));
		student.setEmployeeType(request.getParameter("employeeType"));
		student.setCoreSkill(request.getParameter("coreSkill"));
		student.setPreferredStudentStream(checkNull(request.getParameter("preferredStudentStream")));
		student.setAssignedStream(checkNull(request.getParameter("assignedStream")));
		student.setDateOfJoining(formatDate(request.getParameter("dateOfJoining")));
		student.setMentorName(checkNull(request.getParameter("mentorName")));
		student.setAssignedLocation(request.getParameter("assignedLocation"));
		student.setRelocation(request.getParameter("relocation"));
		student.setStatus(request.getParameter("status"));
		return student;
	}
	
}
