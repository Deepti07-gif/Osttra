package com.osttra.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {

	public static Connection getConnection() {
		Connection dbConnection = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "admin");
			return dbConnection;
		} catch (Exception e) {
			System.out.println("Problem in getConnection()!!!");
			e.printStackTrace();
		}

		return dbConnection;
	}

}
