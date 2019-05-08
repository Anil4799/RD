package com.epam.servlets.login;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.services.login.GetMenuItemsServiceImpl;
import com.epam.services.login.LoginServiceImp;
import com.epam.services.login.Menu;
import com.epam.servlets.CalculatorServlet;
import com.epam.utils.ConstantsUtility;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	//private static final Logger LOGGER = Logger.getLogger(CalculatorServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//LOGGER.debug("Entered into Servlet...............");
		String pageUrl = null;
		try {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int id = new LoginServiceImp().login(email, password);
		
		if(id!=0) { 
			pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.HOME_PAGE);
			//Get MenuList
			ArrayList<Menu> menuList = new GetMenuItemsServiceImpl().getMenuItems(id);
			request.setAttribute("menuList", menuList);
			//Set Session
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			session.setAttribute("password", password);
		}
		else
			pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
		} catch (NumberFormatException nEx) {
			pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
			//LOGGER.error(nEx.getMessage());
			request.setAttribute("errorMsg", nEx.getMessage());
		}
		
		
		
		request.getRequestDispatcher(pageUrl).forward(request, response);
		//LOGGER.debug("Exit from Servlet...............");
		doGet(request, response);
	}

}
