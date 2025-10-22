package ro.emanuel.tema2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.tema2.helpers.Tema2Helper;
import ro.emanuel.tema2.pojo.Employees;

public class EmployeesDAO {

	public static ArrayList<Employees> getAll()  throws SQLException{
		Connection conn = Tema2Helper.getConnection();
		
		Statement stmt = conn.createStatement();
		
		ArrayList<Employees> result = new ArrayList<Employees>();
		String query = "select * from employees";
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String position = rs.getString("position");
			String salary = rs.getString("salary");
			
			Employees b = new Employees(id, name, position, salary);
			result.add(b);
		}
		
		Tema2Helper.closeConnection();
		
		return result;
		
	}
	
	public static void createBank(Employees employees) throws SQLException {
		Connection conn = Tema2Helper.getConnection();
		
		String insertQuery = "insert into bank(name, position, salary) values (?,?,?)";
		PreparedStatement s = conn.prepareStatement(insertQuery);
		
		s.setString(1, employees.getName());
		s.setString(2,  employees.getPosition());
		s.setString(3, employees.getSalary());
		
		s.executeUpdate();
		
	}
	
	public static boolean deleteBank(int id) throws SQLException {
		Connection conn = Tema2Helper.getConnection();
		
		String deleteQuery = "delete from bank where id = " + id;
		
		Statement s = conn.createStatement();
		int affectedRows = s.executeUpdate(deleteQuery);
		
		Tema2Helper.closeConnection();
		
		return affectedRows > 0;
	}
	
	public static void update(Employees employees) throws SQLException {
		Connection conn = Tema2Helper.getConnection();
		String query = "update employees set name = ?, position = ?, salary = ? where id = ?";
		
		PreparedStatement p = conn.prepareStatement(query);
		
		p.setString(1,  employees.getName());
		p.setString(2,  employees.getPosition()); 
		p.setString(3, employees.getSalary());
		p.setInt(4, employees.getId());
		
		p.executeUpdate();
		
		Tema2Helper.closeConnection();
	}

	public static boolean deleteEmployees(int i) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
