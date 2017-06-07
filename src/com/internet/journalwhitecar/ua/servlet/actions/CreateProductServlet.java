package com.internet.journalwhitecar.ua.servlet.actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.internet.journalwhitecar.ua.model.Periodicals;
import com.internet.journalwhitecar.ua.service.ProductsService;

@WebServlet("/create-product")
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductsService productsService = new ProductsService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String product = request.getParameter("product-name");
		String descriptionproduct = request.getParameter("product-description");
		String imageproduct = request.getParameter("product-image");
		String priodosity = request.getParameter("product-periodicity");
		String priceproduc = request.getParameter("product-priceForPublishment");


			Periodicals periodicals = new Periodicals();
			periodicals.setName(product);
			periodicals.setDescription(descriptionproduct);
			if (!imageproduct.equals( "")) {
				periodicals.setImage("pages/images/car/" + imageproduct);
			}
			else {
				periodicals.setImage("pages/images/car/not-image.jpg");
			}
			periodicals.setPeriodicity(Integer.valueOf(priodosity));
			periodicals.setPriceForPublishment(Integer.valueOf(priceproduc));

			int periodicalsId = productsService.addNewPeriodical(periodicals);
			System.out.println(periodicals);
			System.out.println("create product ok");

			request.getRequestDispatcher("pages/index.jsp").forward(request, response);
		
	}
}
