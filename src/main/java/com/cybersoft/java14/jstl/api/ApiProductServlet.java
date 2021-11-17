package com.cybersoft.java14.jstl.api;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import util.UrlConst;

@WebServlet(name="apiProductServlet", urlPatterns = {
		UrlConst.PRODUCT_PAGE,
		UrlConst.ADD_PRODUCT,
		UrlConst.REMOVE_PRODUCT,
})
public class ApiProductServlet extends HttpServlet {

}
