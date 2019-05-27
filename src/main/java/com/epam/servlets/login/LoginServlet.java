package com.epam.servlets.login;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.services.login.LoginServiceImp;
import com.epam.services.login.Menu;
import com.epam.services.login.MenuItemsSingleton;
import com.epam.utils.ConstantsUtility;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet implements Serializable {
	private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);
	private static final long serialVersionUID = 1L;

	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.LOGIN_PAGE);
		goToURL(request, response, pageUrl);
		}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageUrl = null;
		String email=null;
		String password=null;
		email = request.getParameter(ConstantsUtility.EMAIL);
		password = request.getParameter("password");
		if(email.length()==0||password.length()==0) {
			request.setAttribute("loginFail", "User Name or Password is required");
			pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.LOGIN_PAGE);
		}else{
			int roleId = new LoginServiceImp().login(email, password);
			if (roleId == 1) {
				pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.ADMIN_HOME_PAGE);
				List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems(roleId);
				request.getSession(true).setAttribute(ConstantsUtility.EMAIL, email);
				request.getSession(true).setAttribute(ConstantsUtility.ROLE, roleId);
				request.setAttribute(ConstantsUtility.MENU_LIST, menuList);
			} else if(roleId == 2){ 
				pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.MENTOR_HOME_PAGE);
				List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems(roleId);
				request.getSession(true).setAttribute(ConstantsUtility.EMAIL, email);
				request.getSession(true).setAttribute(ConstantsUtility.ROLE, roleId);
				request.setAttribute(ConstantsUtility.MENU_LIST, menuList);
			} else{
				request.setAttribute("loginFail", "User Name or Password is incorrect");
				pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.LOGIN_PAGE);
			}
		}
		
			goToURL(request, response, pageUrl);

			
		LOGGER.debug("Exit from Servlet...............");
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
