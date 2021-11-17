package com.cybersoft.java14.jstl.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.UrlConst;

@WebFilter(urlPatterns = { UrlConst.ROOT })
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse respone, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) respone;
		boolean isAuthed = req.getSession().getAttribute("isAuthenticated") != null ? true : false;
		if (isAuthed && UrlConst.LOGINPAGE.equals(req.getServletPath())) {
			// neu da dang nhap nhung o trang dang nhap -> den trang home
			resp.sendRedirect(req.getContextPath() + UrlConst.HOMEPAGE);
		} else if (isAuthed) {
			// neu da dang nhap
			chain.doFilter(req, resp);
		} else if (UrlConst.LOGINPAGE.equals(req.getServletPath())) {
			// neu chua dang nhap va truy cap trang dang nhap thi cho qua
			chain.doFilter(req, resp);
			// chua dang nhap va vao trang khac thi bat vao trang dang nhap
		} else {
			resp.sendRedirect(req.getContextPath() + UrlConst.LOGINPAGE);
		}

	}

}
