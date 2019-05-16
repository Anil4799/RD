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


import com.epam.services.login.LoginService;
import com.epam.services.login.Menu;
import com.epam.servlets.login.LoginServlet;
import com.epam.servlets.login.LogoutServlet;
import com.epam.utils.ConstantsUtility;

import jdk.nashorn.internal.ir.annotations.Ignore;

class TestLogOutSetvlet {

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
	
	/** The servlet. */
	@InjectMocks
	private LogoutServlet servlet;
	

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
	public void testDoPostMethodLogout() throws ServletException, IOException {
		when(request.getSession()).thenReturn(session);
		doNothing().when(session).setAttribute("email",null);
		when(request.getRequestDispatcher(anyString())).thenReturn(rd);
		when(request.getServletContext()).thenReturn(context);
		when(context.getInitParameter(ConstantsUtility.LOGIN_PAGE)).thenReturn("/login.jsp");
		servlet.doPost(request, response);
		verify(rd).forward(request, response);
	}

}
