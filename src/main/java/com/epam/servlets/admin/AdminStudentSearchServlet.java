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

import com.epam.dao.admin.BatchInfoDAO;
import com.epam.dao.admin.BatchInfoDAOImpl;
import com.epam.dao.admin.MenuAction;
import com.epam.dao.admin.Student;
import com.epam.services.MenuActionItemService;
import com.epam.services.MenuActionItemServiceImpl;
import com.epam.services.admin.AdminStudentInfoService;
import com.epam.services.admin.AdminStudentInfoServiceImpl;
import com.epam.services.login.Menu;
import com.epam.services.login.MenuItemsSingleton;
import com.epam.utils.ConstantsUtility;
import com.epam.utils.DBManager;


@WebServlet("/adminStudentSearch")
public class AdminStudentSearchServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 private final AdminStudentInfoService studentInfoService = new AdminStudentInfoServiceImpl();
	 private static final Logger LOGGER = Logger.getLogger(AdminStudentSearchServlet.class);
	 private final MenuActionItemService menuActionItemService = new MenuActionItemServiceImpl();
	 private final BatchInfoDAO batchInfoDAO = new BatchInfoDAOImpl();
	
	 
	 @Override
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("Enter into Admin Student Search servlet......");
		Connection con=DBManager.getConnection();
		List<Student> studentList =null;
		List<MenuAction> actionList =null;
		List<String> batchIDList= batchInfoDAO.getAllBatchID(con);
		List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems();
		
		String pageUrl=null;
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String batchID = request.getParameter("batchid");
		
		request.setAttribute("firstname", firstName);
		request.setAttribute("lastname", lastName);
		request.setAttribute("batchid", batchID);
		
		request.setAttribute("result", true);
		request.setAttribute("batchIDs", batchIDList);
		request.setAttribute(ConstantsUtility.MENU_LIST, menuList);
		request.setAttribute("pageState", "STUDENT INFO");
		if(firstName.length()!=0 || lastName.length()!=0 || batchID.length()!=0) {
			try{
				int role= (int) request.getSession(true).getAttribute("role");
				studentList=studentInfoService.getAllSearchStudentDetails(con,firstName,lastName,batchID);
				actionList=menuActionItemService.getMenuActionList(con,role);
				pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_STUDENT_INFO);
				request.setAttribute("students", studentList);
				request.setAttribute("actions", actionList);
				
			}catch(Exception e){
				pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
				request.setAttribute("errorMsg", e.getMessage());
				LOGGER.error("Exception occured in AdminStudentSearchServlet = {}", e);

			}
		}else {
			pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_STUDENT_INFO);
			request.setAttribute("students", studentList);
		}
		
		try {
			request.getRequestDispatcher(pageUrl).forward(request, response);
		}catch(Exception e) {
			LOGGER.error("Exception occured in AdminStudentSearchServlet = {}", e);
		}
		
		LOGGER.debug("Exit from Admin Student Search Servlet");
	}

}
