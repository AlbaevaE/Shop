package It.Project.Dao;

import java.sql.*;

public class TypeProductDao {
    // private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String url = "jdbc:postgresql:http://138.68.52.248:5432/gr11";
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


//    public void getParentType(int id){
//        String SQL = "Select name from type_product where id = ?;";
//        try(Connection conn = connect();
//            PreparedStatement stmt = conn.prepareStatement(SQL)
//            PreparedStatement stmt = conn.prepareStatement(SQL)
//        ) {
//            stmt.setInt(1,id);
//        }
//    }
//    public boolean getNews(String newsHeadline) {
//        String SQL = "Select n.news_headline , n.news_text from news n where news_headline=?;";
//        try (Connection conn = connect();
//             PreparedStatement stmt = conn.prepareStatement(SQL)
//        ) {
//            stmt.setString(1, newsHeadline);
//            stmt.executeUpdate();
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                System.out.println(rs.getString("news_headline") + "\n" +
//                        rs.getString("news_text"));
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            return false;
//        }
//        return true;
//    }

    //привет
}