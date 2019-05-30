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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
@Override    
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			request.getRequestDispatcher("admin/EditStudentInfo.jsp").forward(request, response);
		} catch (Exception e) {
			
			LOGGER.error(e.getMessage());
		}
		
	}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
LOGGER.debug("Entered into EditStudentServlet Class...............");
		
		StudentBean student = new StudentBean();
		student.setFirstName(request.getParameter("firstName"));
		student.setLastName(request.getParameter("lastName"));
		
		
		student.setDob(formatDate(request.getParameter("dateOfBirth")));
		student.setEmail(request.getParameter("email"));
		student.setGender(request.getParameter("gender"));
		student.setContactNumber(mobileValidation(request.getParameter("contactNumber")));
		student.setPersonalLocation(request.getParameter("personalLocation"));
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
		student.setMentorName(checkNull(request.getParameter("mentorName")));
		student.setAssignedLocation(request.getParameter("assignedLocation"));
		student.setRelocation(request.getParameter("relocation"));
		student.setStatus(request.getParameter("status"));
				
		List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems();
		request.setAttribute(ConstantsUtility.MENU_LIST, menuList);
		request.setAttribute("pageState", "STUDENT INFO");
		
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
			date = format.parse(dob);
		}
		catch(Exception e){
			LOGGER.debug(e.getMessage());
		}
		return date;
	}

	/**
	 * @param collegeNameAndLocation
	 * @param collegeName
	 * @return
	 */
	
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
