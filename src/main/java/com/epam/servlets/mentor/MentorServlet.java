package com.epam.servlets.mentor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.mentor.bean.MentorBean;
import com.epam.services.mentor.MentorService;

/**
 * Servlet implementation class MentorServlet
 */

@WebServlet("/MentorServlet")
public class MentorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
		
			try {
				String status = addMentor(req);
			
				if(status.equals("success")) {
					res.sendRedirect("/admin-portal/admin/displayMentor.jsp");					
				}
						
				if(status.equals("invalid"))
					res.sendRedirect("Invalid.jsp");
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
			
			
			}
		
	

	

	public String addMentor(HttpServletRequest req) throws SQLException, ParseException {
		
		MentorBean mentor = new MentorBean();
		
		mentor.setName(req.getParameter("mentor_name"));
		mentor.setEmail(req.getParameter("mentor_email"));
		mentor.setStatus(req.getParameter("mentor_status"));
		String mentor_s_date=req.getParameter("mentor_start_date");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date mysqlmentor_s_date=sdf.parse(mentor_s_date);
		
	
		String  mentor_e_date=req.getParameter("mentor_end_date");
		java.util.Date mysqlmentor_e_date=sdf.parse(mentor_e_date);
		
		mentor.setMentorStartDate(mysqlmentor_s_date);
		mentor.setMentorEndDate(mysqlmentor_e_date);
		mentor.setMaxNoOfMentees(Integer.parseInt(req.getParameter("max_noof_mentees")));
		mentor.setTechnologyStream(req.getParameter("mentor_technology"));
		
		MentorService service=new MentorService();
		return service.addMentor(mentor);
		
		
		
	
		
	}

}
