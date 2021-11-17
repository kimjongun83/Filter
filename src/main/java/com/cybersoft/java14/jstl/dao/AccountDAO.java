package com.cybersoft.java14.jstl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cybersoft.java14.jstl.datasource.MySQLConnection;
import com.cybersoft.java14.jstl.model.Account;

public class AccountDAO {
	
	public Account checkLogin(String username, String password) {
		Connection connection = null;
		Account account = new Account();
		try {
			connection = MySQLConnection.getConnection();
			String query = "SELECT username FROM user WHERE username=? AND password=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1,username);
			statement.setString(2, password);
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("username"));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
			}
			 
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return account;
	}
}
