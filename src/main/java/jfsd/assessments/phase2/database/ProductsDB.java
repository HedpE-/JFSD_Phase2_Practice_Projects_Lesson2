package jfsd.assessments.phase2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jfsd.assessments.phase2.entities.Product;

public final class ProductsDB {
	private static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// mysql on windows : 3306
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd?autoReconnect=true&useSSL=false",
					"root", "password");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static Product getProduct(int pid) {
		Connection con = getConnection();

		String sql = "SELECT * FROM products WHERE pid = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, pid);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return new Product(rs.getInt("pid"), rs.getString("pname"), rs.getFloat("avgweight"), rs.getFloat("price"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
}
