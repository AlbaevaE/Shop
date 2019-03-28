package It.Project.Dao;


import It.Project.Model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public Item getItem(int id) {
        String SQL = "Select id,name, type_product_id, brand_id, color_id, size_id, " +
                "season, price, shop_id, gender_id, rating_id from item where id=?;";
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
                item.setType(rs.getInt("type_product_id"));
                item.setBrand(rs.getInt("brand_id"));
                item.setColor(rs.getInt("color_id"));
                item.setSize(rs.getInt("size_id"));
                item.setSeason(rs.getInt("season"));
                item.setPrice(rs.getInt("price"));
                item.setShop(rs.getInt("shop_id"));
                item.setGender(rs.getInt("gender_id"));
                item.setRating(rs.getInt("rating_id"));
                System.out.println(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        return item;
    }


    public List<Item> getAllItem() {
        String SQL = "Select * from item;";
        List<Item> items = new ArrayList<>();

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                items.add(new Item(rs.getInt("id"), rs.getString("name")
                        , rs.getInt("type_product_id"), rs.getInt("brand_id")
                        , rs.getInt("color_id"), rs.getInt("size_id")
                        , rs.getInt("season"), rs.getInt("price")
                        , rs.getInt("shop_id"), rs.getInt("gender_id")
                        , rs.getInt("rating_id")));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        return items;
    }

    public Item addItem(Item item) {
        String SQL = "Insert into item(name,type_product_id,brand_id,color_id,size_id,season, " +
                "price,shop_id,gender_id,rating_id) values(?,?,?,?,?,?,?,?,?,?);";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.setString(1, item.getName());
            stmt.setInt(2, item.getType());
            stmt.setInt(3, item.getBrand());
            stmt.setInt(4, item.getColor());
            stmt.setInt(5, item.getSize());
            stmt.setInt(6, item.getSeason());
            stmt.setInt(7, item.getPrice());
            stmt.setInt(8, item.getShop());
            stmt.setInt(9, item.getGender());
            stmt.setInt(10, item.getRating());
            stmt.execute();
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        return item;
    }

    public Item updateItem(Item item) {
        String SQL = "Update item set name=?,type_product_id=?,brand_id=?,color_id=?," +
                "size_id=?,season=?,price=?,shop_id=?,gender_id=?,rating_id=? where id=?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.setString(2, item.getName());
            stmt.setInt(3, item.getType());
            stmt.setInt(4, item.getBrand());
            stmt.setInt(5, item.getColor());
            stmt.setInt(6, item.getSize());
            stmt.setInt(7, item.getSeason());
            stmt.setInt(8, item.getPrice());
            stmt.setInt(9, item.getShop());
            stmt.setInt(10, item.getGender());
            stmt.setInt(11, item.getRating());
            stmt.setInt(1, item.getId());
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        return item;
    }

    public boolean deleteItem(int id) {
        String SQL = "Delete from item where id=?;";
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

