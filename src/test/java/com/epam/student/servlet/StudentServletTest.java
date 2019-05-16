package com.epam.student.servlet;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.services.login.Menu;
import com.epam.student.beans.StudentBean;
import com.epam.student.services.StudentServiceImpl;
import com.epam.student.servlets.StudentServlet;
import com.epam.utils.ConstantsUtility;


class StudentServletTest {

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
	private StudentServiceImpl serviceimp;
	
	/** The servlet. */
	@InjectMocks
	private StudentServlet servlet;
	

	/**
	 * Inits the.
	 */
	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}


	@Test
	void testdogetmethod() throws Exception{
		when(request.getParameter("firstName")).thenReturn("vijay");
	    when( request.getParameter("lastName")).thenReturn("kumar");
		when(request.getParameter("dateOfBirth")).thenReturn("2019-05-20");	
		when(request.getParameter("email")).thenReturn("vijay456@gmail.com");
		when( request.getParameter("gender")).thenReturn("male");
		when(request.getParameter("contactNumber")).thenReturn("894173127");
		when(request.getParameter("personalLocation")).thenReturn("chna");
		when( request.getParameter("collegeName")).thenReturn("CU");
		when(request.getParameter("collegeLocation")).thenReturn("chan");
		when( request.getParameter("graduation")).thenReturn("BE");
		when( request.getParameter("graduationSpeciality")).thenReturn("CSE");
		when( request.getParameter("yearOfPassedOut")).thenReturn("2011");
		when(request.getParameter("graduationMarks")).thenReturn("200");
		when(request.getParameter("twelveth")).thenReturn("250");
		when(request.getParameter("tenth")).thenReturn("300");
		when(request.getParameter("batchId")).thenReturn("RD-Q1-2019-B1");
		when( request.getParameter("employeeType")).thenReturn("FTE");
		when( request.getParameter("coreSkill")).thenReturn("JAVA");
		when( request.getParameter("preferredStudentStream")).thenReturn("PHP");
		when( request.getParameter("assignedStream")).thenReturn(".Net");
		when( request.getParameter("dateOfJoining")).thenReturn("2019-05-12");
		when( request.getParameter("mentorName")).thenReturn("Durga");
		when( request.getParameter("assignedLocation")).thenReturn("Hyderabad");
		when( request.getParameter("relocation")).thenReturn("Yes");
		when( request.getParameter("status")).thenReturn("Active");
		StudentBean studentBean=new StudentBean("vijay", "kumar", Date.valueOf("2009-05-05"), "vijay4566@gmail.com", "male", 894173,"chna", "CU", "Chandigarh", "BE", "CSE", 2013, 100, 100, 100, "RD-Q1-2019-B1", "FTE", "Java", "Java", "Java", Date.valueOf("2019-04-30"), "Durga", "Hyderabad", "Yes", "Active");
		when(serviceimp.addStudentDetails(studentBean)).thenReturn(true);
		when(request.getRequestDispatcher(anyString())).thenReturn(rd);
		when(request.getServletContext()).thenReturn(context);				
		when(request.getRequestDispatcher("admin/student_added_successfully.jsp")).thenReturn(rd);
		servlet.doPost(request, response);
		verify(rd).forward(request, response);

//		doNothing().when(session).setAttribute("email","test_admin1@epam.com");
//		doNothing().when(session).setAttribute("password","testadmin");
//		when(session.getAttribute("email")).thenReturn("test_admin1@epam.com");
//		when(request.getServletContext()).thenReturn(context);
//		doNothing().when(request).setAttribute("menuList", new ArrayList<Menu>().add(new Menu("abc","/abc")));
//		when(context.getInitParameter(ConstantsUtility.ADMIN_HOME_PAGE)).thenReturn("/home.jsp");
//		servlet.doPost(request, response);
//		verify(rd).forward(request, response);



		
	}

}
