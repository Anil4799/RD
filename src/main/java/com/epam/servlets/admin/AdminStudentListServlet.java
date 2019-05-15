package com.epam.servlets.admin;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.epam.dao.admin.AdminStudent;
import com.epam.services.admin.AdminStudentInfoService;
import com.epam.services.admin.AdminStudentInfoServiceImpl;
import com.epam.utils.ConstantsUtility;
import com.epam.utils.DBManager;

@WebServlet("/studentList")
public class AdminStudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminStudentInfoService studentInfoService = new AdminStudentInfoServiceImpl();
	private static final Logger LOGGER = Logger.getLogger( AdminStudentListServlet.class);
    
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AdminStudent> studentList =null;
		LOGGER.debug("Enter into servlet......");
		String pageUrl=null;
		try(Connection con=DBManager.getConnection();)
		{
			studentList=studentInfoService.getAllStudentDetails(con);
			pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_STUDENT_INFO);
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
