package com.internet.journalwhitecar.ua.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/delete-productFilter")
public class DeleteProductFilter implements Filter {

	public DeleteProductFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession();

		String userRole = (String) ((HttpServletRequest) request).getSession().getAttribute("userRole");
		if (userRole != null) {
			if (userRole.equals("ADMIN")) {
				chain.doFilter(request, response);
			} else {
				((HttpServletResponse) response).sendRedirect("pages/errorpage.jsp");
			}
		} else {
			((HttpServletResponse) response).sendRedirect("pages/errorpage.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}