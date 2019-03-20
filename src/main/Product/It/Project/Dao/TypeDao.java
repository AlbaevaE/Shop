package It.Project.Dao;

import java.sql.*;
import java.util.List;

import It.Project.Model.Type;


public class TypeDao {
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
        String SQL = "Select id , name , parent_type_id from type_product where id = ?;";

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

    public List<Type> getAllType(){

    }

    public Type addType(Type type){
        String SQL = "Insert into type_product(name) values(?);";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.setString(1, type.getName());
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        return type;
    }

    public Type updateType(Type type){
        String SQL = "Update type_product set name=? where id = ?;";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)
        ) {
            stmt.setString(1,type.getName());
            stmt.setInt(2, type.getId());
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        return type;
    }

    public boolean deleteType(int id){
        String SQL = "Delete from type_product where id=?;";
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