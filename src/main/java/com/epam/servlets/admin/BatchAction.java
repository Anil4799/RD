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

/**
 * Servlet implementation class BatchAction
 */
@WebServlet("/BatchAction")
public class BatchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(BatchAction.class);
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String pageUrl=null;
	
		String actionVal=request.getParameter("action");
		String batchId=request.getParameter("batchid");
		String startDate=request.getParameter("startDate");
		String endDate=request.getParameter("endDate");
		String status=request.getParameter("status");
		request.setAttribute("action", actionVal);
		request.setAttribute("batchId", batchId);
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		request.setAttribute("status", status);
		if(actionVal.equalsIgnoreCase("View")||actionVal.equalsIgnoreCase("In Progress")) {
			pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_VIEW_ACTION);
		}
		else if(actionVal.equalsIgnoreCase("Completed")) {
			pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_VIEW_ACTION);
		}
		List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems();
		request.setAttribute(ConstantsUtility.MENU_LIST, menuList);
		request.setAttribute("pageState", "BATCH INFO");
			request.getRequestDispatcher(pageUrl).forward(request, response);
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  try {
		doGet(request, response);
	} catch (Exception e) {
		LOGGER.debug(e.getMessage());
	}
	}


}