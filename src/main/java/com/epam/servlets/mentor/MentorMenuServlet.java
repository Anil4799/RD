package com.epam.servlets.mentor;

import java.io.IOException;
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
 * Servlet implementation class MentorMenuServlet
 */
@WebServlet("/MentorMenuServlet")
public class MentorMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(MentorMenuServlet.class);  
	private static final String FINALSTRING ="pageState";
	private static final String MENTORSTRING ="MENTOR INFO";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorMenuServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("actionview");
		String statusinfo=request.getParameter("status");
		
		
		if(statusinfo.contentEquals("inactive")&&action.equals("View")) {
					MentorBean mentor=viewMentor(request);	
					try {
					
						request.setAttribute("MentorbeanList1",mentor);
						List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems();
						request.setAttribute(ConstantsUtility.MENU_LIST, menuList);
						request.setAttribute(FINALSTRING, MENTORSTRING);
						RequestDispatcher view =request.getRequestDispatcher("/admin/display_selected_mentor_info_inactive.jsp");
			            view.forward(request,response);
					}
					catch(Exception e)
					{
						LOGGER.debug(e.getMessage());
					}
			}
	else if(statusinfo.contentEquals("active")&&action.equals("View")) {
			
			MentorBean mentor=viewMentor(request);
			try {
				List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems();
				request.setAttribute(ConstantsUtility.MENU_LIST, menuList);
				request.setAttribute(FINALSTRING, MENTORSTRING);
				request.setAttribute("MentorbeanList2",mentor);
				
				RequestDispatcher view =request.getRequestDispatcher("/admin/display_selected_mentor_info_active.jsp");
	            view.forward(request,response);
			}
	            catch(Exception e)
				{
					LOGGER.debug(e.getMessage());
				}
		}
		
		else if(statusinfo.contentEquals("active")&&action.equals("Edit"))
		{
			MentorBean mentor;
			mentor = viewMentor(request);	
			try {
				List<Menu> menuList=MenuItemsSingleton.getInstance().getMenuItems();
				request.setAttribute(ConstantsUtility.MENU_LIST, menuList);
				request.setAttribute(FINALSTRING, MENTORSTRING);
				request.setAttribute("MentorbeanList3",mentor);
				RequestDispatcher view =request.getRequestDispatcher("/admin/edit_mentor_info.jsp");
			    view.forward(request,response);	
			}
			    catch(Exception e)
				{
					LOGGER.debug(e.getMessage());
				}
			
		}

	}
	
	
	private MentorBean viewMentor(HttpServletRequest request) {
		MentorService service=new MentorService();
		String id=request.getParameter("id");
		return service.viewMentor(id);
		
	}

	
	
	
		
	}









