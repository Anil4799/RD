package com.epam.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.services.CalculatorService;
import com.epam.services.CalculatorServiceImpl;
import com.epam.utils.ConstantsUtility;

/**
 * Servlet implementation class UserDetailServlet
 * 
 * @author Durga_Adimulam
 */
@WebServlet("/add")
public class CalculatorServlet extends HttpServlet {

	private static final Logger LOGGER = Logger.getLogger(CalculatorServlet.class);
	private static final long serialVersionUID = 1L;

	private final CalculatorService calculatorService = new CalculatorServiceImpl();


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.debug("Entered into Servlet...............");
		String pageUrl = null;
		try {
		int firstNumber = Integer.parseInt(request.getParameter("firstNumber"));
		int secondNumber = Integer.parseInt(request.getParameter("secondNumber"));
		int result = calculatorService.add(firstNumber, secondNumber);
		request.setAttribute("result", result);
		pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.RESULT_PAGE_FOR_CALCULATOR);
		
		} catch (NumberFormatException nEx) {
			pageUrl = request.getServletContext().getInitParameter(ConstantsUtility.ERROR_PAGE);
			LOGGER.error(nEx.getMessage());
			request.setAttribute("errorMsg", nEx.getMessage());
		}
		
		request.getRequestDispatcher(pageUrl).forward(request, response);
		LOGGER.debug("Exit from Servlet...............");
	}

}
