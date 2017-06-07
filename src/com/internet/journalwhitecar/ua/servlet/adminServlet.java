package com.internet.journalwhitecar.ua.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.internet.journalwhitecar.ua.model.Periodicals;
import com.internet.journalwhitecar.ua.model.User;
import com.internet.journalwhitecar.ua.service.ProductsService;
import com.internet.journalwhitecar.ua.service.UserService;

@WebServlet("/admin")
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserService();
ProductsService productsService = new ProductsService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*
		 * ProductsService productsService= new ProductsService();
		 * List<Periodicals> allProducts=productsService.getAllPeriodicals();
		 * request.setAttribute("allProducts", allProducts);
		 */
/*		String id = request.getParameter("id");
		ProductsService productsService = new ProductsService();

		if (id != null) {
			Periodicals currentPeriodical = productsService.getPeriodicalsById(Integer.valueOf(id));
			System.out.println(currentPeriodical);
			request.setAttribute("currentPeriodical", currentPeriodical);
		}*/
		
		List<User> listOfUsers = userService.getAllUsers();
		List<Periodicals> listperiodicals = productsService.getAllPeriodicals();
		List<Periodicals> alldeleteProduct = productsService.getAllPeriodicalsWithDeleted();
	/*	List<Periodicals> dellProduct = productsService.getAllPeriodicalsDeleted();*/
		request.setAttribute("listOfUsers", listOfUsers);
		request.setAttribute("listperiodicals", listperiodicals);
		request.setAttribute("alldeleteProduct", alldeleteProduct);
	/*	request.setAttribute("dellProduct", dellProduct);*/
		
		request.getRequestDispatcher("/pages/admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
