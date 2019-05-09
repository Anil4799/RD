package com.epam.servlets;

import static org.junit.jupiter.api.Assertions.*;
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

import com.epam.services.CalculatorService;
import com.epam.services.login.LoginService;
import com.epam.services.login.Menu;
import com.epam.servlets.login.LoginServlet;
import com.epam.utils.ConstantsUtility;

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

	@Test
	public void testDoPostMethod() throws ServletException, IOException {
		when(request.getParameter("email")).thenReturn("test_admin1@epam.com");
		when(request.getParameter("password")).thenReturn("testadmin");
		when(loginService.login("test_admin1@epam.com", "testadmin")).thenReturn(1);
		when(request.getRequestDispatcher(anyString())).thenReturn(rd);
		doNothing().when(session).setAttribute("eamil","test_admin1@epam.com");
		doNothing().when(session).setAttribute("password","testadmin");
		when(request.getServletContext()).thenReturn(context);
		doNothing().when(request).setAttribute("menuList", new ArrayList<Menu>().add(new Menu("abc","/abc")));
		when(context.getInitParameter(ConstantsUtility.HOME_PAGE)).thenReturn("/home.jsp");
		servlet.doPost(request, response);
		verify(rd).forward(request, response);

	}

}
