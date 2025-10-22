package ro.emanuel.tema2.dao;

import java.sql.*;
import java.util.ArrayList;
import ro.emanuel.tema2.helpers.Tema2Helper;
import ro.emanuel.tema2.pojo.Football;

public class FootballDAO {

    public static ArrayList<Football> getAll() throws SQLException {
        Connection conn = Tema2Helper.getConnection();
        Statement stmt = conn.createStatement();
        ArrayList<Football> result = new ArrayList<>();

        String query = "SELECT * FROM football";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String team = rs.getString("team");
            String number = rs.getString("number");
            String age = rs.getString("age");

            Football f = new Football(id, name, team, number, age);
            result.add(f);
        }

        Tema2Helper.closeConnection();
        return result;
    }

    public static void createFootball(Football football) throws SQLException {
        Connection conn = Tema2Helper.getConnection();

        String insertQuery = "INSERT INTO football (name, team, number, age) VALUES (?, ?, ?, ?)";
        PreparedStatement s = conn.prepareStatement(insertQuery);

        s.setString(1, football.getName());
        s.setString(2, football.getTeam());
        s.setString(3, football.getNumber());
        s.setString(4, football.getAge());

        s.executeUpdate();
        Tema2Helper.closeConnection();
    }

    public static boolean deleteFootball(int id) throws SQLException {
        Connection conn = Tema2Helper.getConnection();

        String deleteQuery = "DELETE FROM football WHERE id = ?";
        PreparedStatement s = conn.prepareStatement(deleteQuery);
        s.setInt(1, id);

        int affectedRows = s.executeUpdate();
        Tema2Helper.closeConnection();
        return affectedRows > 0;
    }
 
    public static void updateFootball(Football football) throws SQLException {
        Connection conn = Tema2Helper.getConnection();
        String query = "UPDATE football SET name = ?, team = ?, number = ?, age = ? WHERE id = ?";

        PreparedStatement p = conn.prepareStatement(query);
        p.setString(1, football.getName());
        p.setString(2, football.getTeam());
        p.setString(3, football.getNumber());
        p.setString(4, football.getAge());
        p.setInt(5, football.getId());

        p.executeUpdate();
        Tema2Helper.closeConnection();
    }
}
