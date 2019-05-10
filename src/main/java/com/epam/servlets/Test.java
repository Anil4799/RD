package com.epam.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.epam.dao.Mentor;
import com.epam.utils.DBManager;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Mentor> mentorList = new ArrayList<Mentor>();
		try
		{
			
			
			Connection con=DBManager.getConnection();
			Statement stmt=con.createStatement();
			String sql="SELECT * FROM mentor_info";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs!=null)
			{
			while(rs.next())
			{
				Mentor m=new Mentor();
				//m.setName(rs.getString("email_id"));
				//m.setMentor(rs.getString("name"));
				//m.setStatus(rs.getString("status"));
				mentorList.add(m);
			}
			}
						
		}
		catch(Exception e)
		{
			response.getWriter().append("Connection failed"+ e.getMessage()).append(request.getContextPath());
		}
		
		request.setAttribute("ml", mentorList);
		request.getRequestDispatcher("admin/student_info_landing_page.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
