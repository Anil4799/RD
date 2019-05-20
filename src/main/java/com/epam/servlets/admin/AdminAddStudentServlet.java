package com.epam.servlets.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

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
			List<String> collegeNames=studentService.getCollegNames();
			request.setAttribute("collegeNames", collegeNames);
			request.setAttribute("pageState", "STUDENT INFO");
			request.setAttribute(ConstantsUtility.MENU_LIST, menuList);
			

		}
		catch(Exception e1)
		{
			LOGGER.error(e1.getMessage());
			pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
			request.setAttribute("errorMsg", e1.getMessage());
			
		}
		
		try {
			request.getRequestDispatcher(pageUrl).forward(request, response);
		} catch (Exception e1) {
			LOGGER.debug(e1.getMessage());
		}
		LOGGER.debug("Exit from Servlet...............");
	}

}
