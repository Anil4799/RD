package com.epam.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.dao.admin.AdminBatch;
import com.epam.dao.admin.BatchAction;
import com.epam.services.MenuActionItemService;
import com.epam.services.MenuActionItemServiceImpl;
import com.epam.services.admin.AdminBatchInfoService;
import com.epam.services.admin.AdminBatchInfoServiceImpl;
import com.epam.servlets.admin.AdminBatchInfoListServlet;
import com.epam.utils.ConstantsUtility;
import com.epam.utils.DBManager;

/**
 * Servlet implementation class MenuActionItemServlet
 */
@WebServlet("/actionMenus")
public class MenuActionItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(AdminBatchInfoListServlet.class);
	private final MenuActionItemService menuActionItemService = new MenuActionItemServiceImpl();
	HttpSession session;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("Entered into Servlet...............");
		List<AdminBatch> batchList =null;
		List<BatchAction> actionList =null;
		String pageUrl = null;
		try
		{
			Connection con=DBManager.getConnection();
			//session = request.getSession(true);
			//int role= (int) session.getAttribute("role");
			int role= 1;
			int status=1;
			actionList=menuActionItemService.getMenuActionList(con,role);
			request.setAttribute("actions", actionList);

		}
		catch(Exception e)
		{
			request.setAttribute("errorMsg", e.getMessage());
			LOGGER.error(e.getMessage());
		}
		
		LOGGER.debug("Exit from Servlet...............");
	}
}


