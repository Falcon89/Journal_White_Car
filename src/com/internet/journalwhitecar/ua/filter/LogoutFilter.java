package com.internet.journalwhitecar.ua.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutFilter implements Filter {

	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {

			HttpSession session = ((HttpServletRequest) request).getSession();
			String role = (String) session.getAttribute("role");

			if (role != null & !role.equals("")) {
				chain.doFilter(request, response);
			} else {
				((HttpServletRequest) request).getRequestDispatcher("index").forward(request, response);

			}
		} catch (Exception e) {
			((HttpServletRequest) request).getRequestDispatcher("pages/errorpage.jsp").forward(request, response);
			e.printStackTrace();
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
