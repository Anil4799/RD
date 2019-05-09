package com.epam.servlets;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.services.MentorStudentInfoServiceImpl;
import com.epam.utils.ConstantsUtility;

class AllMentorServletInfo {

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
	private MentorStudentInfoServiceImpl mentorinfoservice;
	
	/** The servlet. */
	@InjectMocks
	private  MentorStudentListServlet servlet;
	

	/**
	 * Inits the.
	 */
	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
 public void testGetMethod() throws IOException, ServletException {
		
		when(request.getRequestDispatcher(anyString())).thenReturn(rd);
		when(request.getServletContext()).thenReturn(context);
		//doNothing().when(request).setAttribute("mentors", mentorList);
		when(context.getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_MENTORSTUDENT_INFO)).thenReturn("/admin/student_info_landing_page.jsp");
		servlet.doPost(request, response);
		verify(rd).forward(request, response);
	}
	@Test
	public void testException() throws ServletException, IOException
	{
		when(request.getRequestDispatcher(anyString())).thenReturn(rd);
		when(request.getServletContext()).thenReturn(context);
		when(context.getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_MENTORSTUDENT_INFO)).thenReturn("/admin/student_info_landing_page.jsp");
		when(context.getInitParameter(ConstantsUtility.ERROR_PAGE)).thenReturn("/error.jsp");
		doNothing().when(request).setAttribute("error Msg", "Exception Occured");
		servlet.doPost(request, response);
		verify(rd).forward(request, response);
	}

}
