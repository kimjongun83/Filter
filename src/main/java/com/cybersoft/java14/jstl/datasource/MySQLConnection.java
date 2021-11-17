package com.cybersoft.java14.jstl.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	private static String url = "jdbc:mysql://localhost:3306/productdb";
	private static String username = "root";
	private static String password = "1234";
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				return DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				System.out.println("Khong the ket noi den csdl");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Khong tim thay driver mysql connector j.");
			e.printStackTrace();
		}
		return null;
	}
	
}
