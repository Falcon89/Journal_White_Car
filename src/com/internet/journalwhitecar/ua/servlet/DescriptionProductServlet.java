package com.internet.journalwhitecar.ua.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.internet.journalwhitecar.ua.model.Periodicals;
import com.internet.journalwhitecar.ua.model.User;
import com.internet.journalwhitecar.ua.service.ProductsService;
import com.internet.journalwhitecar.ua.service.UserService;

@WebServlet("/DescriptionProduct")
public class DescriptionProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	productsServlet productsServlet = new productsServlet();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		ProductsService productsService = new ProductsService();

		if (id != null) {
			Periodicals currentPeriodical = productsService.getPeriodicalsById(Integer.valueOf(id));
			System.out.println(currentPeriodical);
			request.setAttribute("currentPeriodical", currentPeriodical);
		}

	
		request.getRequestDispatcher("/pages/DescriptionProduct.jsp").forward(request, response);
	}

	

}
