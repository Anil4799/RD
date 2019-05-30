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

import com.epam.dao.admin.Batch;
import com.epam.dao.admin.MenuAction;
import com.epam.services.MenuActionItemService;
import com.epam.services.MenuActionItemServiceImpl;
import com.epam.services.admin.AdminBatchInfoService;
import com.epam.services.admin.AdminBatchInfoServiceImpl;
import com.epam.services.login.Menu;
import com.epam.services.login.MenuItemsSingleton;
import com.epam.utils.ConstantsUtility;
import com.epam.utils.DBManager;

@WebServlet("/batchInfo")
public class AdminBatchInfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger LOGGER = Logger.getLogger(AdminBatchInfoListServlet.class);
	private final AdminBatchInfoService batchInfoListService = new AdminBatchInfoServiceImpl();
	private final MenuActionItemService menuActionItemService = new MenuActionItemServiceImpl();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("Entered into Servlet...............");
		List<Batch> batchList =null;
		List<Batch> batchListRange =null;
		List<MenuAction> actionList =null;
		String pageUrl = null;
		try
		{
			
			
			String testSearchOrNot=request.getParameter("testSearchOrNot");
			
			Connection con=DBManager.getConnection();
			int role= (int) request.getSession(true).getAttribute("role");
			actionList=menuActionItemService.getMenuActionList(con,role);
			
			batchList=batchInfoListService.getAllBatchsList(con);
			
			
			if(testSearchOrNot.equals("ok")) {
				String startDate=request.getParameter("startDate");
				String endDate=request.getParameter("endDate");
				
			batchListRange=batchInfoListService.getAllBatchListWithInDateRange(con, startDate, endDate);
			
			request.setAttribute("batchsRange", batchListRange);
			request.setAttribute("searchedOrNot", "a");
			request.setAttribute("startDate", startDate);
			request.setAttribute("endDate", endDate);
			request.setAttribute("resultSize", batchListRange.size());
			
			}
			
			
			pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_BATCH_INFO);
			request.setAttribute("batchs", batchList);
			
			request.setAttribute("actions", actionList);
			
			List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems();
			request.setAttribute(ConstantsUtility.MENU_LIST, menuList);
			
			request.setAttribute("pageState", "BATCH INFO");
			
			request.setAttribute("searchResult", "");
			
			
			
			
			goToURL(request, response, pageUrl);


		}
		catch(Exception e)
		{
			pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
			request.setAttribute("errorMsg", e.getMessage());
			LOGGER.error(e.getMessage());
			e.printStackTrace();
			goToURL(request, response, pageUrl);

		}

		LOGGER.debug("Exit from Servlet...............");
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  try {
		doGet(request, response);
	} catch (Exception e) {
		LOGGER.debug(e.getMessage());
	}
	}
	
	public void goToURL(HttpServletRequest request, HttpServletResponse response,String pageUrl)
	{
		try {
			request.getRequestDispatcher(pageUrl).forward(request, response);
		} catch (Exception e1) {
			LOGGER.error(e1.getMessage());
		}
	}
}
