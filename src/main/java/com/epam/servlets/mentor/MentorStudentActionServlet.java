package com.epam.servlets.mentor;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.dao.admin.StudentBean;
import com.epam.dao.mentor.MentorStudent;
import com.epam.services.login.Menu;
import com.epam.services.login.MenuItemsSingleton;
import com.epam.services.mentor.MentorStudentInfoService;
import com.epam.services.mentor.MentorStudentInfoServiceImpl;
import com.epam.utils.ConstantsUtility;
import com.epam.utils.DBManager;

/**
 * Servlet implementation class MentorStudentActionServlet
 */
@WebServlet("/MentorStudentActionServlet")
public class MentorStudentActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final MentorStudentInfoService studentInfoService = new MentorStudentInfoServiceImpl();
	  private static final Logger LOGGER = Logger.getLogger( MentorStudentActionServlet.class); 

       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String actionView=request.getParameter("actionView");
		String studentEmailId=request.getParameter("email_id");
		List<StudentBean> studentList =null;
		String pageUrl=null;
		
		if(actionView.equalsIgnoreCase("View"))
		{
			
			
			try(Connection con=DBManager.getConnection();)
			{
				studentList=studentInfoService.mentorViewStudentDetails(con, studentEmailId);
				pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_MENTOR_VIEW_STUDENT_INFO);
				request.setAttribute("students", studentList);
				List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems();
				request.setAttribute(ConstantsUtility.MENU_LIST, menuList);
				request.setAttribute("pageState", "STUDENT INFO");
				request.getRequestDispatcher(pageUrl).forward(request, response);

			}
			catch(Exception e)
			{
				pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
				request.setAttribute("errorMsg", e.getMessage());
				request.getRequestDispatcher(pageUrl).forward(request, response);
				LOGGER.error("Exception occured in MentorStudentInfo = {}", e);
			}
		
			LOGGER.debug("Exit from servlet");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
