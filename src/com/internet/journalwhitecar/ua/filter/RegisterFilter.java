package com.internet.journalwhitecar.ua.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class RegisterFilter implements Filter {

   
	public void destroy() {
	
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		((HttpServletRequest) request).getRequestDispatcher("pages/errorpage.jsp").forward(request, response);
		
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
