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

import com.internet.journalwhitecar.ua.dao.UserDao;
import com.internet.journalwhitecar.ua.service.UserService;

/**
 * Servlet Filter implementation class ProductsFilter
 */
@WebFilter("/products")
public class ProductsFilter implements Filter {
	UserDao userDao = new UserDao();

	public ProductsFilter() {

	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String userDao = (String) ((HttpServletRequest) request).getSession().getAttribute("userId");
		UserService service = new UserService();
		UserDao dao = new UserDao();
//		service.checkDoesLoginAreadyUsed("email");
//		service.checkDoesLoginAreadyUsed(userDao);
		if(dao.getAllUsers().equals("admin")){
			chain.doFilter(request, response);
		}
		else{
			((HttpServletResponse) response).sendRedirect("pages/errorpage.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}

