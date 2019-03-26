package It.Project.Dao;

import It.Project.Model.Gender;
import It.Project.Model.Order;
import It.Project.Model.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDao {

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
    public List<Order> getAllOrders(){
        String SQL = "Select * from orders;";
        List<Order> orders = new ArrayList<>();

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                orders.add(new Order(rs.getInt("id") , rs.getDouble("discount"), rs.getInt("client_id")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        return orders;
    }
    public Order getOrder(int id) {
        String SQL = "Select id , discount , client_id from orders where id = ?;";

       Order order= new Order();
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                order.setId(rs.getInt("id"));
                order.setDiscount(rs.getDouble("discount"));
                order.setClientId(rs.getInt("client_id"));
                System.out.println(order);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        return order;
    }
    public Order addOrder(Order order){
        String SQL = "Insert into orders(discount, client_id) values(?,?);";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.setDouble(1, order.getDiscount());
            stmt.setInt(2, order.getClientId());
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        return order;
    }
    public Order updateOrder(Order order){
        String SQL = "Update orders set discount=?, client_id=?  where id = ?;";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.setDouble(1,order.getDiscount());
            stmt.setInt(2, order.getClientId());
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        return order;
    }
    public boolean deleteOrders(int id){
        String SQL = "Delete from orders where id=?;";
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
