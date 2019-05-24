package com.epam.servlets.admin;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class AdminBatchInfoListWithInDateRange
 */
@WebServlet("/AdminBatchInfoListWithInDateRange")
public class AdminBatchInfoListWithInDateRange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger LOGGER = Logger.getLogger(AdminBatchInfoListServlet.class);
	private final AdminBatchInfoService batchInfoListService = new AdminBatchInfoServiceImpl();
	private final MenuActionItemService menuActionItemService = new MenuActionItemServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				LOGGER.debug("Entered into Servlet...............");
				List<Batch> batchList =null;
				List<MenuAction> actionList =null;
				String pageUrl = null;
				try
				{
					String startDate=request.getParameter("startDate");
					String endDate=request.getParameter("endDate");
					System.out.println("dates received "+startDate+" "+endDate);
					Connection con=DBManager.getConnection();
					
					int role= (int) request.getSession(true).getAttribute("role");
					
					actionList=menuActionItemService.getMenuActionList(con,role);
					
					batchList=batchInfoListService.getAllBatchListWithInDateRange(con, startDate, endDate);
					
					//int batchListSize=batchList.size();
					pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_BATCH_INFO);
					request.setAttribute("batchs", batchList);
					request.setAttribute("actions", actionList);
					List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems();
					request.setAttribute(ConstantsUtility.MENU_LIST, menuList);
					request.setAttribute("pageState", "BATCH INFO");
					//System.out.println("------------> "+batchList.size());
					request.setAttribute("resultSize", batchList.size());
					request.setAttribute("searchResult", "a");
					
					request.getRequestDispatcher(pageUrl).forward(request, response);


				}
				catch(Exception e)
				{
					pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
					request.setAttribute("errorMsg", e.getMessage());
					LOGGER.error(e.getMessage());
					request.getRequestDispatcher(pageUrl).forward(request, response);

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
				
				
	}

	
