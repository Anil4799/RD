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
import com.epam.utils.ConstantsUtility;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	 private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	HttpSession session;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// LOGGER.debug("Entered into Servlet...............");
		String pageUrl = null;
		String email=null;
		String password=null;
		try {
			LOGGER.info("session..............." + session);
			email = request.getParameter("email");
			password = request.getParameter("password");
			if(email.length()==0||password.length()==0) {
				request.setAttribute("loginFail", "User Name or Password is required");
				pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.LOGIN_PAGE);
			}
			else{
				int roleId = new LoginServiceImp().login(email, password);
				if (roleId != 0) {
					pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.HOME_PAGE);
					// Get MenuList
					ArrayList<Menu> menuList = new GetMenuItemsServiceImpl().getMenuItems(roleId);
					request.setAttribute("menuList", menuList);
					// Set Session
					session = request.getSession(true);
					session.setAttribute("email", email);
					System.out.println(session.getAttribute("email"));
				} else {
					request.setAttribute("loginFail", "User Name or Password is incorrect");
					pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.LOGIN_PAGE);
					session =null;
				}
			}
			} catch (Exception e) {
				// request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
				// LOGGER.error(nEx.getMessage());
				request.setAttribute("errorMsg", e.getMessage());
		}
		LOGGER.info("session -2 ..............." + session);
		if(session!=null)
			request.getRequestDispatcher(pageUrl).forward(request, response);
		else {
			pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.LOGIN_PAGE);
			request.getRequestDispatcher(pageUrl).forward(request, response);
		}
			
		// LOGGER.debug("Exit from Servlet...............");
		// doGet(request, response);
	}

}
