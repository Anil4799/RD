package com.epam.servlets.mentor;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.mentor.bean.MentorBean;
import com.epam.services.mentor.MentorService;

import jdk.nashorn.internal.ir.annotations.Ignore;

class MentorAddTest {

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
	private MentorService mentorService;
	private MentorBean mentorbean;

	/** The servlet. */
	@InjectMocks
	private MentorServlet servlet;


	/**
	 * Inits the.
	 * @throws ParseException 
	 */
	@BeforeEach
	void init() throws ParseException {
		MockitoAnnotations.initMocks(this);
	}




	

	
	@Ignore

	public void testDoValidaton() throws Exception {
		when(request.getParameter(anyString())).thenReturn("reqtrazs");
		when(request.getParameter("mentor_start_date")).thenReturn("2019-05-05");
		when(request.getParameter("mentor_end_date")).thenReturn("2019-05-20");
		when(request.getParameter("max_noof_mentees")).thenReturn("5");
		when(mentorService.addMentor(mentorbean)).thenReturn("success");
		servlet.doPost(request, response);
		verify(response).sendRedirect("/admin-portal/admin/displayMentor.jsp");
	}
	
	@Ignore
	public void testDoValidatonfail() throws Exception {
		when(request.getParameter(anyString())).thenReturn(null);
		when(request.getParameter("mentor_start_date")).thenReturn("2019-05-20");
		when(request.getParameter("mentor_end_date")).thenReturn("2019-05-20");
		when(request.getParameter("max_noof_mentees")).thenReturn("5");
		when(mentorService.addMentor(mentorbean)).thenReturn("invalid");
		servlet.doPost(request, response);
		verify(response).sendRedirect("/admin-portal/admin/error.jsp");
	}
	

}
