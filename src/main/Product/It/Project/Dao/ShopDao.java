package It.Project.Dao;

import It.Project.Model.Shop;

import java.sql.*;

public class ShopDao extends ProductDao {
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

    public String getShopInfo(String info) {
        String SQL = "Select id from shop";
        String v = "";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, info);
            stmt.executeUpdate();
            ResultSet rs = stmt.executeQuery(SQL);
            {
                rs.next();
            }

        } catch (SQLException ex) {
            ex.getMessage();
        }
        return info;
    }

    public String getAllShop(String info) {
        String SQL = "Select * from shop";
        String v = "";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, info);
            stmt.executeUpdate();
            ResultSet rs = stmt.executeQuery(SQL);
            {
                rs.next();
            }

        } catch (SQLException ex) {
            ex.getMessage();
        }
        return info;
    }

    public String addShop(Shop shop) {
        String SQL = "insert into shop (id,name,contact) values (?,?,?)";
        String s = "";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, shop.id);
            stmt.setString(2, shop.name);
            stmt.setString(3, String.valueOf(shop.contact));
            stmt.executeQuery();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return s;
    }

    public String updateShop(Shop shop) {
        String SQL = "Update shop set name = ? where id = ?";
        String s = "";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, shop.id);
            stmt.setString(2, shop.name);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return s;

    }

    public String deleteShop(Shop shop){
        String SQL = "Delete from shop where id = ?";
        String s = "";
        try(Connection conn = connect();
        PreparedStatement stmt = conn.prepareStatement(SQL)){
            stmt.setInt(1,shop.id);
            stmt.executeUpdate();
        }
        catch (SQLException ex){
            ex.getMessage();
        }
        return s;
    }
}
