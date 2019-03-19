//package It.Project.Dao;
//
//import It.Project.Model.Color;
//
//import java.sql.*;
//
//public class ColorDao {
//
//    private static final String url = "jdbc:postgresql://138.68.52.248:5432/gr11";
//    private static final String user = "gruppa11";
//    private static final String password = "1e23qwe34";
//
//    public Connection connect() {
//        Connection conn = null;
//
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
//    public Color getColor(int id) {
//        String SQL = "Select id, color from color where id = ?;";
//        Color color = new Color();
//
//        try (Connection conn = connect();
//             PreparedStatement stmt = conn.prepareStatement(SQL)
//        ) {
//            stmt.setInt(1, id);
//            stmt.execute();
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                color.setId(rs.getInt("id"));
//                color.setColor(rs.getString("color"));
//                System.out.println(color);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            System.out.println("Error");
//        }
//        return color;
//    }
//}

