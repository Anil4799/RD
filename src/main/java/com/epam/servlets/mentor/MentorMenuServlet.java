package com.epam.servlets.mentor;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.dao.admin.MentorBean;
import com.epam.services.admin.MentorService;

/**
 * Servlet implementation class MentorMenuServlet
 */
@WebServlet("/MentorMenuServlet")
public class MentorMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("actionview");
		String statusinfo=request.getParameter("status");
		
		
		if(statusinfo.contentEquals("inactive")&&action.equals("View")) {
					MentorBean mentor=viewMentor(request);	
					if(mentor!=null)	
						request.setAttribute("MentorbeanList",mentor);
						RequestDispatcher view =request.getRequestDispatcher("/admin/display_selected_mentor_info_inactive.jsp");
			            view.forward(request,response);
			}
	else if(statusinfo.contentEquals("active")&&action.equals("View")) {
			
			MentorBean mentor=viewMentor(request);	
			if(mentor!=null)	
				request.setAttribute("MentorbeanList",mentor);
				
				RequestDispatcher view =request.getRequestDispatcher("/admin/display_selected_mentor_info_active.jsp");
	            view.forward(request,response);
		}
		
		else if(statusinfo.contentEquals("active")&&action.equals("Edit"))
		{
			MentorBean mentor;
			mentor = viewMentor(request);	
			if(mentor!=null)	
				request.setAttribute("MentorbeanList",mentor);
				RequestDispatcher view =request.getRequestDispatcher("/admin/edit_mentor_info.jsp");
			    view.forward(request,response);	
			
		}

	}
	
	
	private MentorBean viewMentor(HttpServletRequest request) {
		MentorService service=new MentorService();
		String id=request.getParameter("id");
		return service.viewMentor(id);
		
	}

	
	
	
		
	}









