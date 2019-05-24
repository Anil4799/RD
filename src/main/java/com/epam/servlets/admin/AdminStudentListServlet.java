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
import com.epam.dao.admin.Student;
import com.epam.dao.admin.BatchInfoDAO;
import com.epam.dao.admin.BatchInfoDAOImpl;
import com.epam.dao.admin.MenuAction;
import com.epam.services.MenuActionItemService;
import com.epam.services.MenuActionItemServiceImpl;
import com.epam.services.admin.AdminStudentInfoService;
import com.epam.services.admin.AdminStudentInfoServiceImpl;
import com.epam.services.login.Menu;
import com.epam.services.login.MenuItemsSingleton;
import com.epam.utils.ConstantsUtility;
import com.epam.utils.DBManager;


@WebServlet("/studentList")
public class AdminStudentListServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 private final AdminStudentInfoService studentInfoService = new AdminStudentInfoServiceImpl();
	 private static final Logger LOGGER = Logger.getLogger( AdminStudentListServlet.class);
	 private final MenuActionItemService menuActionItemService = new MenuActionItemServiceImpl();
	 private final BatchInfoDAO batchInfoDAO = new BatchInfoDAOImpl();
	 @Override
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> studentList =null;
		List<MenuAction> actionList =null;
		List<String> batchIDList=null;
		LOGGER.debug("Enter into servlet......");
		String pageUrl=null;
		request.setAttribute("result", false);
		try(Connection con=DBManager.getConnection();)
		{
			int role= (int) request.getSession(true).getAttribute("role");
			studentList=studentInfoService.getAllStudentDetails(con);
			actionList=menuActionItemService.getMenuActionList(con,role);
			batchIDList = batchInfoDAO.getAllBatchID(con);
			pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_STUDENT_INFO);
			request.setAttribute("students", studentList);

			request.setAttribute("actions", actionList);
			request.setAttribute("batchIDs", batchIDList);
			List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems();
			request.setAttribute(ConstantsUtility.MENU_LIST, menuList);
			request.setAttribute("pageState", "STUDENT INFO");
			request.getRequestDispatcher(pageUrl).forward(request, response);

		}
		catch(Exception e)
		{
			pageUrl=request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
			request.setAttribute("errorMsg", e.getMessage());
			LOGGER.error("Exception occured in AdminStudentListServlet = {}", e);
			request.getRequestDispatcher(pageUrl).forward(request, response);

		}
		LOGGER.debug("Exit from servlet");
	}

}
