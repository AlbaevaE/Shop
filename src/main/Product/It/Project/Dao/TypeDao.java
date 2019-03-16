package It.Project.Dao;

import java.sql.*;

import It.Project.Model.Type;


public class TypeDao {
    // private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String url = "jdbc:postgresql://138.68.52.248:5432/gr11";
    private static final String user = "gruppa11";
    private static final String password = "1e23qwe34";

    public  Connection connect() {
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

    public Type getType(int id) {
        String SQL = "Select id , name , type_product_id from type_product where id = ?;";

        Type type = new Type();
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                type.setId(rs.getInt("id"));
                type.setName(rs.getString("name"));
                type.setParentTypeId(rs.getString("parent_type_id"));
                System.out.println(type);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        return type;
    }
}