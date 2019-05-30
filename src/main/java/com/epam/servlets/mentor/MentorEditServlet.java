package com.epam.servlets.mentor;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.dao.admin.MentorBean;
import com.epam.services.admin.MentorService;
import com.epam.services.login.Menu;
import com.epam.services.login.MenuItemsSingleton;
import com.epam.utils.ConstantsUtility;

/**
 * Servlet implementation class MentorEditServlet
 */
@WebServlet("/MentorEditServlet")
public class MentorEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(MentorEditServlet.class);  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorEditServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
				MentorBean mentor = updateMentor(request);
				MentorService service=new MentorService();
				String status = service.updateMentor(mentor);
				List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems();
				request.setAttribute(ConstantsUtility.MENU_LIST, menuList);
				request.setAttribute("pageState", "MENTOR INFO");

			
				if(status.equals("success")) {
					RequestDispatcher view =request.getRequestDispatcher("/admin/mentor_updated_successfully.jsp");
					view.forward(request,response);
				}
						
				if(status.equals("invalid"))
					response.sendRedirect("error.jsp");
			} catch (Exception e) {
				
				
				LOGGER.debug(e.getMessage());
			}
			

			
		
		
	}

	private MentorBean updateMentor(HttpServletRequest request) throws ParseException {
		
			
		MentorBean mentor = new MentorBean();
		
		
		
		mentor.setName(request.getParameter("mentor_name"));
		mentor.setEmail(request.getParameter("mentor_email"));
		mentor.setStatus(request.getParameter("mentor_status"));
		
		String mentorstartdate=request.getParameter("mentorship_start_date");
		String[] date1=mentorstartdate.split("-");
		String mentorstartdatesql=date1[2]+"-"+date1[0]+"-"+date1[1];
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date mysqlmentorstartdate=sdf.parse(mentorstartdatesql);
		
	
		String  mentorenddate=request.getParameter("mentorship_end_date");
		String[] date2=mentorenddate.split("-");
		String mentorenddatesql=date2[2]+"-"+date2[0]+"-"+date2[1];
	
		java.util.Date mysqlmentorenddate=sdf.parse(mentorenddatesql);
		
		mentor.setMentorStartDate(mysqlmentorstartdate);
		mentor.setMentorEndDate(mysqlmentorenddate);
		mentor.setMaxNoOfMentees(Integer.parseInt(request.getParameter("max_noof_mentees")));
		mentor.setTechnologyStream(request.getParameter("mentor_technology"));
		
		return mentor;
		
		
	}

	
}
