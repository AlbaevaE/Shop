package It.Project.Dao;

import It.Project.Model.Size;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Size> getAllSizes(){
        String SQL = "select * from sizes";
        List<Size>size = new ArrayList<>();
        try(Connection conn = connect();
        PreparedStatement stmt = conn.prepareStatement(SQL)){
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                size.add(new Size(rs.getInt("id"),rs.getString("name")));
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return size;
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

//    public Size getSizesName(String sizes) {
//        String SQL = "select name from sizes where id = ?";
//        Size size = new Size();
//        try (Connection conn = connect();
//             PreparedStatement stmt = conn.prepareStatement(SQL)) {
//            stmt.setString(1, sizes);
//            ResultSet rs = stmt.executeQuery(SQL);
//            {
//                while (rs.next()) {
//                    String name = rs.getString("name");
//                    size.setSize(name);
//                }
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        System.out.println(size);
//        return size;
//
//    }

    public Size updateSize(Size name) {
        String SQL = "update name set name = ? where id = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, name.getSize());
            stmt.setInt(2, name.getId());
            stmt.execute();
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return name;
    }

    public boolean deleteSize(int id) {
        String SQL = "delete  from sizes where id = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return true;

    }

    public boolean addSize(Size size) {
        String SQL = "insert into sizes (name) values (?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, size.getSize());
            stmt.execute();
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return true;
    }

}
