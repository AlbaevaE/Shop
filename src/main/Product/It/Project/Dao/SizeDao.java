package It.Project.Dao;

import java.sql.*;

public class SizeDao extends ProductDao{
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String url1 = "jdbc:postgresql:http://138.68.52.248:5432/gr11";
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

    public int getSize(int id) {
        String SQL = "Select id from sizes";
        int Id =0;
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            ResultSet rs = stmt.executeQuery(SQL);{
               while (rs.next()){
                   Id = rs.getInt("id");
               }
            }

        }
        catch (SQLException ex){
                 ex.getMessage();
        }
        return id;
    }

    public int getAllSizes(int id){
        String SQL = "Select * from sizes ";
        int Id = 0;
        try(Connection conn  = connect();
        PreparedStatement stmt = conn.prepareStatement(SQL)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
            ResultSet rs = stmt.executeQuery();{
                while (rs.next()){
                    Id = rs.getInt("id");
                }
            }
        }catch (SQLException ex){
            ex.getMessage();
        }
        return id;
    }

}
