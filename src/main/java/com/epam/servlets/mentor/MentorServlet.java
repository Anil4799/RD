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



@WebServlet("/MentorServlet")
public class MentorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(MentorServlet.class);  
	private static final String FINALSTRING ="pageState";
	private static final String MENTORSTRING ="MENTOR INFO";
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOGGER.debug("Enter Servlet...............");	
		try {
				MentorBean mentor = addMentor(req);
				MentorService service=new MentorService();
				String status = service.addMentor(mentor);
			
				if(status.equals("success")) {
					List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems();
					req.setAttribute(ConstantsUtility.MENU_LIST, menuList);
					req.setAttribute(FINALSTRING, MENTORSTRING);
					RequestDispatcher view =req.getRequestDispatcher("/admin/mentor_added_successfully.jsp");
		            view.forward(req,res);
		
									
				}
						
				else if(status.equals("invalid"))
				{
				List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems();
				req.setAttribute(ConstantsUtility.MENU_LIST, menuList);
				req.setAttribute(FINALSTRING, MENTORSTRING);
				RequestDispatcher view =req.getRequestDispatcher("/admin/mentor_add_error.jsp");
	            view.forward(req,res);
				
				}	
					
					
			} catch (Exception e) {
				
				LOGGER.debug(e.getMessage());
				
			}
			
		LOGGER.debug("Exit from Servlet...............");
			
	}

	public MentorBean addMentor(HttpServletRequest req) throws ParseException {
		
		MentorBean mentor = new MentorBean();
		
		
		mentor.setName(req.getParameter("mentor_name"));
		mentor.setEmail(req.getParameter("mentor_email"));
		mentor.setStatus(req.getParameter("mentor_status"));
		
		String mentorstartdate=req.getParameter("mentorship_start_date");
		String[] date1=mentorstartdate.split("-");
		String mentorstartdatesql=date1[2]+"-"+date1[0]+"-"+date1[1];
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date mysqlmentorstartdate=sdf.parse(mentorstartdatesql);
		
	
		String  mentorenddate=req.getParameter("mentorship_end_date");
		String[] date2=mentorenddate.split("-");
		String mentorenddatesql=date2[2]+"-"+date2[0]+"-"+date2[1];
		
		java.util.Date mysqlmentorenddate=sdf.parse(mentorenddatesql);
		
		mentor.setMentorStartDate(mysqlmentorstartdate);
		mentor.setMentorEndDate(mysqlmentorenddate);
		mentor.setMaxNoOfMentees(Integer.parseInt(req.getParameter("max_noof_mentees")));
		mentor.setTechnologyStream(req.getParameter("mentor_technology"));
		
		return mentor;
		
		
		
	
		
	}
	
	
	

}
