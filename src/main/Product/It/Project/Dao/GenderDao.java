package It.Project.Dao;


import It.Project.Model.Gender;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenderDao {
    private static final String url = "jdbc:postgresql://138.68.52.248:5432/gr11";
    private static final String user = "gruppa11";
    private static final String password = "1e23qwe34";

    public Connection connect() {
        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);

            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public List<Gender> getAllGender(){
        String SQL = "Select * from gender;";
        List<Gender> genders = new ArrayList<>();

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                genders.add(new Gender(rs.getInt("id") , rs.getString("gender")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        return genders;
    }

    public Gender getGender(int id) {
        String SQL = "Select id, gender from gender where id = ?;";
        Gender gender = new Gender();

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                gender.setId(rs.getInt("id"));
                gender.setGender(rs.getString("gender"));
                System.out.println(gender);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        return gender;
    }


    public Gender addGender(Gender gender) {
        String SQL = "Insert into gender(gender) values(?);";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.setString(1, gender.getGender());
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        return gender;
    }


    public Gender updateGender(Gender gender) {
        String SQL = "Update gender set gender=? where id = ?;";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.setString(1, gender.getGender());
            stmt.setInt(2, gender.getId());
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        return gender;
    }


    public boolean deleteGender(int id){
        String SQL = "Delete from gender where id=?;";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
            return false;
        }
        return true;
    }
}
