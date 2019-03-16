package It.Project.Dao;

import It.Project.Model.Shop;

import java.sql.*;

public class ShopDao extends ProductDao {
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

    public Shop getShopInfo(String info) {
        String SQL = "select name,phone_number,address from shop where name=?;";
        Shop shop = new Shop();
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, info);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                shop.setName(name);
                shop.setPhoneNumber(rs.getString("phone_number"));
                shop.setAddress(rs.getString("address"));
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(shop);
        return shop;
    }
}
