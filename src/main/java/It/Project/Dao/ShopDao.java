//
//package It.Project.Dao;
//
//
//import It.Project.Model.Shop;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ShopDao {
//    private static final String url = "jdbc:postgresql://138.68.52.248:5432/gr11";
//    private static final String user = "gruppa11";
//    private static final String password = "1e23qwe34";
//
//    public Connection connect() {
//        Connection conn = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            conn = DriverManager.getConnection(url, user, password);
//
//            System.out.println("Connected to the PostgreSQL server successfully.");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
//
//
//    public Shop getShop(int id) {
//        String SQL = "Select id,name,passwords,phone_number,email,address from shop where id = ?;";
//        Shop shop = new Shop();
//
//        try (Connection conn = connect();
//             PreparedStatement stmt = conn.prepareStatement(SQL)
//        ) {
//            stmt.setInt(1, id);
//            stmt.execute();
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                shop.setId(rs.getInt("id"));
//                shop.setName(rs.getString("name"));
//                shop.setPassword(rs.getString("password"));
//                shop.setEmail(rs.getString("email"));
//                shop.setAdress(rs.getString("address"));
//                System.out.println(shop);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            System.out.println("Error");
//        }
//        return shop;
//
//    }
//
//    public boolean registerShop(Shop reg) {
//        String SQL = "insert into shop (name, passwords, phone_number, email, address) values (?,?,?,?,?);";
//        try (Connection conn = connect();
//             PreparedStatement stmt = conn.prepareStatement(SQL)
//        ) {
//            stmt.setString(1, reg.getName());
//            stmt.setString(2, reg.getPassword());
//            stmt.setString(3, reg.getNumber());
//            stmt.setString(4, reg.getEmail());
//            stmt.setString(5, reg.getAdress());
//            stmt.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            return false;
//        }
//        return true;
//    }
//
//    public boolean authorizeShop(Shop reg) {
//        String SQL = "select id from shop where login = ?";
//        int id = -1;
//        try (Connection conn = connect();
//             PreparedStatement stmt = conn.prepareStatement(SQL)
//        ) {
//            stmt.setString(1, reg.getName());
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next())
//                id = rs.getInt("id");
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            return false;
//        }
//        if (id == -1) {
//            return false;
//        }
//
//        return checkLoginAndPassword(reg, id);
//    }
//
//    public boolean checkLoginAndPassword(Shop reg, int shopId) {
//        String SQL = "select count(*) as cnt from shop where login = ? and passwords = ?";
//        int count = 0;
//        try (Connection conn = connect();
//             PreparedStatement stmt = conn.prepareStatement(SQL)
//        ) {
//            stmt.setString(1, reg.getName());
//            stmt.setString(2, reg.getPassword());
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                count = rs.getInt("cnt");
//            }
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            // Write Fail to Log
//            return false;
//        }
//        return true;
//    }
//
//    public List<Shop> getAllShop() {
//        String SQL = "Select * from shop;";
//        List<Shop> shops = new ArrayList<>();
//        try (Connection conn = connect();
//             PreparedStatement stmt = conn.prepareStatement(SQL)
//        ) {
//            stmt.execute();
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                shops.add(new Shop(rs.getInt("id"), rs.getString("login"), rs.getString("passwords"),
//                        rs.getString("phone_number") , rs.getString("email"),rs.getString("address")));
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            System.out.println("Error");
//        }
//        return shops;
//    }
//
//    public Shop updateShop(Shop shop) {
//        String SQL = "Update shop name = ?,phone_number=?,email=?,address=? where id = ?;";
//        try (Connection conn = connect();
//             PreparedStatement stmt = conn.prepareStatement(SQL)
//        ) {
//            stmt.setString(1, shop.getName());
//            stmt.setInt(2, shop.getId());
//            stmt.setString(3, shop.getNumber());
//            stmt.setString(4, shop.getEmail());
//            stmt.setString(5, shop.getAdress());
//            stmt.execute();
//            ResultSet rs = stmt.executeQuery();
//            rs.next();
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            System.out.println("Error");
//        }
//        return shop;
//    }
//
//    public Shop updatePasswordOfShop(Shop shop) {
//        String SQL = "Update shop set passwords=? where id=? and passwords=?;";
//        try (Connection conn = connect();
//             PreparedStatement stmt = conn.prepareStatement(SQL)
//        ) {
//            stmt.setString(1, shop.getNewPassword());
//            stmt.setInt(2, shop.getId());
//            stmt.setString(3, shop.getPassword());
//            stmt.execute();
//            ResultSet rs = stmt.executeQuery();
//            rs.next();
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            System.out.println("Error");
//        }
//        return shop;
//    }
//
//    public boolean deleteShop(int id) {
//        String SQL = "Delete from shop where id=?;";
//        try (Connection conn = connect();
//             PreparedStatement stmt = conn.prepareStatement(SQL)
//        ) {
//            stmt.setInt(1, id);
//            stmt.execute();
//            ResultSet rs = stmt.executeQuery();
//            rs.next();
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            System.out.println("Error");
//            return false;
//        }
//        return true;
//    }
//}