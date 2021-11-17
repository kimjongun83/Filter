package com.cybersoft.java14.jstl.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.cybersoft.java14.jstl.datasource.MySQLConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.UrlConst;

@WebServlet(name= "healthServlet", urlPatterns = {
		UrlConst.HEALTH,
		UrlConst.DB_CHECK
})
public class HealthServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case UrlConst.HEALTH:
			
			break;
		
		case UrlConst.DB_CHECK:
			Connection testConnection = MySQLConnection.getConnection();
			if (testConnection != null) {
				try {
					testConnection.close();
				} catch (SQLException e) {
					System.out.println("Ket noi csdl da bi mat");
					e.printStackTrace();
				}
				resp.getWriter().append("Ket noi csdl thanh cong");
			} else {
				resp.getWriter().append("Ket noi csdl khong thanh cong");
			}
			break;
		default:
			break;
		}
	}
}
