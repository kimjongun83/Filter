package com.cybersoft.java14.jstl.servlet;

import java.io.IOException;

import com.cybersoft.java14.jstl.dao.AccountDAO;
import com.cybersoft.java14.jstl.model.Account;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.JspConst;
import util.UrlConst;

@WebServlet(name = "authServlet", urlPatterns = { UrlConst.LOGINPAGE, UrlConst.LOGOUTPAGE })
public class LoginServlet extends HttpServlet {
	private AccountDAO accountDao = null;

	public LoginServlet() {
		accountDao = new AccountDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case UrlConst.LOGINPAGE:
			req.getRequestDispatcher(JspConst.LOGINPAGE).forward(req, resp);
			break;

		case UrlConst.LOGOUTPAGE:
			req.getRequestDispatcher(JspConst.LOGINPAGE).forward(req, resp);
			req.getSession().invalidate();
			break;

		default:
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Account account = accountDao.checkLogin(username, password);
		if (account != null && account.getUsername() != null) {
			req.getSession().setAttribute("name", account.getUsername());
			req.getSession().setAttribute("isAuthenticated", true);
			resp.sendRedirect(req.getContextPath() + UrlConst.HOMEPAGE);
		} else {
			resp.sendRedirect(req.getContextPath() + UrlConst.LOGINPAGE);
		}
	}
}
