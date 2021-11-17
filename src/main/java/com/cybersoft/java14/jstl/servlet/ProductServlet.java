package com.cybersoft.java14.jstl.servlet;

import java.io.IOException;

import com.cybersoft.java14.jstl.model.Product;
import com.cybersoft.java14.jstl.service.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "productServlet", urlPatterns = { "/products", "/products/add", "/products/remove" })
public class ProductServlet extends HttpServlet {
	private ProductService service;

	@Override
	public void init() throws ServletException {
		super.init();
		service = new ProductService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case "/products":
			req.setAttribute("products", service.getProducts());
			req.getRequestDispatcher("/WEB-INF/view/product.jsp").forward(req, resp);
			break;

		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		String productID = req.getParameter("productID");
		switch (path) {
		case "/products/add":
			String productName = req.getParameter("productName");
			String description = req.getParameter("productDescription");
			Float productPrice = Float.valueOf(req.getParameter("productPrice"));
			Integer productStock = Integer.valueOf(req.getParameter("productStock"));
			service.addProduct(new Product(productID, productName, description, productPrice, productStock));
			resp.sendRedirect("/JspLSTL/products");
			break;
		case "/products/remove":
			service.removeProduct(productID);
			break;
		default:
			break;
		}
	}
}
