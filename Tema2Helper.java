package ro.emanuel.tema2.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import ro.emanuel.tema2.pojo.Employees;

public class Tema2Helper {

	private static Connection conn;

	public static Connection getConnection() throws SQLException {
		
			if(conn == null || conn.isClosed()) {
				Properties connectionProps = new Properties();
				connectionProps.put("user", "root");
				connectionProps.put("password", "root");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/oop2025", connectionProps);
			} 
			return conn;
	}
	
	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
