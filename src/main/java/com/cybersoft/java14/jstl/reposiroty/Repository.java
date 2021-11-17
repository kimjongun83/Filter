package com.cybersoft.java14.jstl.reposiroty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.cybersoft.java14.jstl.datasource.MySQLConnection;
import com.cybersoft.java14.jstl.model.Product;

public class Repository {
	public List<Product> getProducts() {
		List<Product> products = new LinkedList<Product>();
		Connection connection = null;
		try {
			connection = MySQLConnection.getConnection();
			String query = "SELECT id, name, description, price, stock FROM product";
			PreparedStatement stament = connection.prepareStatement(query);
			ResultSet rs = stament.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setID(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setStock(rs.getInt("stock"));
				products.add(product);
			}
		} catch (SQLException e) {
			System.out.println("Khongg the ket noi db");
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return products;
	}

	public int addProduct(Product product) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = "INSERT product(id, name, description, price, stock) VALUES(?, ?, ?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, product.getID());
			statement.setString(2, product.getName());
			statement.setString(3, product.getDescription());
			statement.setFloat(4, product.getPrice());
			statement.setInt(5, product.getStock());

			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}

		return 0;
	}

	public int removeProduct(String productID) {
		Connection connection = MySQLConnection.getConnection();
		String query = "DELETE FROM product WHERE id = ?";
		try {
			PreparedStatement stament = connection.prepareStatement(query);
			stament.setString(1, productID);
			return stament.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		return 0;
	}

}
