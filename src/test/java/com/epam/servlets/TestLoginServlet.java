package com.epam.servlets;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.services.login.LoginService;
import com.epam.services.login.Menu;
import com.epam.servlets.login.LoginServlet;
import com.epam.utils.ConstantsUtility;

import jdk.nashorn.internal.ir.annotations.Ignore;

class TestLoginServlet {

	/** The request. */
	@Mock
	private HttpServletRequest request;
	
	/** The response. */
	@Mock
	private HttpServletResponse response;
	
	/** The request dispatcher. */
	@Mock
	private RequestDispatcher rd;
	
	/** The context. */
	@Mock
	private ServletContext context;
	
	/** The session. */
	@Mock
	private HttpSession session;
	
	/** The service. */
	@Mock
	private LoginService loginService;
	
	/** The servlet. */
	@InjectMocks
	private LoginServlet servlet;
	

	/**
	 * Inits the.
	 */
	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}

	
	/**
	 * Test do post method.
	 *
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@DisplayName("Test doPost() Method...!!")

	@Ignore
	public void testDoPostMethodAdmin() throws ServletException, IOException {
		when(request.getParameter("email")).thenReturn("test_admin1@epam.com");
		when(request.getParameter("password")).thenReturn("testadmin");
		when(loginService.login("test_admin1@epam.com", "testadmin")).thenReturn(1);
		when(request.getRequestDispatcher(anyString())).thenReturn(rd);
		when(request.getSession(true)).thenReturn(session);
		doNothing().when(session).setAttribute("email","test_admin1@epam.com");
		doNothing().when(session).setAttribute("password","testadmin");
		when(session.getAttribute("email")).thenReturn("test_admin1@epam.com");
		when(request.getServletContext()).thenReturn(context);
		doNothing().when(request).setAttribute("menuList", new ArrayList<Menu>().add(new Menu("abc","/abc")));
		when(context.getInitParameter(ConstantsUtility.ADMIN_HOME_PAGE)).thenReturn("/home.jsp");
		servlet.doPost(request, response);
		verify(rd).forward(request, response);

	}
	@Ignore
	public void testDoPostMethodMentor() throws ServletException, IOException {
		when(request.getParameter("email")).thenReturn("test_mentor1@epam.com");
		when(request.getParameter("password")).thenReturn("testmentor");
		when(loginService.login("test_admin1@epam.com", "testadmin")).thenReturn(2);
		when(request.getRequestDispatcher(anyString())).thenReturn(rd);
		doNothing().when(session).setAttribute("eamil","test_mentor1@epam.com");
		doNothing().when(session).setAttribute("password","testmentor");
		when(request.getServletContext()).thenReturn(context);
		doNothing().when(request).setAttribute("menuList", new ArrayList<Menu>().add(new Menu("abc","/abc")));
		when(context.getInitParameter(ConstantsUtility.ADMIN_HOME_PAGE)).thenReturn("/home.jsp");
		servlet.doPost(request, response);
		verify(rd).forward(request, response);

	}
	@Ignore
	public void testDoPostMethodAdminError() throws ServletException, IOException {
		when(request.getParameter("email")).thenReturn("test_admin2@epam.com");
		when(request.getParameter("password")).thenReturn("testadmin123");
		when(loginService.login("test_admin1@epam.com", "testadmin")).thenReturn(0);
		when(request.getRequestDispatcher(anyString())).thenReturn(rd);
		doNothing().when(session).setAttribute("eamil","test_admin2@epam.com");
		doNothing().when(session).setAttribute("password","testadmin123");
		when(request.getServletContext()).thenReturn(context);
		doNothing().when(request).setAttribute("menuList", new ArrayList<Menu>().add(new Menu("abc","/abc")));
		when(context.getInitParameter(ConstantsUtility.LOGIN_PAGE)).thenReturn("/login.jsp");
		servlet.doPost(request, response);
		verify(rd).forward(request, response);

	}
	@Ignore
	public void testDoPostMethodMentorError() throws ServletException, IOException {
		when(request.getParameter("email")).thenReturn("test_mentor2@epam.com");
		when(request.getParameter("password")).thenReturn("testmentor123");
		when(loginService.login("test_admin1@epam.com", "testadmin")).thenReturn(0);
		when(request.getRequestDispatcher(anyString())).thenReturn(rd);
		doNothing().when(session).setAttribute("eamil","test_mentor2@epam.com");
		doNothing().when(session).setAttribute("password","testmentor123");
		when(request.getServletContext()).thenReturn(context);
		doNothing().when(request).setAttribute("menuList", new ArrayList<Menu>().add(new Menu("abc","/abc")));
		when(context.getInitParameter(ConstantsUtility.LOGIN_PAGE)).thenReturn("/login.jsp");
		servlet.doPost(request, response);
		verify(rd).forward(request, response);

	}
	@Ignore
	public void testDoPostMethodUserEmptyUserName() throws ServletException, IOException {
		when(request.getParameter("email")).thenReturn("");
		when(request.getParameter("password")).thenReturn("testmentor123");
		when(loginService.login("test_admin1@epam.com", "testadmin")).thenReturn(0);
		when(request.getRequestDispatcher(anyString())).thenReturn(rd);
		doNothing().when(session).setAttribute("eamil","");
		doNothing().when(session).setAttribute("password","testmentor123");
		when(request.getServletContext()).thenReturn(context);
		doNothing().when(request).setAttribute("menuList", new ArrayList<Menu>().add(new Menu("abc","/abc")));
		when(context.getInitParameter(ConstantsUtility.LOGIN_PAGE)).thenReturn("/login.jsp");
		servlet.doPost(request, response);
		verify(rd).forward(request, response);

	}
	@Ignore
	public void testDoPostMethodUserEmptyPassword() throws ServletException, IOException {
		when(request.getParameter("email")).thenReturn("test_mentor2@epam.com");
		when(request.getParameter("password")).thenReturn("");
		when(loginService.login("test_admin1@epam.com", "testadmin")).thenReturn(0);
		when(request.getRequestDispatcher(anyString())).thenReturn(rd);
		doNothing().when(session).setAttribute("eamil","test_mentor2@epam.com");
		doNothing().when(session).setAttribute("password","");
		when(request.getServletContext()).thenReturn(context);
		doNothing().when(request).setAttribute("menuList", new ArrayList<Menu>().add(new Menu("abc","/abc")));
		when(context.getInitParameter(ConstantsUtility.LOGIN_PAGE)).thenReturn("/login.jsp");
		servlet.doPost(request, response);
		verify(rd).forward(request, response);

	}

}
