package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static Connection getConnection() {

		Connection con = null;
		String URL = "jdbc:mysql://localhost:3306/Miniproject";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");				
			con = DriverManager.getConnection(URL,"janu","root");	
			return con;		

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
