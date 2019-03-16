package It.Project.Dao;

import It.Project.Model.Color;
import It.Project.Model.Size;

import java.sql.*;

public class SizeDao extends ProductDao {

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

    public Size getSize(int id) {
        String SQL = "Select id, name from sizes where id = ?;";
        Size size = new Size();

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                size.setId(rs.getInt("id"));
                size.setSize(rs.getString("name"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        return size;
    }

    public  int getAllSizes(Size sizes) {
        String SQL = "select * from sizes";
        int Id = 0;
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, sizes.id);
            stmt.setString(2, sizes.size);
            stmt.executeUpdate();
            ResultSet rs = stmt.executeQuery(SQL);
            {
                while(rs.next()) {
                    rs.getInt("id");
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return Id;

    }

}
