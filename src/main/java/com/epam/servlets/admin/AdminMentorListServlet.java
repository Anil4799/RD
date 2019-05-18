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

import com.epam.dao.admin.Mentor;
import com.epam.dao.admin.MenuAction;
import com.epam.services.MenuActionItemService;
import com.epam.services.MenuActionItemServiceImpl;
import com.epam.services.admin.AdminMentorInfoService;
import com.epam.services.admin.AdminMentorInfoServiceImpl;
import com.epam.services.login.Menu;
import com.epam.services.login.MenuItemsSingleton;
import com.epam.utils.ConstantsUtility;
import com.epam.utils.DBManager;

@WebServlet("/mentorList")
public class AdminMentorListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger( AdminMentorListServlet.class);
	

	 private static final AdminMentorInfoService mentorInfoService = new AdminMentorInfoServiceImpl();
	private final MenuActionItemService menuActionItemService = new MenuActionItemServiceImpl();

		
     @Override
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("Enter into servlet......");
		List<Mentor> mentorList =null;
		List<MenuAction> actionList =null;
		String pageUrl=null;
		try
		{
			
			
			Connection con=DBManager.getConnection();
			int role= (int) request.getSession(true).getAttribute("role");
			actionList=menuActionItemService.getMenuActionList(con,role);
			mentorList=mentorInfoService.getAllMentorDetails(con);
			pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_MENTOR_INFO);
			request.setAttribute("mentors", mentorList);
			request.setAttribute("actions", actionList);
			List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems();
			request.setAttribute("pageState", "MENTOR INFO");
			request.setAttribute(ConstantsUtility.MENU_LIST, menuList);
			
		}
		catch(Exception e)
		{
			LOGGER.error("Exception occured in MentorInfo = {}", e);
			pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
			request.setAttribute("errorMsg", e.getMessage());
			
			
		}
		
		try {
			request.getRequestDispatcher(pageUrl).forward(request, response);
		}
		catch(Exception e)
		{
			LOGGER.error("Exception occured in MentorInfo = {}", e);
		}
		LOGGER.debug("Exit from servlet");
	}

}
