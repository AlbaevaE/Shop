package It.Project.Dao;

import It.Project.Model.*;

import java.sql.*;

public class ItemDao {
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

    //    int id;
//    String name;
//    Type type;
//    Brand brand;
//    Color color;
//    Size size;
//    Season season;
//    int price;
//    Shop shop;
//    Gender gender;
    public Item getItem(int id) {
        String SQL = "Select name, type_product_id, brand_id, color_id, size_id, season, price, shop_id, gender_id, rating_id from item where id = ?;";
        Item item = new Item();
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setName(rs.getString("type_product_id"));
                item.setName(rs.getString("brand_id"));
                item.setName(rs.getString("color_id"));
                item.setName(rs.getString("size_id"));
                item.setName(rs.getString("season"));
                item.setName(rs.getString("price"));
                item.setName(rs.getString("shop_id"));
                item.setName(rs.getString("gender_id"));
                item.setName(rs.getString("rating_id"));
                System.out.println(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        return item;
    }

}

