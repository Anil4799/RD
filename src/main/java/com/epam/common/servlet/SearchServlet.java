package com.epam.common.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.epam.dao.admin.BatchInfoDAO;
import com.epam.dao.admin.BatchInfoDAOImpl;
import com.epam.dao.admin.MenuAction;
import com.epam.dao.admin.StudentBean;
import com.epam.services.MenuActionItemService;
import com.epam.services.MenuActionItemServiceImpl;
import com.epam.services.login.Menu;
import com.epam.services.login.MenuItemsSingleton;
import com.epam.utils.ConstantsUtility;
import com.epam.utils.DBManager;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final StudentInfoService adminStudentInfoService = new StudentInfoServiceImpl();
	private static final StudentInfoService mentorStudentInfoService = new StudentInfoServiceImpl();
	private static final Logger LOGGER = Logger.getLogger( SearchServlet.class); 
	private final MenuActionItemService menuActionItemService = new MenuActionItemServiceImpl();
	private final BatchInfoDAO batchInfoDAO = new BatchInfoDAOImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("Enter into SearchServlet......");
		Connection con = DBManager.getConnection();
		List<StudentBean> mentorStudentList =null;
		List<StudentBean> adminStudentList =null;
		List<MenuAction> actionList =null;
		List<String> batchIDList= batchInfoDAO.getAllBatchID(con);
		List<Menu> menuList = MenuItemsSingleton.getInstance().getMenuItems();
		
		String pageUrl=null;
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String batchID = request.getParameter("batchid");
		
		int role = (int) request.getSession(true).getAttribute("role");
		
		request.setAttribute("firstname",firstName);
		request.setAttribute("lastname",lastName);
		request.setAttribute("batchid",batchID);
		
		request.setAttribute("result",true);
		request.setAttribute("batchIDs", batchIDList);
		request.setAttribute(ConstantsUtility.MENU_LIST, menuList);
		request.setAttribute("pageState", "STUDENT INFO");
		
		if(firstName.length() != 0 || lastName.length() != 0 || batchID.length() != 0) {
			try{
				String mentoremailid = (String)request.getSession(true).getAttribute(ConstantsUtility.EMAIL);
				if(role == 1) {
					adminStudentList = adminStudentInfoService.getAllSearchStudentDetails(con,firstName,lastName,batchID);
					request.setAttribute("students", adminStudentList);
					pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_STUDENT_INFO);
				}else if (role == 2) {
					mentorStudentList = mentorStudentInfoService.getAllSearchStudentDetails(con, mentoremailid, firstName, lastName, batchID);
					request.setAttribute("students", mentorStudentList);
					pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_MENTORSTUDENT_INFO);
				}
				actionList = menuActionItemService.getMenuActionList(con,role);				
				request.setAttribute("actions", actionList);
				
			}catch(Exception e){
				pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
				request.setAttribute("errorMsg", e.getMessage());
				LOGGER.error("Exception occured in SearchServlet = {}", e);
			}
		}else if(role == 1) {
			pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_STUDENT_INFO);
		}else if(role == 2) {
			pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_MENTORSTUDENT_INFO);
		}
		try {
			request.getRequestDispatcher(pageUrl).forward(request, response);
          }
		catch(Exception e)
		{
			LOGGER.error("Exception occured in SearchServlet = {}", e);
		}
		
		LOGGER.debug("Exit from SearchServlet..");
	}
	

}
