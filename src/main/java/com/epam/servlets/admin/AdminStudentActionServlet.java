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
import com.epam.dao.admin.StudentBean;
import com.epam.services.admin.AdminStudentInfoService;
import com.epam.services.admin.AdminStudentInfoServiceImpl;
import com.epam.services.login.Menu;
import com.epam.services.login.MenuItemsSingleton;
import com.epam.utils.ConstantsUtility;
import com.epam.utils.DBManager;

@WebServlet("/AdminStudentActionServlet")
public class AdminStudentActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private final AdminStudentInfoService studentInfoService = new AdminStudentInfoServiceImpl();
	 private static final Logger LOGGER = Logger.getLogger( AdminStudentListServlet.class);
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionView=request.getParameter("actionView");
		String emailId=request.getParameter("email_id");
		List<StudentBean> studentList =null;
		LOGGER.debug("Enter into servlet......");
		String pageUrl=null;
		
		if(actionView.equalsIgnoreCase("View"))
		{
			
			try(Connection con=DBManager.getConnection();)
			{
				studentList=studentInfoService.adminStudentDetails(con, emailId);
				pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_VIEW_STUDENT_INFO);
				request.setAttribute("student", studentList);
				List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems();
				request.setAttribute(ConstantsUtility.MENU_LIST, menuList);
				request.setAttribute("pageState", "STUDENT INFO");
				LOGGER.debug("Exit from servlet");
				request.getRequestDispatcher(pageUrl).forward(request, response);
				
			}
			catch(Exception e)
			{
				pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
				request.setAttribute("errorMsg", e.getMessage());
				LOGGER.error("Exception occured in StudentViewPage = {}", e);
				try {
				request.getRequestDispatcher(pageUrl).forward(request, response);
				}
				catch(Exception ex) {
					LOGGER.error("Exception occured in StudentViewErrorPage = {}", ex);
				}
			}
		}
		
	}

	
}
