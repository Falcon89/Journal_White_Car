package com.internet.journalwhitecar.ua.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.internet.journalwhitecar.ua.service.ProductsService;

@WebServlet("/delete-product")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ProductsService productsService = new ProductsService();
    public DeleteProductServlet() {
        super();

    }




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id=request.getParameter("productId");
		productsService.deletePeriodical(Integer.valueOf(id));
		request.getRequestDispatcher("/pages/products.jsp").forward(request, response);
	}

}
