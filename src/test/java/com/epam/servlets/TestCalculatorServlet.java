/**
 * 
 */
package com.epam.servlets;

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

//import com.epam.services.CalculatorService;
import com.epam.utils.ConstantsUtility;

/**
 * @author Durga_Adimulam
 *
 */
class TestCalculatorServlet {

//	/** The request. */
//	@Mock
//	private HttpServletRequest request;
//	
//	/** The response. */
//	@Mock
//	private HttpServletResponse response;
//	
//	/** The request dispatcher. */
//	@Mock
//	private RequestDispatcher rd;
//	
//	/** The context. */
//	@Mock
//	private ServletContext context;
//	
//	/** The service. */
//	@Mock
//	private CalculatorService calculatorService;
//	
//	/** The servlet. */
//	@InjectMocks
//	private CalculatorServlet servlet;
//	
//
//	/**
//	 * Inits the.
//	 */
//	@BeforeEach
//	void init() {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	
//	/**
//	 * Test do post method.
//	 *
//	 * @throws ServletException the servlet exception
//	 * @throws IOException Signals that an I/O exception has occurred.
//	 */
//	@DisplayName("Test doPost() Method...!!")
//	@Test
//	public void testDoPostMethod() throws ServletException, IOException {
//		when(request.getParameter("firstNumber")).thenReturn("1");
//		when(request.getParameter("secondNumber")).thenReturn("2");
//		when(calculatorService.add(1, 2)).thenReturn(3);
//		when(request.getRequestDispatcher(anyString())).thenReturn(rd);
//		when(request.getServletContext()).thenReturn(context);
//		doNothing().when(request).setAttribute("result", 3);
//		when(context.getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_CALCULATOR)).thenReturn("/resultPageForCalculator.jsp");
//		servlet.doPost(request, response);
//		verify(rd).forward(request, response);
//
//	}
//	
//	@Test
//	public void testNumberFormatException() throws ServletException, IOException {
//		
//		when(request.getParameter("firstNumber")).thenReturn("1");
//		when(request.getParameter("secondNumber")).thenReturn("aa");
//		
//		when(calculatorService.add(1, 2)).thenReturn(3);
//		when(request.getRequestDispatcher(anyString())).thenReturn(rd);
//		when(request.getServletContext()).thenReturn(context);
//		doNothing().when(request).setAttribute("result", 3);
//		when(context.getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_CALCULATOR)).thenReturn("/resultPageForCalculator.jsp");
//		when(context.getInitParameter(ConstantsUtility.ERROR_PAGE)).thenReturn("/error.jsp");
//		doNothing().when(request).setAttribute("errorMsg", "Exception occured");
//		servlet.doPost(request, response);
//		
//		
//	}


}
