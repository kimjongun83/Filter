package com.cybersoft.java14.jstl.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import com.mysql.cj.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.JspConst;
import util.UrlConst;

@WebServlet(name="homeServlet", urlPatterns = {
		UrlConst.HOMEPAGE,
})

public class HomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/* Doc thoi gian lan cuoi ma nguoi dung truy cap */
//		Cookie[] cookies = req.getCookies();
//		for (Cookie c : cookies) {
//			System.out.println("name: " + c.getName() + "value: " + c.getValue());
//		}
		
		/* Tao cookie luu tru thoi gian truy cap lan cuoi */
//		Cookie cookie = new Cookie("lastAccess", LocalDateTime.now().toString());
//		cookie.setMaxAge(10);
//		resp.addCookie(cookie);
		
		/* Luu thong tin nguoi dung vao session */
//		HttpSession session =  req.getSession();
//		session.setAttribute("c_user", "1111010101");
//		session.setAttribute("name", "Nguyen");
//		session.setMaxInactiveInterval(30);
		
		req.getRequestDispatcher(JspConst.HOMEPAGE).forward(req, resp);
		
	}
}
