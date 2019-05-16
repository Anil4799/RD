package com.epam.servlets.admin;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.services.admin.AdminBatchInfoService;
import com.epam.servlets.admin.AdminBatchInfoListServlet;
//import com.epam.services.CalculatorService;
import com.epam.utils.ConstantsUtility;

import jdk.nashorn.internal.ir.annotations.Ignore;

class AdminBatchInfoServletTest {


	@Mock
	private HttpServletRequest request;
	

	@Mock
	private HttpServletResponse response;
	

	@Mock
	private RequestDispatcher rd;
	

	@Mock
	private ServletContext context;
	

	@Mock
	private AdminBatchInfoService batchInfoService;
	
	@InjectMocks
	private AdminBatchInfoListServlet servlet;

	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}

	@DisplayName("Test doGet() Method...!!")
	@Ignore
	public void testGetMethod() throws ServletException, IOException {
		when(request.getRequestDispatcher(anyString())).thenReturn(rd);
		when(request.getServletContext()).thenReturn(context);
		
		when(context.getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_BATCH_INFO)).thenReturn("/batch/batch_info_landing_page.jsp");
		servlet.doGet(request, response);
		verify(rd).forward(request, response);

	}
	
	@Ignore
	public void testException() throws ServletException, IOException {
		
		when(request.getRequestDispatcher(anyString())).thenReturn(rd);
		when(request.getServletContext()).thenReturn(context);
		when(context.getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_BATCH_INFO)).thenReturn("/batch/batch_info_landing_page.jsp");
		when(context.getInitParameter(ConstantsUtility.ERROR_PAGE)).thenReturn("/error.jsp");
		doNothing().when(request).setAttribute("errorMsg", "Exception occured");
		servlet.doGet(request, response);
		verify(rd).forward(request, response);
		
	}


}
