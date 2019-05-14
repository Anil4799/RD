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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
			PrintWriter out = res.getWriter();
			try {
				String status = addMentor(req);
				//System.out.println(status);
				
				if(status.equals("success")) {
					res.sendRedirect("/admin-portal/admin/displayMentor.jsp");					
				}
				
						
				if(status.equals("invalid"))
					res.sendRedirect("Invalid.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			}
		
	

	

	public String addMentor(HttpServletRequest req) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		MentorBean mentor = new MentorBean();
		
		mentor.setName(req.getParameter("mentor_name"));
		mentor.setEmail(req.getParameter("mentor_email"));
		mentor.setStatus(req.getParameter("mentor_status"));
		String mentor_s_date=req.getParameter("mentor_start_date");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date mysqlmentor_s_date=sdf.parse(mentor_s_date);
		//Date add_s_date=Date.valueOf(mentor_s_date);
		System.out.println(mysqlmentor_s_date);
		String  mentor_e_date=req.getParameter("mentor_end_date");
		java.util.Date mysqlmentor_e_date=sdf.parse(mentor_e_date);
		//Date add_e_date=Date.valueOf( mentor_e_date);
		mentor.setMentorStartDate(mysqlmentor_s_date);
		mentor.setMentorEndDate(mysqlmentor_e_date);
		mentor.setMaxNoOfMentees(Integer.parseInt(req.getParameter("max_noof_mentees")));
		mentor.setTechnologyStream(req.getParameter("mentor_technology"));
		
		MentorService service=new MentorService();
		return service.addMentor(mentor);
		
		
		
	
		
	}

}
