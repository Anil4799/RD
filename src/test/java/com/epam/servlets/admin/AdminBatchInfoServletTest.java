/**
 * 
 */
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

/**
 * @author Durga_Adimulam
 *
 */
class AdminBatchInfoServletTest {

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
	
	/** The service. */
	@Mock
	private AdminBatchInfoService batchInfoService;
	
	/** The servlet. */
	@InjectMocks
	private AdminBatchInfoListServlet servlet;
	

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
	@DisplayName("Test doGet() Method...!!")
	@Test
	public void testGetMethod() throws ServletException, IOException {
		when(request.getRequestDispatcher(anyString())).thenReturn(rd);
		when(request.getServletContext()).thenReturn(context);
		//doNothing().when(request).setAttribute("result", 3);
		when(context.getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_BATCH_INFO)).thenReturn("/batch/batch_info_landing_page.jsp");
		servlet.doPost(request, response);
		verify(rd).forward(request, response);

	}
	
	@Test
	public void testException() throws ServletException, IOException {
		
		
		
		when(request.getRequestDispatcher(anyString())).thenReturn(rd);
		when(request.getServletContext()).thenReturn(context);
		//doNothing().when(request).setAttribute("result", 3);
		when(context.getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_BATCH_INFO)).thenReturn("/batch/batch_info_landing_page.jsp");
		when(context.getInitParameter(ConstantsUtility.ERROR_PAGE)).thenReturn("/error.jsp");
		doNothing().when(request).setAttribute("errorMsg", "Exception occured");
		servlet.doPost(request, response);
		verify(rd).forward(request, response);
		
	}


}
