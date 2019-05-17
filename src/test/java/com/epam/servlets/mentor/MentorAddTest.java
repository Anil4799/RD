package com.epam.servlets.mentor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.mentor.bean.MentorBean;
import com.epam.services.mentor.MentorService;
import com.epam.utils.ConstantsUtility;

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

	@SuppressWarnings("deprecation")

	

	
	@Test
	public void testDoValidaton() throws Exception {
		when(request.getParameter(anyString())).thenReturn("requestara");
		when(request.getParameter("mentor_start_date")).thenReturn("2019-05-05");
		when(request.getParameter("mentor_end_date")).thenReturn("2019-05-20");
		when(request.getParameter("max_noof_mentees")).thenReturn("5");
		when(mentorService.addMentor(mentorbean)).thenReturn("success");
		servlet.doPost(request, response);
		verify(response).sendRedirect("/admin-portal/admin/displayMentor.jsp");
	}
	
	@Test
	public void testDoValidatonfail() throws Exception {
		when(request.getParameter(anyString())).thenReturn(null);
		when(request.getParameter("mentor_start_date")).thenReturn("2019-05-20");
		when(request.getParameter("mentor_end_date")).thenReturn("2019-05-20");
		when(request.getParameter("max_noof_mentees")).thenReturn("5");
		when(mentorService.addMentor(mentorbean)).thenReturn("invalid");
		servlet.doPost(request, response);
		verify(response).sendRedirect("/admin-portal/admin/error.jsp");
	}
	
	
	
	/*@Test
	public void testgettMethod() throws IOException, ServletException, SQLException, ParseException {
		mentorBean = new MentorBean();
		doNothing().when(mentorBean).setName("");
		doNothing().when(mentorBean).setEmail("");
		doNothing().when(mentorBean).setStatus("");

		String mentor_s_date = request.getParameter("10-01-2019");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date mysqlmentor_s_date = sdf.parse(mentor_s_date);

		String mentor_e_date = request.getParameter("20-03-2019");
		Date mysqlmentor_e_date = sdf.parse(mentor_e_date);

		doNothing().when(mentorBean).setMentorStartDate(mysqlmentor_s_date);
		doNothing().when(mentorBean).setMentorEndDate(mysqlmentor_e_date);
		doNothing().when(mentorBean).setMaxNoOfMentees(Integer.parseInt(request.getParameter("max_noof_mentees")));
		doNothing().when(mentorBean).setTechnologyStream(request.getParameter("mentor_technology"));

		when(servlet.addMentor(request)).thenReturn("success");
		when(request.getRequestDispatcher(anyString())).thenReturn(rd);
		when(request.getServletContext()).thenReturn(context);
		when(context.getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_ADDMENTOR))
				.thenReturn("/admin/mentor_info_landing_page.jsp");
		new MentorServlet().doPost(request, response);
		verify(rd).forward(request, response);
	}*/

}
