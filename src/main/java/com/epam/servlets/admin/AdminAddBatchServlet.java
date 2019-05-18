package com.epam.servlets.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.services.login.Menu;
import com.epam.services.login.MenuItemsSingleton;
import com.epam.utils.ConstantsUtility;


@WebServlet("/addBatch")
public class AdminAddBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger LOGGER = Logger.getLogger(AdminAddBatchServlet.class);
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("Entered into Servlet...............");
		String pageUrl = null;
		try
		{
			pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.ADD_PAGE_FOR_BATCH_INFO);
			List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems();
			request.setAttribute(ConstantsUtility.MENU_LIST, menuList);
			request.setAttribute("pageState", "BATCH INFO");

		}
		catch(Exception e)
		{
			pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
			request.setAttribute("errorMsg", e.getMessage());
			LOGGER.error(e.getMessage());
		}
		try {
		request.getRequestDispatcher(pageUrl).forward(request, response);
		}catch(Exception exception){
			LOGGER.error(exception.getMessage());
		}
		finally {
			LOGGER.debug("Exit from Servlet...............");
		}
	}

}
