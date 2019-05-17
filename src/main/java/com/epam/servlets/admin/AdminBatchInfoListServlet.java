package com.epam.servlets.admin;
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
import com.epam.dao.admin.MenuAction;
import com.epam.services.MenuActionItemService;
import com.epam.services.MenuActionItemServiceImpl;
import com.epam.services.admin.AdminBatchInfoService;
import com.epam.services.admin.AdminBatchInfoServiceImpl;
import com.epam.utils.ConstantsUtility;
import com.epam.utils.DBManager;

@WebServlet("/batchInfo")
public class AdminBatchInfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger LOGGER = Logger.getLogger(AdminBatchInfoListServlet.class);
	private final AdminBatchInfoService batchInfoListService = new AdminBatchInfoServiceImpl();
	private final MenuActionItemService menuActionItemService = new MenuActionItemServiceImpl();
	private static HttpSession session;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("Entered into Servlet...............");
		List<AdminBatch> batchList =null;
		List<MenuAction> actionList =null;
		String pageUrl = null;
		try
		{
			Connection con=DBManager.getConnection();
			session = request.getSession(true);
			int role= (int) session.getAttribute("role");
			actionList=menuActionItemService.getMenuActionList(con,role);
			batchList=batchInfoListService.getAllBatchsList(con);
			pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_BATCH_INFO);
			request.setAttribute("batchs", batchList);
			request.setAttribute("actions", actionList);
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
		}
		catch(Exception e)
		{
			LOGGER.error(e.getMessage());
		}
		LOGGER.debug("Exit from Servlet...............");
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	  doGet(request, response);
	}
}
