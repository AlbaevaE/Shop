package It.Project.Dao;

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

    public Size getSizesName(String sizes) {
        String SQL = "select name from sizes where name = ?";
        Size size = new Size();
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, sizes);
            ResultSet rs = stmt.executeQuery(SQL);
            {
                while (rs.next()) {
                    String name = rs.getString("name");
                    size.setSize(name);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(size);
        return size;

    }

    public Size updateSize(Size name) {
        String SQL = "update name from sizes where name = ?";
        Size size1 = new Size();
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, name.size);
            ResultSet rs = stmt.executeQuery(SQL);
            {
                while (rs.next()) {
                    String name1 = rs.getString("name");
                    size1.setSize(name1);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(size1);
        return size1;
    }

    public boolean deleteSize(Size sizes) {
        String SQL = "delete id from sizes where id = ?";
        Size size = new Size();
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, sizes.id);
            ResultSet rs = stmt.executeQuery(SQL);
            {
                while (rs.next()) {
                    int Id = rs.getInt(1);
                    size.setId(Id);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(size);
        return true;

    }

    public boolean addSize(String size){
        String SQL = "insert into sizes (name) values (?)";
        Size sizes = new Size();
        try(Connection conn = connect();
        PreparedStatement stmt = conn.prepareStatement(SQL)){
            stmt.setString(1,size);
            ResultSet rs = stmt.executeQuery(SQL);{
                while(rs.next()){
                    String name = rs.getString("name");

                }
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(sizes);
        return true;
    }

}
