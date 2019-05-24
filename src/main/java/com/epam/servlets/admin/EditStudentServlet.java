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

import com.epam.dao.admin.CollegeBean;
import com.epam.dao.admin.StudentBean;
import com.epam.services.admin.StudentService;
import com.epam.services.admin.StudentServiceImpl;
import com.epam.services.login.Menu;
import com.epam.services.login.MenuItemsSingleton;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class EditStudentServlet
 */
@WebServlet("/EditStudentServlet")
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final StudentService studentService = new StudentServiceImpl();
	private static final Logger LOGGER = Logger.getLogger(EditStudentServlet.class);

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentService studentService = new StudentServiceImpl();
		List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems();
		
		
		request.getRequestDispatcher("admin/EditStudentInfo.jsp").forward(request, response);
		
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in EditStudentServlet class");
LOGGER.debug("Entered into EditStudentServlet Class...............");
		
		StudentBean student = new StudentBean();
		student.setFirstName(request.getParameter("firstName"));
		student.setLastName(request.getParameter("lastName"));
		
		System.out.println("dateOfBirth="+request.getParameter("dateOfBirth"));
		
		student.setDob(formatDate(request.getParameter("dateOfBirth")));
		student.setEmail(request.getParameter("email"));
		student.setGender(request.getParameter("gender"));
		student.setContactNumber(mobileValidation(request.getParameter("contactNumber")));
		student.setPersonalLocation(request.getParameter("personalLocation"));
		//String collegeNameAndLocation = request.getParameter("collegeName");
		//String collegeName = "";
		//collegeName = request.getParameter("collegeName");
		student.setCollegeName(request.getParameter("collegeName"));
		
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
		//student.setDateOfJoining(formatDate(request.getParameter("dateOfJoining")));
		student.setMentorName(checkNull(request.getParameter("mentorName")));
		student.setAssignedLocation(request.getParameter("assignedLocation"));
		student.setRelocation(request.getParameter("relocation"));
		student.setStatus(request.getParameter("status"));
				
		editStudentAndRedirect(request, response, student);
		LOGGER.debug("Exit from EditStudentServlet Class...............");
		
	}

	/**
	 * @param dateOfBirth
	 * @param dob
	 * @param format
	 * @return
	 */
	private Date formatDate(String dob) {
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		Date date = null;
		try{
			System.out.println("param dob === "+ dob);
			date = format.parse(dob);
			System.out.println("util date dob === "+ date);
			java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
			System.out.println("sqlStartDate=="+sqlStartDate);
		}
		catch(Exception e){
			e.printStackTrace();
			LOGGER.debug(e.getMessage());
		}
		return date;
	}

	/**
	 * @param collegeNameAndLocation
	 * @param collegeName
	 * @return
	 */
	/*private String extractCollegeName(String collegeNameAndLocation, String collegeName) {
		if(!collegeNameAndLocation.contains("$"))
		{
			collegeName = collegeNameAndLocation;
		}
		else if(!collegeNameAndLocation.equals(""))
		{
			collegeName = collegeNameAndLocation.substring(0,collegeNameAndLocation.indexOf('$'));
		}
		return collegeName;
	}*/

	/**
	 * @param value
	 * @return
	 */
	private String checkNull(String value) {
		if(value.equals("NULL"))
		{
			value ="";
		}
		return value;
	}

	/**
	 * @param request
	 * @param response
	 * @param studentBean
	 */
	private void editStudentAndRedirect(HttpServletRequest request, HttpServletResponse response,
			StudentBean studentBean) {
		int result;
		try {
			  result = studentService.editStudentDetails(studentBean);
			  
			  if(result == 1) {
				    request.setAttribute("result", "success");
					
				} else  if(result == 0){
					request.setAttribute("result", "fail");
				}
			  
			  request.getRequestDispatcher("admin/studentEditedSuccessfully.jsp").forward(request, response);
				
		}
		catch( Exception e)
		{			
			e.printStackTrace();
			 LOGGER.debug(e.getMessage());
		      
		}
	}

	/**
	 * @param contactNumber
	 * @param mobileNumber
	 * @return
	 */
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

	/**
	 * @param marks
	 * @return
	 */
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

}
