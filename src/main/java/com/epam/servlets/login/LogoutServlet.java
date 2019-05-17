package com.epam.servlets.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.utils.ConstantsUtility;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.setAttribute("email", null);
			session.invalidate();
			String pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.LOGIN_PAGE);
			try {
				request.getRequestDispatcher(pageUrl).forward(request, response);
			}catch(Exception e) {
				
			}
		}
	}

}
