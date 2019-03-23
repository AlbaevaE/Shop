package It.Project.Dao;

import It.Project.Model.Shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopDao {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
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

    public boolean registerShop(Shop reg) {
        String SQL = "insert into shop (name, passwords, phone_number, email, address) values (?,?,?,?,?);";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.setString(1, reg.getName());
            stmt.setString(2, reg.getPassword());
            stmt.setString(3, reg.getNumber());
            stmt.setString(4, reg.getEmail());
            stmt.setString(5, reg.getAdress());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean authorizeShop(Shop reg) {
        String SQL = "select id from shop where login = ?";
        int id = -1;
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.setString(1, reg.getName());
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                id = rs.getInt("id");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        if (id == -1) {
            return false;
        }

        return checkLoginAndPassword(reg, id);
    }

    public boolean checkLoginAndPassword(Shop reg, int shopId) {
        String SQL = "select count(*) as cnt from shop where login = ? and passwords = ?";
        int count = 0;
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.setString(1, reg.getName());
            stmt.setString(2, reg.getPassword());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt("cnt");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            // Write Fail to Log
            return false;
        }
        return true;
    }
    public List<Shop> getAllShop () {
        String SQL = "Select * from shop;";
        List<Shop> shops = new ArrayList<>();
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                shops.add(new Shop (rs.getInt("id"),rs.getString("login"), rs.getString("passwords")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        return shops;
    }
}
