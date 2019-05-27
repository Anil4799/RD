package com.epam.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;



/**
 * Servlet Filter implementation class LoginFilter
 */

@WebFilter(
        urlPatterns = "/*",
        filterName = "LoginRequiredFilter",
        description = "Filter all URLs"       
)
public class LoginRequiredFilter implements Filter {

	private static final Logger LOGGER = Logger.getLogger(LoginRequiredFilter.class);

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		LOGGER.info("Entered in to LoginRequiredFilter");
		try
		{
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			if (httpRequest.getSession().getAttribute("email") != null) {
	
				chain.doFilter(httpRequest, response);
	
			} else {
				httpRequest.getRequestDispatcher("LoginServlet").forward(httpRequest,response);
	
			}
		}
		catch(Exception e)
		{
			LOGGER.info(e.getMessage());
		}
		LOGGER.info("Exited in to LoginRequiredFilter");
	}
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// init configs
	}

}
