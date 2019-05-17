package com.epam.servlets.login;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.services.login.MenuItemsServiceImpl;
import com.epam.services.login.LoginServiceImp;
import com.epam.services.login.Menu;
import com.epam.utils.ConstantsUtility;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet implements Serializable {
	private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);
	private static final long serialVersionUID = 1L;

	private static HttpSession session;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageUrl = null;
		String email=null;
		String password=null;
		LOGGER.info("session..............." + session);
		email = request.getParameter(ConstantsUtility.EMAIL);
		password = request.getParameter("password");
		if(email.length()==0||password.length()==0) {
			request.setAttribute("loginFail", "User Name or Password is required");
			pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.LOGIN_PAGE);
		}else{
			int roleId = new LoginServiceImp().login(email, password);
			if (roleId == 1) {
				pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.ADMIN_HOME_PAGE);
				List<Menu> menuList = (ArrayList<Menu>) new MenuItemsServiceImpl().getMenuItems(roleId);
				session = request.getSession(true);
				session.setAttribute(ConstantsUtility.EMAIL, email);
				session.setAttribute(ConstantsUtility.ROLE, roleId);
				session.setAttribute(ConstantsUtility.MENU_LIST, menuList);
			} else if(roleId == 2){ 
				pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.MENTOR_HOME_PAGE);
				List<Menu> menuList = (ArrayList<Menu>) new MenuItemsServiceImpl().getMenuItems(roleId);
				session = request.getSession(true);
				session.setAttribute(ConstantsUtility.EMAIL, email);
				session.setAttribute(ConstantsUtility.ROLE, roleId);
				session.setAttribute(ConstantsUtility.MENU_LIST, menuList);
			} else{
				request.setAttribute("loginFail", "User Name or Password is incorrect");
				pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.LOGIN_PAGE);
			}
		}
		
		LOGGER.info("session -2 ..............." + session);
		if(session!=null) {
			try {
				request.getRequestDispatcher(pageUrl).forward(request, response);
			}catch(Exception e) {
				LOGGER.info("Exception..............." +e);
			}
			
		} else {
			pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.LOGIN_PAGE);
			try {
				request.getRequestDispatcher(pageUrl).forward(request, response);
			}catch(Exception e) {
				LOGGER.info("Exception..............." +e);
			}
		}
		LOGGER.debug("Exit from Servlet...............");
	}

}
