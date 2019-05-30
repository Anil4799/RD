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

@WebServlet("/EditStudentServlet")
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final StudentService studentService = new StudentServiceImpl();
	private static final Logger LOGGER = Logger.getLogger(EditStudentServlet.class);
	

    
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
		
		StudentServlet studentServlet = new StudentServlet();
		StudentBean student = new StudentBean();
		student = studentServlet.setParameters(student, request);
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

		editStudentAndRedirect(request, response, student);
		LOGGER.debug("Exit from EditStudentServlet Class...............");
		
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

}
