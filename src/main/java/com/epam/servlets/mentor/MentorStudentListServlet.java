package com.epam.servlets.mentor;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import com.epam.dao.mentor.MentorStudent;
import com.epam.services.mentor.MentorStudentInfoService;
import com.epam.services.mentor.MentorStudentInfoServiceImpl;
import com.epam.utils.ConstantsUtility;
import com.epam.utils.DBManager;

@WebServlet("/mentorstudentList")
public class MentorStudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private MentorStudentInfoService studentInfoService = new MentorStudentInfoServiceImpl();
	  private static final Logger LOGGER = Logger.getLogger( MentorStudentListServlet.class); 
    
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("Enter into servlet......");
		List<MentorStudent> studentList =null;
		String pageUrl=null;
		
		try(Connection con=DBManager.getConnection();)
		{
			HttpSession session=request.getSession(false);  
			String mentor_email_id=(String)session.getAttribute("email"); 
			studentList=studentInfoService.mentorStudentDetails(con,mentor_email_id);
			pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_MENTORSTUDENT_INFO);
			request.setAttribute("students", studentList);
			request.setAttribute("pageState", "STUDENT INFO");
		}
		catch(Exception e)
		{
			pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
			request.setAttribute("errorMsg", e.getMessage());
			LOGGER.error("Exception occured in MentorStudentInfo = {}", e);
		}
		
		request.getRequestDispatcher(pageUrl).forward(request, response);
		LOGGER.debug("Exit from servlet");
	}

}
