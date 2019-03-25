package It.Project.Dao;

import It.Project.Model.Gender;
import It.Project.Model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDao {  private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String url1 = "jdbc:postgresql:http://138.68.52.248:5432/gr11";
    private final String user = "gruppa11";
    private final String password = "1e23qwe34";

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
    public List<Order> getAllOrders(){
        String SQL = "Select * from orders;";
        List<Order> orders = new ArrayList<>();

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                orders.add(new Gender(rs.getInt("id") , rs.getString("gender")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        return genders;
    }

}
