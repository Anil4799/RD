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
import com.epam.services.login.Menu;
import com.epam.services.login.MenuItemsSingleton;
import com.epam.services.mentor.MentorStudentInfoService;
import com.epam.services.mentor.MentorStudentInfoServiceImpl;
import com.epam.utils.ConstantsUtility;
import com.epam.utils.DBManager;

@WebServlet("/mentorstudentList")
public class MentorStudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final MentorStudentInfoService studentInfoService = new MentorStudentInfoServiceImpl();
	  private static final Logger LOGGER = Logger.getLogger( MentorStudentListServlet.class); 
    @Override
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("Enter into servlet......");
		List<MentorStudent> studentList =null;
		String pageUrl=null;
		
		try(Connection con=DBManager.getConnection();)
		{
			HttpSession session=request.getSession(false);  
			String mentoremailid=(String)session.getAttribute("email"); 
			studentList=studentInfoService.mentorStudentDetails(con,mentoremailid);
			pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_MENTORSTUDENT_INFO);
			request.setAttribute("students", studentList);
			List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems();
			request.setAttribute(ConstantsUtility.MENU_LIST, menuList);
			request.setAttribute("pageState", "STUDENT INFO");
		}
		catch(Exception e)
		{
			pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
			request.setAttribute("errorMsg", e.getMessage());
			LOGGER.error("Exception occured in MentorStudentInfo = {}", e);
		}
		try {
			request.getRequestDispatcher(pageUrl).forward(request, response);
          }
		catch(Exception e)
		{
			LOGGER.debug(e.getMessage());
		}
		
		LOGGER.debug("Exit from servlet");
	}

}
