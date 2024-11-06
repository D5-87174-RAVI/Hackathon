package com.raviprasad1810.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil {
	private static final String URL = "jdbc:mysql://localhost:3306/hackathon";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Rrp2014@";

	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	

}
