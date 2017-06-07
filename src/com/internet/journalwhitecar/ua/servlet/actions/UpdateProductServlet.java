package com.internet.journalwhitecar.ua.servlet.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.internet.journalwhitecar.ua.model.Periodicals;
import com.internet.journalwhitecar.ua.service.ProductsService;

@WebServlet("/update-product")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductsService productsService = new ProductsService();

	public UpdateProductServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String product = request.getParameter("product-name");
		String descriptionproduct = request.getParameter("product-description");
		String imageproduct = request.getParameter("product-image");
		String priceproduc = request.getParameter("product-priceForPublishment");
		String priodosity = request.getParameter("product-periodicity");
		String productId = request.getParameter("id");
		String statusdelete = request.getParameter("product-delete");

		Periodicals periodical = productsService.getPeriodicalsById(Integer.valueOf(productId));

		if (product != null)
			periodical.setName(product);
		if (descriptionproduct != null)
			periodical.setDescription(descriptionproduct);
		if (imageproduct != null && !imageproduct.isEmpty()) {
			periodical.setImage("pages/images/car/" + imageproduct); 
		}
		if (priceproduc != null)
			periodical.setPriceForPublishment(Integer.valueOf(priceproduc));
		if (priodosity != null)
			periodical.setPeriodicity(Integer.valueOf(priodosity));
		if (priodosity != null)
			periodical.setIsDeleted(Boolean.valueOf(statusdelete));

		productsService.updatePerioical(Integer.valueOf(productId), periodical);

		System.out.println("update ok");

		request.getRequestDispatcher("pages/index.jsp").forward(request, response);
	}

}
