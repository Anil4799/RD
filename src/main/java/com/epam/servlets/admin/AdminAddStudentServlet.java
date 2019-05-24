package com.epam.servlets.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.dao.admin.CollegeBean;
import com.epam.services.admin.StudentService;
import com.epam.services.admin.StudentServiceImpl;
import com.epam.services.login.Menu;
import com.epam.services.login.MenuItemsSingleton;
import com.epam.utils.ConstantsUtility;

/**
 * Servlet implementation class BatchInfoListServlet
 */
@WebServlet("/addStudent")
public class AdminAddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentService studentService = new StudentServiceImpl();
       
	private static final Logger LOGGER = Logger.getLogger(AdminAddStudentServlet.class);

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("Entered into Servlet...............");
		String pageUrl = null;
		try
		{
			pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.ADD_PAGE_FOR_STUDENT_INFO);
			List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems();
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
			
//			List<StudentBean> graduationSpeciality = studentService.getGraduationSpeciality();
//			request.setAttribute("graduationSpeciality", graduationSpeciality);
			
			request.setAttribute("pageState", "STUDENT INFO");
			request.setAttribute(ConstantsUtility.MENU_LIST, menuList);
			request.getRequestDispatcher(pageUrl).forward(request, response);

			

		}
		catch(Exception e1)
		{
			LOGGER.error(e1.getMessage());
			pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
			request.setAttribute("errorMsg", e1.getMessage());
			request.getRequestDispatcher(pageUrl).forward(request, response);

		}
		LOGGER.debug("Exit from Servlet...............");
	}

}
