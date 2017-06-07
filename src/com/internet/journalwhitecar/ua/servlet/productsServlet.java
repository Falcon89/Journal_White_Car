package com.internet.journalwhitecar.ua.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.internet.journalwhitecar.ua.model.Periodicals;
import com.internet.journalwhitecar.ua.service.ProductsService;

@WebServlet("/products")
public class productsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductsService productsService = new ProductsService();
		List<Periodicals> allProducts = productsService.getAllPeriodicals();
		request.setAttribute("allProducts", allProducts);
		/*
		 * List<Periodicals> alldeleteProduct =
		 * productsService.getAllPeriodicalsDeleted();
		 * request.setAttribute("alldeleteProduct", alldeleteProduct);
		 */
		request.getRequestDispatcher("/pages/products.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
